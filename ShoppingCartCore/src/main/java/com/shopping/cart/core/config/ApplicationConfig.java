package com.shopping.cart.core.config;

import java.util.Set;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.shopping.cart.rules.api.RulesServiceExecutor;


@Configuration
@Order(1)
public class ApplicationConfig {

	@Autowired
	private ApplicationProperties props;
	
	@Bean
    public KieContainer kieContainer() {
        return kieServices().getKieClasspathContainer();
    }	
	
	@Bean
	public KieServices kieServices(){
		return KieServices.Factory.get();
	}
	
	/**
	 * Create the configuration to the remote decision server
	 * @return KieServicesConfiguration
	 */
	@Bean
	public KieServicesConfiguration kieServiceConfiguration(){
		// For this example I will load all the data model classes in the Kie context  
		Reflections reflections = new Reflections(props.getDataModelPackage(), new SubTypesScanner(false));
		Set<Class<?>> allClasses = 
			    reflections.getSubTypesOf(Object.class);			
		
		KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(props.getKieServerUrl(), props.getKieServerUsername(), 
				props.getKieServerPass());
		config.setMarshallingFormat(MarshallingFormat.JSON);

		config.addExtraClasses(allClasses);
		
		return config;
	}
	
	/**
	 * Create the Kie service client
	 * @return KieServicesClient
	 */
	@Bean
	public KieServicesClient serviceClient(){
		return KieServicesFactory.newKieServicesClient(kieServiceConfiguration());
	}	
	
	/**
	 * Create the rule service
	 * @return RuleServicesClient
	 */
	@Bean
	public RuleServicesClient ruleServiceClient(){
		return serviceClient().getServicesClient(RuleServicesClient.class);
	}
	
	/**
	 * This bean create an instance of the encapsulated functionality to
	 * execute all the rules
	 * @return RulesServiceExecutor
	 */
	@Bean
	public RulesServiceExecutor ruleService(){
		return new RulesServiceExecutor(ruleServiceClient());
	}
	
}
