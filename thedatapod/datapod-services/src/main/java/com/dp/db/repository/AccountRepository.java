package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpAccount;


/**
 * The Interface AccountRepository.
 */
public interface AccountRepository extends JpaRepository<DpAccount, Integer>, AccountCustomRepository {	
	
}
