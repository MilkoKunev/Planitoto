package com.university.planitoto.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.university.planitoto.models.Hike;

public interface HikeRepository extends MongoRepository<Hike, String>{
	Hike findByName(String name);
}
