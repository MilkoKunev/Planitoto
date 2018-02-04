package com.university.planitoto.repositories;

import com.university.planitoto.models.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RouteRepository extends MongoRepository<Route, String> {
   Route findByName(String name);
}
