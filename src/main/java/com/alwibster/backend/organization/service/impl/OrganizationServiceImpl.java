/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.organization.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alwibster.backend.core.errors.TokenErrors;
import com.alwibster.backend.organization.helper.OrganizationHelper;
import com.alwibster.backend.organization.model.enums.OrganizationCodes;
import com.alwibster.backend.organization.model.views.RoleConfiguration;
import com.alwibster.backend.organization.persistance.dao.OrganizationDao;
import com.alwibster.backend.organization.persistance.entity.Organization;
import com.alwibster.backend.organization.service.OrganizationService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public List<String> getPermissionsByRoles(final String role) {
        Organization organization = organizationDao.getOrganizationRepository()
                .findByCodeAndEnabledAndActive(OrganizationCodes.userRolesConfigurations.name(), true, true);
        if (null != organization) {
            List<Object> configurations = organization.getConfigurations().getDefaultConfig();
            return configurations.stream()
                    .map(configuration -> OrganizationHelper.toRoleConfiguration(configuration))
                    .filter(roleConfiguration -> roleConfiguration.getRole().equals(role))
                    .findFirst()
                    .map(RoleConfiguration::getPermissions)
                    .orElse(Collections.emptyList());
        }
        log.error("907EA99E-964A-467C-BFE2-409DE960D195 no Permission granded for the role : {}", role);
        throw new RuntimeException(TokenErrors.PERMISSION_DENIED);
    }

}
