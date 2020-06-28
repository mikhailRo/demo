package com.example.ebean.test.demo.organization.port.out;

import com.example.ebean.test.demo.organization.model.OrganizationInformation;

public interface QueryOrganizations {
    OrganizationInformation findById(Long id);

    OrganizationInformation save(OrganizationInformation organizationInformation);

}
