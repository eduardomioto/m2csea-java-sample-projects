package br.com.mioto.cloud.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.mioto.cloud.dao.ResponseTimeDAO;
import br.com.mioto.cloud.vo.Access;

@RequestMapping( value = "/access" )
@RestController
public class AccessManagerController {

	private static final Logger log = LoggerFactory.getLogger(AccessManagerController.class);

    @Autowired
    ResponseTimeDAO responseTimeDAO;

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public Access getAccess() {

		log.info("Access Manager Service >> user");
		final Access access = new Access();
		access.setUser("Usuario 1234 ");
		return access;
	}
}