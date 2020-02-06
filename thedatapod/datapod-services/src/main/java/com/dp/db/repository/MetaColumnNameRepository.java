package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpMetaColumnname;


/**
 * The Interface MetaColumnNameRepository.
 */
public interface MetaColumnNameRepository extends JpaRepository<DpMetaColumnname, Integer> {	
	
}
