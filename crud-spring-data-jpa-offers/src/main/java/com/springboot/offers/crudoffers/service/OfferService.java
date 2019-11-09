package com.springboot.offers.crudoffers.service;

import java.util.List;

import com.springboot.offers.crudoffers.entity.Offer;

public interface OfferService {
	
	public List<Offer> findAll();
	
	public List<Offer> findAllByPriceAsc();
	
	public List<Offer> findAllByPriceDesc();
	
	public List<Offer> findAllByName(String theName);
	
	public Offer findByCode(int theCode);
	
	public void save(Offer theOffer);
	
	public void deleteByCode(int theCode);	

}
