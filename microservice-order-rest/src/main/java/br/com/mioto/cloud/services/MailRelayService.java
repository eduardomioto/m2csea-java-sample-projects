package br.com.mioto.cloud.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailRelayService {

	@Value("${services.mail-relay.name}")
    private String name;

	@Value("${services.mail-relay.url}")
	private String url;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
