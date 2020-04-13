package com.errorcenter.api.services.interfaces;

import com.errorcenter.api.dto.UserRegisterDTO;
import com.errorcenter.api.models.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> findAll();

    UserRegisterDTO save(UserRegisterDTO dto);
}
