package com.fwai.ems.api.controller;

import com.fwai.ems.api.dto.UserRequestDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

		private final UserService userService;

		Logger logger = LoggerFactory.getLogger(UserController.class);

		@Autowired
		public UserController(UserService userService) {
				this.userService = userService;
		}

		@GetMapping(value = "/{id}")
		public ResponseEntity<UserRequestDto> getUserById(@PathVariable Integer id) {
				logger.info("getUserById");
				UserRequestDto userRequestDto = userService.getUserDtoById(id);
				logger.debug("get dto");

				return ResponseEntity.ok(userRequestDto);
		}
}
