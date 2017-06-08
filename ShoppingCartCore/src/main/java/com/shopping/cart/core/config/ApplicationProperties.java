package com.shopping.cart.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Can be refactored to KieProperties and have separate file
 * to the application properties
 * @author Bryan
 *
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationProperties {

	@Value("${kie.server.url}")
	private String kieServerUrl;
	
	@Value("${kie.server.username}")
	private String kieServerUsername;
	
	@Value("${kie.server.pass}")
	private String kieServerPass;
	
	@Value("${kie.server.container}")
	private String kieServerContainer;
	
	@Value("${kie.server.ksession}")
	private String kieServerKsession;

	@Value("${data.model.package}")
	private String dataModelPackage;
	
	public String getKieServerUrl() {
		return kieServerUrl;
	}

	public void setKieServerUrl(String kieServerUrl) {
		this.kieServerUrl = kieServerUrl;
	}

	public String getKieServerUsername() {
		return kieServerUsername;
	}

	public void setKieServerUsername(String kieServerUsername) {
		this.kieServerUsername = kieServerUsername;
	}

	public String getKieServerPass() {
		return kieServerPass;
	}

	public void setKieServerPass(String kieServerPass) {
		this.kieServerPass = kieServerPass;
	}

	public String getKieServerContainer() {
		return kieServerContainer;
	}

	public void setKieServerContainer(String kieServerContainer) {
		this.kieServerContainer = kieServerContainer;
	}

	public String getKieServerKsession() {
		return kieServerKsession;
	}

	public void setKieServerKsession(String kieServerKsession) {
		this.kieServerKsession = kieServerKsession;
	}

	public String getDataModelPackage() {
		return dataModelPackage;
	}

	public void setDataModelPackage(String dataModelPackage) {
		this.dataModelPackage = dataModelPackage;
	}		
}


 