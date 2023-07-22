/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.user.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.lxiya.xendercart.core.errors.UserErrors;
import com.lxiya.xendercart.core.patterns.Patters;

import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = UserErrors.FIRST_NAME_NULL)
    private String firstName;

    private String lastName;

    @NotBlank(message = UserErrors.EMAIL_NULL)
    @Pattern(regexp = Patters.EMAIL_REGEX, message = UserErrors.EMAIL_INVALID)
    private String email;

    @NotBlank(message = UserErrors.PASSWORD_NULL)
    private String password;

    @NotBlank(message = UserErrors.MOBILE_NULL)
    private String mobile;

}
