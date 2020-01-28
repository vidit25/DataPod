package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpSubscriptionFeature;


/**
 * The Interface SubscriptionFeatureRepository.
 */
public interface SubscriptionFeatureRepository extends JpaRepository<DpSubscriptionFeature, Integer> {	
	
}
