package com.fwai.ems.service.interfaces;

import com.fwai.ems.api.dto.request.SigninReq;
import com.fwai.ems.api.dto.response.SigninAns;

/**
 * AuthenticationService
 */
public interface AuthenticationService {

		SigninAns signin(SigninReq request);

}
