package com.university.planitoto.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.university.planitoto.models.Cabin;

public interface CabinRepository extends MongoRepository<Cabin, String> {
	List<Cabin> findByName(String name);
}
