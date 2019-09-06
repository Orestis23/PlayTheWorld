package co.TashaBrianRusty.PlayTheWorld.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)

public class AmadeusUser {

	private String type;
	private String username;
	private String application_name;
	
	private String client_id;
	private String token_type;
	private String access_token;
	private String expires_in;
	private String state;
	private String scope;
}
