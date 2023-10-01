/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.organization.service;

import java.util.List;

public interface OrganizationService {

    List<String> getPermissionsByRoles(final String role);

}
