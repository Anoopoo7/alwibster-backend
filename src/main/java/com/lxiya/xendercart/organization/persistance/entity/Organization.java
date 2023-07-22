/*
*   Copyright © 2023
*   This software is the intellectual property of Lxiyas. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.lxiya.xendercart.organization.persistance.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.lxiya.xendercart.core.BaseEntity;
import com.lxiya.xendercart.organization.model.views.OrganizationConfigurations;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "xen_organization")
public class Organization extends BaseEntity {

    private String code;

    private OrganizationConfigurations configurations;
}
