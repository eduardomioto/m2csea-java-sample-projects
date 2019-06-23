package br.com.mioto.cloud.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mioto.cloud.vo.Fare;

@RequestMapping( value = "/fare" )
@RestController
public class InventoryController {

	private static final Logger log = LoggerFactory.getLogger(InventoryController.class);

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Fare getFare() {
		
		log.info("Fare Rest Service >> getFare");
		Fare fare = new Fare();
		fare.setPrice(32.54);
		return fare;
	}
}