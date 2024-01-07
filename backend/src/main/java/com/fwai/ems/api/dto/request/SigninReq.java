package com.fwai.ems.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SigninReq
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SigninReq {
		private String email;
		private String password;
}
