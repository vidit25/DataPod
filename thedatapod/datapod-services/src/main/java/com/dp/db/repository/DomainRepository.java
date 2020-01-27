package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpDomain;


/**
 * The Interface DomainRepository.
 */
public interface DomainRepository extends JpaRepository<DpDomain, Integer>, DomainCustomRepository {	
	
}
