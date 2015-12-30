package com.zed.bagofood.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Arnaud on 30/04/2015.
 */

import com.zed.bagofood.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByNameAndPassword(String name, String password);
    User findByNameProviderId(String nameProviderId);
    User findByName(String name);

}
