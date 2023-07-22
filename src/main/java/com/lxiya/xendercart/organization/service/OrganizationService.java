/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.organization.service;

import java.util.List;

public interface OrganizationService {

    List<String> getPermissionsByRoles(final String role);

}
