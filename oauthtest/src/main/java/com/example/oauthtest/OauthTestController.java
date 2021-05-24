package com.example.oauthtest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OauthTestController {

	private final RestTemplate restTemplate = new RestTemplate();

	@GetMapping(value = "/test")
	public void testToken() {

		
		String credentials = "client:secret";
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", "Basic " + encodedCredentials);
//		headers.add("Authorization", "Basic Y2xpZW50OnNlY3JldA==");

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "client_credentials");
		params.add("scope", "manage");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);
		System.out.println("request.getBody() : " + request.getBody());
		System.out.println("request.getHeaders() : " + request.getHeaders());
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/oauth/token", request, String.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("response.getBody() : " + response.getBody());
			System.out.println("response.getHeaders() : " + response.getHeaders());
			// return gson.fromJson(response.getBody(), OAuthToken.class);
		}
		return;
	}
}
