package com.estoque.realcar.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;
    private String role;
}
