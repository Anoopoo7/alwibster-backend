/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.organization.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxiya.xendercart.organization.model.views.RoleConfiguration;

public class OrganizationHelper {

    public static RoleConfiguration toRoleConfiguration(Object configurations) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(configurations, RoleConfiguration.class);
    }
}
