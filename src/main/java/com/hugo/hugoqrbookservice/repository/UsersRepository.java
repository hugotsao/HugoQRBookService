package com.hugo.hugoqrbookservice.repository;

import com.hugo.hugoqrbookservice.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {
    Users findByUsername(String username);
}
