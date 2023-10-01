/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.organization.model.views;

import java.util.List;

import lombok.Data;

@Data
public class RoleConfiguration {

    private String role;

    private List<String> permissions;
}
