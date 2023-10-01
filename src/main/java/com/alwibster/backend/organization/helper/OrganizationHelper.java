/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.organization.helper;

import com.alwibster.backend.organization.model.views.RoleConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrganizationHelper {

    public static RoleConfiguration toRoleConfiguration(Object configurations) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(configurations, RoleConfiguration.class);
    }
}
