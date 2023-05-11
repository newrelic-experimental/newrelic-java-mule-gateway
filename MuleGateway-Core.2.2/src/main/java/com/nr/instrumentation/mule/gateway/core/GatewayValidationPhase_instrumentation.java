package com.nr.instrumentation.mule.gateway.core;

import org.mule.execution.MessageProcessContext;
import org.mule.execution.PhaseResultNotifier;
import org.mule.module.http.internal.listener.HttpMessageProcessorTemplate;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(originalName="com.mulesoft.gateway.http.phases.GatewayValidationPhase")
public abstract class GatewayValidationPhase_instrumentation {

	@Trace
	public void runPhase(HttpMessageProcessorTemplate processorTemplate, MessageProcessContext messageProcessContext, PhaseResultNotifier phaseResultNotifier) {
		Weaver.callOriginal();
	}
}
