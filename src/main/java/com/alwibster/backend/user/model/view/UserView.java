/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.user.model.view;

import lombok.Data;

@Data
public class UserView {

    private String id;

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
