package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpUser;


public interface UserRepository extends JpaRepository<DpUser, Integer>, UserCustomRepository {	
	
}
