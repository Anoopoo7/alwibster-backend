/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.organization.persistance.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lxiya.xendercart.organization.persistance.entity.Organization;

public interface OrganizationRepository extends MongoRepository<Organization, String> {

    Organization findByCodeAndEnabledAndActive(String name, boolean b, boolean c);

}
