package br.com.mioto.cloud.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mioto.cloud.dao.ResponseTimeDAO;
import br.com.mioto.cloud.services.AccessManagerService;
import br.com.mioto.cloud.vo.Basket;

@RequestMapping( value = "/basket" )
@RestController
public class BasketController {

	private static final Logger log = LoggerFactory.getLogger(BasketController.class);

	@Autowired
	private AccessManagerService accessManagerService;

    @Autowired
    ResponseTimeDAO responseTimeDAO;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Basket getBasket() {

		log.info("Basket Rest Service >> getBasket");
		final Basket fare = new Basket();
		fare.setPrice(32.54);
		return fare;
	}
}