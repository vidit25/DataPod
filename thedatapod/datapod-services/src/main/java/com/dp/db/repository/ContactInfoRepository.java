package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpContactInfo;


/**
 * The Interface ContactInfoRepository.
 */
public interface ContactInfoRepository extends JpaRepository<DpContactInfo, Integer> {	
	
}
