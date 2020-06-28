package com.example.ebean.test;

import com.example.ebean.test.demo.organization.OrganizationConfig;
import com.example.ebean.test.demo.organization.model.OrganizationInformation;
import com.example.ebean.test.demo.organization.port.in.OrganizationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootTest(classes = OrganizationConfig.class)
@EnableAutoConfiguration
@ComponentScan("com.example.ebean.test.demo.organization")
public class OrganisationServiceTest {

    @Autowired
    private OrganizationService organizationService;

    @PostConstruct
    public void init(){
        organizationService.save(OrganizationInformation.builder().name("Org1").build());
    }

    @Test
    public void testFindById(){
        final OrganizationInformation byId = organizationService.findById(1L);
        System.out.println(byId);
    }
}
