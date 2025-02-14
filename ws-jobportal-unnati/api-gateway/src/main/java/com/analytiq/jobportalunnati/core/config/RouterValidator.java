package com.analytiq.jobportalunnati.core.config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {
/*PUBLIC URL ONLY*/
    public static final List<String> openApiEndpoints = List.of(
    		//
    		// Mention below only those url which are public in @RestController of Auth-Service but not root url i.e. @RequestMapping("what are written here")on the top of class name
    		// On authenticated  user/client  have generated token for further sending requests
    		// Without generated token user/client can use any services and get always 401 unauthorized
    		"/users/**"
          
            
    );

    public Predicate<ServerHttpRequest> isSecured = (request) -> openApiEndpoints.stream().anyMatch(uri -> request.getURI().getPath().contains(uri));

}
