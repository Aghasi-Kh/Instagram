package com.example.inst.service.impl;

import com.example.inst.model.User;
import com.example.inst.model.exceptions.*;
import com.example.inst.model.lsp.UserStatus;
import com.example.inst.repository.UserRepository;
import com.example.inst.service.UserService;
import com.example.inst.util.Generator;
import com.example.inst.util.Md5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.example.inst.util.Messages.*;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void register(User user) throws DuplicateDataException {
        User duplicate = userRepository.getByUsername(user.getUsername());
        DuplicateDataException.check(duplicate != null, DUPLICATE_USER_MESSAGE);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCode(Generator.getRandomDigits(5));
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);
    }


    @Override
    public User login(String username, String password) throws NotFoundException, UnverifiedException {
        User user = userRepository.getByUsername(username);
        NotFoundException.check(user == null || !passwordEncoder.matches(password, user.getPassword()), INVALID_CREDENTIALS_MESSAGE);
        UnverifiedException.check(user.getStatus() != UserStatus.ACTIVE, UNVERIFIED_MESSAGE);
        return user;

    }

    @Override
    public User changePassword(String username, String password, String newPassword) throws NotFoundException, AccessDeniedException {
        User user = userRepository.getByUsername(username);
        NotFoundException.check(user == null, USER_NOT_EXIST_MESSAGE);
        AccessDeniedException.check(!user.getPassword().equals(passwordEncoder.encode(password)), WRONG_PASSWORD_MESSAGE);
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        return user;
    }

    @Override
    @Transactional
    public void sendCode(String username) throws NotFoundException {
        User user = userRepository.getByUsername(username);
        NotFoundException.check(user == null, USER_NOT_EXIST_MESSAGE);
        user.setCode(Generator.getRandomDigits(5));
        userRepository.save(user);
    }

    @Override
    public void recoverPassword(String username, String code, String password) throws NotFoundException, AccessDeniedException {
        User user = userRepository.getByUsername(username);
        NotFoundException.check(user == null, USER_NOT_EXIST_MESSAGE);
        AccessDeniedException.check(!user.getCode().equals(code), WRONG_CODE_MESSAGE);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    @Override
    public void verify(String username, String code) throws NotFoundException, AccessDeniedException {
        User user = userRepository.getByUsername(username);
        NotFoundException.check(user == null, USER_NOT_EXIST_MESSAGE);
        AccessDeniedException.check(!user.getCode().equals(code), WRONG_CODE_MESSAGE);
        user.setStatus(UserStatus.ACTIVE);
        userRepository.save(user);
    }
}
