package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpDataElementMetaData;


/**
 * The Interface DataElementMetaDataRepository.
 */
public interface DataElementMetaDataRepository extends JpaRepository<DpDataElementMetaData, Integer>, DataElementMetaDataCustomRepository {	
	
}
