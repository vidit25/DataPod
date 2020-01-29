package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpSubscriptionType;


/**
 * The Interface SubscriptionTypeRepository.
 */
public interface SubscriptionTypeRepository extends JpaRepository<DpSubscriptionType, Integer>, SubscriptionTypeCustomRepository {	
	
}
