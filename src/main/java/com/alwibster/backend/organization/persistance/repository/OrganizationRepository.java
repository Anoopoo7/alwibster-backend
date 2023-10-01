/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.organization.persistance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alwibster.backend.organization.persistance.entity.Organization;

public interface OrganizationRepository extends MongoRepository<Organization, String> {

    Organization findByCodeAndEnabledAndActive(String name, boolean b, boolean c);

}
