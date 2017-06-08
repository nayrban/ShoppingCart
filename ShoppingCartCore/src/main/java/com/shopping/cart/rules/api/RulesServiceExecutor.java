package com.shopping.cart.rules.api;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.runtime.ExecutionResults;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.RuleServicesClient;
import org.springframework.beans.factory.annotation.Autowired;

import com.shopping.cart.core.config.ApplicationProperties;

public class RulesServiceExecutor {

	/**
	 * Default configuration values
	 */
	private static final String DEFAULT_FIRE_IDENTIFIER = "fire-identifier";
	private static final String DEFAULT_RESULT_IDENTIFIER = "Result";
	
	private RuleServicesClient ruleServicesClient;

	@Autowired
	private ApplicationProperties properties;
	

	@Autowired
	public RulesServiceExecutor(RuleServicesClient ruleServicesClient) {
		this.ruleServicesClient = ruleServicesClient;
	}	
	
	public <T> T executeRule(T entry){
		return executeRule(entry, DEFAULT_RESULT_IDENTIFIER);
	}
	
	
	public <T> T executeRule(T entry, String resultIdentifier){
		return executeRule(entry, resultIdentifier, DEFAULT_FIRE_IDENTIFIER);
	}
	
	public <T> T executeRule(T entry, String resultIdentifier, String fireIdentifier){
		return executeRule(entry, resultIdentifier, fireIdentifier, null);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T  executeRule(T entry, String resultIdentifier, String fireIdentifier, List<Command<?>> additionalCommands) {
		List<Command<?>> commands = new ArrayList<Command<?>>();
		commands.add((Command<?>) KieServices.Factory.get().getCommands()
				.newInsert(entry, resultIdentifier));
		commands.add((Command<?>) KieServices.Factory.get().getCommands()
				.newFireAllRules(fireIdentifier));
		
		if(additionalCommands != null && additionalCommands.size() > 0)
			commands.addAll(additionalCommands);
		
		BatchExecutionCommand batchCommand = KieServices.Factory.get()
				.getCommands()
				.newBatchExecution(commands, properties.getKieServerKsession());
		ServiceResponse<ExecutionResults> response = ruleServicesClient.executeCommandsWithResults(properties.getKieServerContainer(),
				batchCommand);
				
		
		entry = (T) response.getResult().getValue(resultIdentifier);
		
		return entry;
	}
}
