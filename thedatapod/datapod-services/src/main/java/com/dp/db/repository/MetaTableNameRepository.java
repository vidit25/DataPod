package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpMetaTablename;


/**
 * The Interface MetaTableNameRepository.
 */
public interface MetaTableNameRepository extends JpaRepository<DpMetaTablename, Integer> {	
	
}
