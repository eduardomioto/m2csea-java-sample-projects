package br.com.mioto.cloud.controllers;

import br.com.mioto.cloud.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( value = "/users" )
@RestController
public class UserManagementController {

	private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);

	@RequestMapping( method = RequestMethod.GET )
	@ResponseBody
	public User getUser() {
		
		log.info("User Manager Service >> getUser");
		User user = new User();
		user.setUser("Usuario 12345");
		return user;
	}
}