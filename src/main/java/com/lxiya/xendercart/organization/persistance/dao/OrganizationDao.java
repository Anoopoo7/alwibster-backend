/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.organization.persistance.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lxiya.xendercart.organization.persistance.repository.OrganizationRepository;

@Component
public class OrganizationDao {

    @Autowired
    private OrganizationRepository organizationRepository;

    public OrganizationRepository getOrganizationRepository() {
        return organizationRepository;
    }

}
