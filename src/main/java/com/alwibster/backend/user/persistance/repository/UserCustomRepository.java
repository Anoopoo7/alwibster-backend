package com.alwibster.backend.user.persistance.repository;

import com.alwibster.backend.user.persistance.entity.User;

public interface UserCustomRepository {

    User findUserWithEmailOrMobile(String email, String mobile);

}
