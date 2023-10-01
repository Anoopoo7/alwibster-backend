/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.core.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtils {

    public static boolean isBlank(final String s) {
        return null != s ? s.trim().isEmpty() : true;
    }
}
