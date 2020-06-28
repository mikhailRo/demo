package com.example.ebean.test.demo.organization.repository.conf;

import io.ebean.Database;
import io.ebean.DatabaseFactory;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.DatabaseConfig;
import io.ebean.config.MatchingNamingConvention;
import io.ebean.config.dbplatform.DatabasePlatform;
import io.ebean.config.dbplatform.IdType;
import io.ebean.config.dbplatform.mariadb.MariaDbHistorySupport;
import io.ebean.spring.txn.SpringJdbcTransactionManager;
import io.ebeaninternal.api.SpiEbeanServer;
import io.ebeaninternal.dbmigration.DdlGenerator;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("test")
public class EbeanTestConf {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;
    @Value("${spring.datasource.url}")
    private String dataBaseUrl;
    @Value("${spring.datasource.username}")
    private String dataBaseUserName;
    @Value("${spring.datasource.password}")
    private String getDataPassword;

    @Bean
    public DataSource getTestDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClass);
        dataSourceBuilder.url(dataBaseUrl);
        dataSourceBuilder.username(dataBaseUserName);
        dataSourceBuilder.password(getDataPassword);
        return dataSourceBuilder.build();
    }

    @SneakyThrows
    @Bean
    public DatabaseConfig ebeanServerConfig(DataSource dataSource) {
        DatabaseConfig config = new DatabaseConfig();
        config.setName("ebeanServer");
        //config.setHistoryTableSuffix("history");
        config.setNamingConvention(new MatchingNamingConvention());
        config.setDefaultServer(true);
        config.setDataTimeZone("UTC");
        config.setDataSource(dataSource);
        config.setDdlGenerate(true);
        config.setDdlRun(true);
        config.setDdlExtra(false);
        config.setDdlSeedSql("schema.sql");
        config.setDdlInitSql("init-schema.sql");

        //config.addPackage("com.clevergang.dbtests.repository.impl.ebean.entities");
        config.setExternalTransactionManager(new SpringJdbcTransactionManager());
        //config.setExpressionNativeIlike(true);
        config.loadFromProperties();


        DatabasePlatform dbPlatform = new DatabasePlatform();
        dbPlatform.getDbIdentity().setIdType(IdType.IDENTITY);
        dbPlatform.getDbIdentity().setSupportsGetGeneratedKeys(true);
        dbPlatform.getDbIdentity().setSupportsSequence(false);
        dbPlatform.getDbIdentity().setSupportsIdentity(true);
        dbPlatform.setHistorySupport(new MariaDbHistorySupport());
//        config.setDatabasePlatform(dbPlatform);
//        final EbeanServer ebeanServer = EbeanServerFactory.create(config);
//        final DdlGenerator ddlGenerator = new DdlGenerator((SpiEbeanServer) ebeanServer, config);
//        ddlGenerator.runScript(((SpiEbeanServer) ebeanServer).getTransactionManager().getQueryPlanConnection(),true,);
        return config;
    }

    @Bean
    public Database ebeanDatabase(DatabaseConfig databaseConfig) {

        return DatabaseFactory.create(databaseConfig);
    }
}
