package com.fwai.ems.service;

import com.fwai.ems.api.dto.UserRequestDto;
import com.fwai.ems.persistence.model.UserDef;
import com.fwai.ems.persistence.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService  {

		private final UserRepository userRepository;
		Logger logger = LoggerFactory.getLogger(UserService.class);

		@Autowired
		public UserService(UserRepository userRepository) {
				this.userRepository = userRepository;
		}

		public UserRequestDto getUserDtoById(Long id)  {
				UserDef userDef = userRepository.findFirstById(id);

				logger.info("getUserDtoById");

				return UserRequestDto.builder()
						.username(userDef.getUsername())
						.email(userDef.getEmail())
						.build();
		}
}
