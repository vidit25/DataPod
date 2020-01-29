package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpContactInfo;


/**
 * The Interface AddressRepository.
 */
public interface AddressRepository extends JpaRepository<DpContactInfo, Integer> {	
	
}
