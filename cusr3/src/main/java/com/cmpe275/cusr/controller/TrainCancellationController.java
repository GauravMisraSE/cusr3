package com.cmpe275.cusr.controller;


import com.cmpe275.cusr.service.TrainCancellationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trainCancellation")
public class TrainCancellationController {

	@Autowired
	TrainCancellationService trainCancellationService;

	// adds a cancelled train to the table, all reservations(if any) for that train are affected.
	// availability for this train will return cancelled train

	
}
