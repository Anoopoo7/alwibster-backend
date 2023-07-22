/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.core.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtils {

    public static boolean isBlank(String s) {
        return s.trim().isEmpty();
    }
}
