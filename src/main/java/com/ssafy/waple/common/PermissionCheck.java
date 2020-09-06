package com.ssafy.waple.common;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.google.gson.Gson;

import com.ssafy.waple.error.exception.AccessDeniedException;
import com.ssafy.waple.user.dto.UserDto;

@Component
public class PermissionCheck {
	private static final Logger logger = LoggerFactory.getLogger(PermissionCheck.class);

	public UserDto check(String token) {
		logger.debug("권한 체크 호출");
		try {
			DecodedJWT jwt = JWT.decode(token);

			// 헤더 규약 오류시
			if (!jwt.getAlgorithm().equals("HS256") || !jwt.getType().equals("JWT")) {
				logger.debug("권한이 없습니다");
				throw new AccessDeniedException("권한이 없습니다");
			}
			Gson gson = new Gson();
			UserDto user = gson.fromJson(new String(Base64.getDecoder().decode(jwt.getPayload())), UserDto.class);
			return user;
		} catch (JWTDecodeException e) {
			logger.debug("권한이 없습니다");
			throw new AccessDeniedException("권한이 없습니다");
		}
	}
}
