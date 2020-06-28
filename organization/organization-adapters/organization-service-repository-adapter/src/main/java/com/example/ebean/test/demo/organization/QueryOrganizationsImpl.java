package com.example.ebean.test.demo.organization;

import com.example.ebean.test.demo.organization.model.OrganizationInformation;
import com.example.ebean.test.demo.organization.port.out.QueryOrganizations;
import com.example.ebean.test.demo.organization.repository.OrganizationRepository;
import com.example.ebean.test.demo.organization.repository.model.Organization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QueryOrganizationsImpl implements QueryOrganizations {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    @Qualifier("organizationModelMapper")
    private ModelMapper modelMapper;

    @Override
    public OrganizationInformation findById(Long id) {
        return getOrgInfoFromOrganization(organizationRepository.findById(id));
    }

    @Override
    public OrganizationInformation save(OrganizationInformation organizationInformation) {
        return  getOrgInfoFromOrganization(organizationRepository.save(getOrganizationFromInfo(organizationInformation)));
    }

    private OrganizationInformation getOrgInfoFromOrganization(Organization organization){
        return modelMapper.map(organization,OrganizationInformation.class);
    }

    private Organization getOrganizationFromInfo(OrganizationInformation organizationInformation){
        return modelMapper.map(organizationInformation,Organization.class);
    }
}
