package com.nr.instrumentation.mule.gateway.client;

import java.util.List;

import com.mulesoft.httpclient.utils.GatewayHttpAsyncClient;
import com.mulesoft.module.client.APIPlatformSourceTypeEnum;
import com.mulesoft.module.client.model.Api;
import com.mulesoft.module.client.model.ApiClient;
import com.mulesoft.module.client.model.ApiEndpoint;
import com.mulesoft.module.client.model.ApiRef;
import com.mulesoft.module.client.model.ApiVersion;
import com.mulesoft.module.client.model.Client;
import com.mulesoft.module.client.model.Contract;
import com.mulesoft.module.client.model.HttpEvent;
import com.mulesoft.module.client.model.OrganizationInfo;
import com.mulesoft.module.client.model.PolicyDefinition;
import com.mulesoft.module.endpoint.GatewayMessageSource;
import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(originalName="com.mulesoft.module.client.APIPlatformRestClient")
public abstract class APIPlatformRestClient_instrumentation {

	@Trace(dispatcher=true)
	public void activateEndpoint(ApiRef apiRef) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","activateEndpoint",apiRef.getApiName()});
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void addEndpointToApi(ApiRef apiRef, APIPlatformSourceTypeEnum type, String endpointUrl) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","addEndpointToApi",apiRef.getApiName()});
		AgentBridge.publicApi.addCustomParameter("EndpointURL", endpointUrl);
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void addRootRaml(ApiRef apiRef, String apiName, String data, String fileName) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","addRootRaml",apiRef.getApiName()});
		AgentBridge.publicApi.addCustomParameter("APIName", apiName);
		AgentBridge.publicApi.addCustomParameter("File Name", fileName);
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public ApiRef createApi(Api api) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","createApi",api.getName()});
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public Api getApiByName(String apiName)  {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","getApiByName",apiName});
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public List<ApiClient> getApiClients(ApiRef apiRef) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","getApiClients",apiRef.getApiName()});
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public ApiRef getApiRef(GatewayMessageSource source) {
		ApiRef apiRef = (ApiRef)source.getProperty("__APIREF");
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","getApiRef",apiRef.getApiName()});
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public ApiVersion getAppIdVersionFromPlatform(String apiName, String versionName, String orgId) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","getAppIdVersionFromPlatform",apiName});
		AgentBridge.publicApi.addCustomParameter("Version", versionName);
		AgentBridge.publicApi.addCustomParameter("Organization", orgId);
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public Client getClient(String clientId) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","getClient"});
		AgentBridge.publicApi.addCustomParameter("Client", clientId);
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public Contract getContract(ApiRef apiRef, String clientId) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","getContract",apiRef.getApiName()});
		AgentBridge.publicApi.addCustomParameter("Client", clientId);
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public ApiEndpoint getEndpoint(ApiRef apiRef) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","getEndpoint",apiRef.getApiName()});
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public OrganizationInfo getOrganizationInfo() {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","getClient"});
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public List<PolicyDefinition> getPolicies(ApiRef apiRef) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","getPolicies",apiRef.getApiName()});
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void postHttpEvent(HttpEvent event) {
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void postHttpEvents(List<HttpEvent> events) {
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void updateEndpoint(Integer id, ApiRef apiRef, APIPlatformSourceTypeEnum type, String endpointUrl) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","updateEndpoint",apiRef.getApiName()});
		AgentBridge.publicApi.addCustomParameter("EndpointURL", endpointUrl);
		Weaver.callOriginal();
		
	}
	
	@Trace(dispatcher=true)
	public boolean validateClient(ApiRef apiRef, String clientId, String clientSecret) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","validateClient",apiRef.getApiName()});
		AgentBridge.publicApi.addCustomParameter("Client", clientId);
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public boolean validateClient(String clientId, String clientSecret) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","validateClient"});
		AgentBridge.publicApi.addCustomParameter("Client", clientId);
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void validateClientAsync(ApiRef apiRef, String clientId, String clientSecret, String orgId, GatewayHttpAsyncClient.GatewayFutureCallback<Boolean> callback) {
		AgentBridge.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","APIPlatformRestClient","validateClientAsync",apiRef.getApiName()});
		AgentBridge.publicApi.addCustomParameter("Client", clientId);
		Weaver.callOriginal();
	}
}
