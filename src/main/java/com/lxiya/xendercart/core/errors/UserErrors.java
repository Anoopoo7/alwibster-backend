/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.core.errors;

import org.springframework.stereotype.Component;

@Component
public class UserErrors {

    public static final String FIRST_NAME_NULL = "First name should not be empty";

    public static final String EMAIL_NULL = "Email should not be empty";

    public static final String EMAIL_INVALID = "Email is not valid";

    public static final String PASSWORD_NULL = "Password should not be empty";

    public static final String MOBILE_NULL = "Mobile should not be empty";

    public static final String DUPLICATE_EMAIL_OR_MOBILE = "User is already Registered with this Email or Mobile";

    public static final String USER_NOT_FOUND = "User not found";

    public static final String USER_ID_INVALID = "User id not found";

}
