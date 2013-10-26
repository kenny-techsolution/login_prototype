package com.dovesquare.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public class SpringSecuritySigninAdapter implements SignInAdapter {
	public String signIn(String localUserId, Connection<?> connection,
			NativeWebRequest request) {
		SecurityContextHolder.getContext()
				.setAuthentication(new UsernamePasswordAuthenticationToken(localUserId, null, null));
		return null;
	}
}
