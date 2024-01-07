package com.fwai.ems.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SigninAns
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SigninAns {
		private String token;
}
