package com.springboot.offers.crudoffers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.springboot.offers.crudoffers.dao.OfferRepository;
import com.springboot.offers.crudoffers.entity.Offer;

@Service
public class OfferServiceImpl implements OfferService {
	
	private OfferRepository offerRepository;
	
	@Autowired
	public OfferServiceImpl(@Qualifier("offerRepository")OfferRepository theOfferRepository) {
		offerRepository = theOfferRepository;
	}
	
	@Override
	public List<Offer> findAll() {
		return offerRepository.findAll();
	}

	@Override
	public Offer findByCode(int theCode) {
		Optional<Offer> result = offerRepository.findById(theCode);
		
		Offer theOffer = null;
		
		if(result.isPresent()) {
			theOffer = result.get();
		}else {
			//we didn't find the offer
			throw new RuntimeException("Did not find the offer by offer code: " + theCode);
		}
		return theOffer;
	}

	@Override
	public void save(Offer theOffer) {
		offerRepository.save(theOffer);
	}

	@Override
	public void deleteByCode(int theCode) {
		offerRepository.deleteById(theCode);
	}

	@Override
	public List<Offer> findAllByPriceAsc() {
        return offerRepository.findAllByPriceAsc();
	}

	@Override
	public List<Offer> findAllByPriceDesc() {
		 return offerRepository.findAllByPriceDesc();
	}

	@Override
	public List<Offer> findAllByName(String theName) {
		List<Offer> result = offerRepository.findAllByName(theName);
		
		
		if(!result.isEmpty()) {
			return result;
		}else {
			//we didn't find the offer
			throw new RuntimeException("Did not find the offer by offer name: " + theName);
		}
		
	}

}
