package com.lxiya.xendercart.security.model.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenView {

    private String access;

    private String refresh;

    private String roles;
}
