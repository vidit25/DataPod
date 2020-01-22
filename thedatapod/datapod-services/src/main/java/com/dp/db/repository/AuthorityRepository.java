package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpAuthority;


public interface AuthorityRepository extends JpaRepository<DpAuthority, Integer>, AuthorityCustomRepository {    
	
	
}
