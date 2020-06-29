package com.example.ebean.test.demo.organization.repository;

import com.example.ebean.test.demo.organization.repository.model.Organization;
import io.ebean.Database;
import io.ebean.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizationRepository {

    @Autowired
    private Database database;

    public Organization findById(Long id) {
        return database.find(Organization.class).where().eq("id", id).findOne();
    }

    public List<Version<Organization>> findVersionsById(Long id) {
        return database.find(Organization.class).where().eq("id", id).findVersions();
    }

    public Organization save(Organization organization){
        database.save(organization);
        return organization;
    }

}
