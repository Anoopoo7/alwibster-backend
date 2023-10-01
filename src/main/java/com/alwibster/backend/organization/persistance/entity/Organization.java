/*
*   Copyright © 2023
*   This software is the intellectual property of Alwibster. 
*   Unauthorized use, reproduction, or distribution is strictly prohibited. 
*
*   Anoop ss
*/
package com.alwibster.backend.organization.persistance.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.alwibster.backend.core.BaseEntity;
import com.alwibster.backend.organization.model.views.OrganizationConfigurations;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "xen_organization")
public class Organization extends BaseEntity {

    private String code;

    private OrganizationConfigurations configurations;
}
