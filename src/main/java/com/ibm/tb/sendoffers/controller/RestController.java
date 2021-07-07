package com.ibm.tb.sendoffers.controller;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.ibm.tb.sendoffers.api.model.SendAllOfferDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/sendoffers")
public class RestController {

	@RequestMapping(method=RequestMethod.GET, path="/get")
	public ResponseEntity<List<SendAllOfferDetails>> getOffers(@RequestParam(required=false) Integer customerId) {

		System.out.println("send offer method get transactions..... start");
		List<SendAllOfferDetails> allOffers = null;
		
		System.out.println("send offer method get transactions..... END");
		return new ResponseEntity<>(allOffers, HttpStatus.OK);
	}
}
