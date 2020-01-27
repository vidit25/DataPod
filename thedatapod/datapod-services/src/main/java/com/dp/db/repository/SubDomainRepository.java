package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpSubDomain;


/**
 * The Interface SubDomainRepository.
 */
public interface SubDomainRepository extends JpaRepository<DpSubDomain, Integer>, SubDomainCustomRepository {	
	
}
