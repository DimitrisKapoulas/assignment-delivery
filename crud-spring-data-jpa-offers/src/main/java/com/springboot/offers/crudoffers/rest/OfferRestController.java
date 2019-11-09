package com.springboot.offers.crudoffers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.offers.crudoffers.entity.Offer;
import com.springboot.offers.crudoffers.service.OfferService;

@RestController
@RequestMapping("/api")
public class OfferRestController {
	
	private OfferService offerService;
	
	@Autowired
	public OfferRestController (OfferService theOfferService) {
		offerService = theOfferService;
	}
	
	//expose "/offers" and return list of offers
	@GetMapping("/offers")
	public List<Offer> findAll(){
		return offerService.findAll();
	}
	
	@GetMapping("/offers/asc")
	public List<Offer> findAllByPriceAsc(){
		return offerService.findAllByPriceAsc();
	}
	
	@GetMapping("/offers/desc")
	public List<Offer> findAllByPriceDesc(){
		return offerService.findAllByPriceDesc();
	}
	
	@GetMapping("/offers/findByName/{offerName}")
	public List<Offer> findAllByName(@PathVariable String offerName){
		List<Offer> theOffer = offerService.findAllByName(offerName);

		if(theOffer ==null) {
			throw new RuntimeException("Offer name not found - " + offerName);
		}
		
		return theOffer;
		
	}
	
	//add mapping for GET /offers/{offerCode}
	@GetMapping("/offers/{offerCode}")
	public Offer getOffer(@PathVariable int offerCode) {
		Offer theOffer = offerService.findByCode(offerCode);
		
		if(theOffer ==null) {
			throw new RuntimeException("Offer code not found - " + offerCode);
		}
		
		return theOffer;
	}
	
	//add mapping for POST /offers - add new offer
	
	@PostMapping("/offers")
	public Offer addOffer(@RequestBody Offer theOffer) {
		
		//just in case we accidentally insert id in JSON
		theOffer.setCode(0);
		
		offerService.save(theOffer);
		
		return theOffer;
	}
	
	//add mapping for PUT /offers - update existing offer
	@PutMapping("/offers")
	public Offer updateOffer(@RequestBody Offer theOffer) {
		
		offerService.save(theOffer);
		
		return theOffer;
	}
	
	//add mapping for DELETE /offers/{offerCode} - delete offer
	@DeleteMapping("/offers/{offerCode}")
	public String deleteOffer(@PathVariable int offerCode) {
		
		Offer tempOffer = offerService.findByCode(offerCode);
		
		//throw exception if null
		if (tempOffer == null) {
			throw new RuntimeException("Offer code not found - " + offerCode);
		}
		
		offerService.deleteByCode(offerCode);
		
		return "Deleted offer code - " + offerCode;
				
	}
}



