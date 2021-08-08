package com.example.inst.model;

import com.example.inst.model.lsp.UserStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    private String code;

    @NotBlank(message = "Username must not be blank")
    @Column(name = "username", nullable = false, unique = true)
    private String username;


    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, message = "Password must be more then 6 characters")
    private String password;

    @Enumerated
    @Column(name = "status", nullable = false)
    private UserStatus status;





}
