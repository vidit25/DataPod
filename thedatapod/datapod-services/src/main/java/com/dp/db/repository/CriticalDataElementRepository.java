package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpCriticalDataElement;


/**
 * The Interface UserRepository.
 */
public interface CriticalDataElementRepository extends JpaRepository<DpCriticalDataElement, Integer>, CriticalDataElementCustomRepository {	
	
}
