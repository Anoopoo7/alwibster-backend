/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.core;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class BaseEntity {

    @Id
    private String id;

    private boolean active;

    private boolean enabled;

    private String modifiedBy;

    private String createdBy;

    private Date createdDate = new Date();

    private Date updatedDate = new Date();
}
