package com.university.planitoto.repositories;

import com.university.planitoto.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

    User findByFacebookId(String facebookId);
}
