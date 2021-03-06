package com.example.inst.service;


import com.example.inst.model.User;
import com.example.inst.model.exceptions.*;

public interface UserService {



    void register(User user) throws DuplicateDataException;

    User login(String username, String password) throws NotFoundException, UnverifiedException;

    User changePassword(String username, String password, String newPassword) throws NotFoundException, AccessDeniedException;

    void sendCode(String username) throws NotFoundException;

    void recoverPassword(String username, String code, String password) throws NotFoundException, AccessDeniedException;

    void verify(String username, String code) throws NotFoundException, AccessDeniedException;

}
