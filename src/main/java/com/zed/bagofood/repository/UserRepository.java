package com.zed.bagofood.repository;

/**
 * Created by Arnaud on 30/04/2015.
 */

import com.zed.bagofood.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Collection<User> findByName(String name);
}
