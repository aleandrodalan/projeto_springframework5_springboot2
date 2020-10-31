package com.dalan.projeto1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.dalan.projeto1.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

	@Query("{'email' : ?0}")
	User findByEmailQualquerCoisa(String email);
	
	User findByNameIgnoreCaseLike(String name);
}