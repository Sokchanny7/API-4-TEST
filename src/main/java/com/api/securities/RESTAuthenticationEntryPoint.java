package com.api.securities;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component("RESTAuthenticationEntryPoint")
public class RESTAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {	
		request.getRequestDispatcher("/access-denied").forward(request, response);
	}

//	private final Logger log = LoggerFactory.getLogger(RESTAuthenticationEntryPoint.class);
//
//    public void commence(HttpServletRequest request,
//                         HttpServletResponse response,
//                         AuthenticationException ae) throws IOException, ServletException {
//
//        log.info("Pre-authenticated entry point called. Rejecting access");
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
//
//    }

}
