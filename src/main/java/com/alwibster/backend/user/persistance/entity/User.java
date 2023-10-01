/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.user.persistance.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.alwibster.backend.core.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "xen_users")
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String mobile;

    private boolean isAnonymous;

    private String verified;

    private boolean firstOrder;

    private boolean enableNotifications;

    private String role;
}
