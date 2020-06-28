package com.example.ebean.test.demo.organization.port.in;

import com.example.ebean.test.demo.organization.model.OrganizationInformation;

public interface OrganizationService {

    OrganizationInformation findById(Long orgId);

    OrganizationInformation save(OrganizationInformation organizationInformation);
}
