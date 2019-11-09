package com.springboot.offers.crudoffers.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.springboot.offers.crudoffers.entity.Offer;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
	
	@Query("FROM Offer ORDER BY price ASC")
    List<Offer> findAllByPriceAsc();
	
	@Query("FROM Offer ORDER BY price DESC")
    List<Offer> findAllByPriceDesc();
	
	@Query("FROM Offer WHERE name = ?1")
	List<Offer> findAllByName(String theName);
	
	
}
