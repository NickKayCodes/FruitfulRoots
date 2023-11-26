package com.krath.fruitfulroots.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id; //primary key for db
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
}
