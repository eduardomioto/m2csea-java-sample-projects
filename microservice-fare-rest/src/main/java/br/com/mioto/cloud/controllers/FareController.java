package br.com.mioto.cloud.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mioto.cloud.dao.ResponseTimeDAO;
import br.com.mioto.cloud.vo.Fare;

@RequestMapping( value = "/fare" )
@RestController
public class FareController {

	private static final Logger log = LoggerFactory.getLogger(FareController.class);

    @Autowired
    ResponseTimeDAO responseTimeDAO;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Fare getFare() {

        log.info("Fare Rest Service >> getFare");

		final Fare fare = new Fare();
		fare.setPrice(32.54);
		return fare;
	}
}