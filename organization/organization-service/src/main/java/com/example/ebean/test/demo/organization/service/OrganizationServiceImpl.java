package com.example.ebean.test.demo.organization.service;

import com.example.ebean.test.demo.organization.model.OrganizationInformation;
import com.example.ebean.test.demo.organization.port.in.OrganizationService;
import com.example.ebean.test.demo.organization.port.out.QueryOrganizations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private QueryOrganizations queryOrganizations;


    @Override
    public OrganizationInformation findById(Long orgId) {
        return queryOrganizations.findById(orgId);
    }

    @Override
    public OrganizationInformation save(OrganizationInformation organizationInformation) {
        return queryOrganizations.save(organizationInformation);
    }
}
