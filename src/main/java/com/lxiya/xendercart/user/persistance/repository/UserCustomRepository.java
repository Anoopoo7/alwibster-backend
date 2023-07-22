package com.lxiya.xendercart.user.persistance.repository;

import com.lxiya.xendercart.user.persistance.entity.User;

public interface UserCustomRepository {

    User findUserWithEmailOrMobile(String email, String mobile);

}
