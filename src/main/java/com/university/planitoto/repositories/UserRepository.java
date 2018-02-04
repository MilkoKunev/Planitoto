package com.university.planitoto.repositories;

import com.university.planitoto.models.UserBean;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserBean, String>{
    UserBean findByFacebookId(String facebookId);
}
