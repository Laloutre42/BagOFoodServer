package com.zed.bagofood.repository;

/**
 * Created by Arnaud on 30/04/2015.
 */

import com.zed.bagofood.model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByNameAndPassword(String name, String password);
    User findByName(String name);

}
