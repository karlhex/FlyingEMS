package com.fwai.ems.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SignupReq
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupReq {
		private String username;
		private String password;
		private String email;
		private String description;
}
