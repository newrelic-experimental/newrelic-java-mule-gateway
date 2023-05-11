package com.nr.instrumentation.apiclient;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(originalName="com.hilpipre.MuleClientMakeRes")
public class MuleClientMakeRes_instrumentation {

	@Trace(dispatcher=true)
	public void iteration() {
		AgentBridge.getAgent().getTransaction().convertToWebTransaction();
		Weaver.callOriginal();
	}

	@Trace
	public String doPost() {
		return Weaver.callOriginal();
	}
	
	@Trace
	public String doGet() {
		return Weaver.callOriginal();
	}
}
