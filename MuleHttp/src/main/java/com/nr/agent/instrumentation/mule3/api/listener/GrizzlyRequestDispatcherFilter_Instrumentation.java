package com.nr.agent.instrumentation.mule3.api.listener;

import org.glassfish.grizzly.filterchain.FilterChainContext;
import org.glassfish.grizzly.filterchain.NextAction;
import org.glassfish.grizzly.http.HttpContent;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.agent.instrumentation.mule3.InboundRequest;

@Weave(type = MatchType.ExactClass, originalName = "org.mule.module.http.internal.listener.grizzly.GrizzlyRequestDispatcherFilter")
public abstract class GrizzlyRequestDispatcherFilter_Instrumentation {

    @Trace(dispatcher = true)
    public NextAction handleRead(FilterChainContext filterChainContext) {
		Object msg = filterChainContext.getMessage();
		if(HttpContent.class.isInstance(msg)) {
			HttpContent httpContent = (HttpContent)msg;
			AgentBridge.getAgent().getTransaction().convertToWebTransaction();
			InboundRequest nrReq = new InboundRequest(httpContent);
			AgentBridge.getAgent().getTransaction().setWebRequest(nrReq);
		}
        NewRelic.getAgent().getTracedMethod().setMetricName("Mule", "RequestDispatcher", "handleRequest");
        return Weaver.callOriginal();
    }

}
