package com.test.webtechproject.data;

import com.test.webtechproject.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDAO extends CrudRepository<User, Integer> {
    @Query(value = "SELECT u from User u WHERE u.mail=?1")
    Optional<User> findByEMail(String Email);
    }

