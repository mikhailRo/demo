package com.example.ebean.test.demo.organization.repository;

import com.example.ebean.test.demo.organization.repository.model.Organization;
import io.ebean.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationRepository {

    @Autowired
    private Database database;

    public Organization findById(Long id) {
        return database.find(Organization.class).where().eq("id", id).findOne();
    }

    public Organization save(Organization organization){
        database.save(organization);
        return organization;
    }

}
