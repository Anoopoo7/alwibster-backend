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
public class TokenErrors {

    public static final String USER_TYPE_MISSING = "User type should not be empty";

    public static final String UNAUTHERIZED = "UnAutherized";

}
