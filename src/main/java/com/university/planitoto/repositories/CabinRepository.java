package com.university.planitoto.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.university.planitoto.models.Cabin;

public interface CabinRepository extends MongoRepository<Cabin, String> {
	Cabin findByName(String name);
}
