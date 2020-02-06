package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpModel;


/**
 * The Interface ModelRepository.
 */
public interface ModelRepository extends JpaRepository<DpModel, Integer>{	
	
}
