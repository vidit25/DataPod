package com.dp.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dp.db.model.DpUserSubscription;


/**
 * The Interface AddressRepository.
 */
public interface UserSubscriptionRepository extends JpaRepository<DpUserSubscription, Integer>, UserSubscriptionCustomRepository {	
	
}
