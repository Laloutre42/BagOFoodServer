package com.zed.bagofood.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Arnaud on 03/05/2015.
 */
@Data
@Document
public class User {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    private UserRole role = UserRole.USER;

    @NotBlank
    private String email;

}