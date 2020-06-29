package com.example.ebean.test.demo.organization.repository;

import com.example.ebean.test.demo.organization.repository.conf.EbeanConf;
import com.example.ebean.test.demo.organization.repository.conf.EbeanTestConf;
import com.example.ebean.test.demo.organization.repository.model.Organization;
import io.ebean.Version;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootTest(classes = EbeanTestConf.class)
@EnableAutoConfiguration
@ComponentScan("com.example.ebean.test")
public class OrganizationRepositoryTest {

    @Autowired
    OrganizationRepository organizationRepository;

    @PostConstruct
    public void init(){
        organizationRepository.save(Organization.builder().name("test-db").build());
    }

    @Test
    public void getOrg(){
        final Organization byId = organizationRepository.findById(1L);
        System.out.println(byId);
    }

    @Test
    public void getVersions(){
        final List<Version<Organization>> byId = organizationRepository.findVersionsById(1L);
        System.out.println(byId);
    }


}
