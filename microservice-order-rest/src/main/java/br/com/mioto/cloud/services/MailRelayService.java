package br.com.mioto.cloud.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailRelayService {

    @Value("Mail Relay Service")
    private String name;

    @Value("http://localhost:10017/user")
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
