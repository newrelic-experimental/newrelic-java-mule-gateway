package com.nr.agent.instrumentation.mule3.api.listener.async;

import org.glassfish.grizzly.http.HttpRequestPacket;
import org.glassfish.grizzly.http.HttpResponsePacket;
import org.mule.module.http.internal.domain.response.HttpResponse;

import com.newrelic.agent.bridge.AgentBridge;
import com.newrelic.agent.bridge.Transaction;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.agent.instrumentation.mule3.MuleHttpRequest;
import com.nr.agent.instrumentation.mule3.MuleHttpResponse;
import com.nr.agent.instrumentation.mule3.OutboundWrapper;

@Weave(type=MatchType.BaseClass,originalName="org.mule.module.http.internal.listener.grizzly.BaseResponseCompletionHandler")
public abstract class BaseResponseCompletionHandler_instrumentation {

	@Trace(excludeFromTransactionTrace=true)
	protected HttpResponsePacket buildHttpResponsePacket(HttpRequestPacket sourceRequest, HttpResponse httpResponse) {
		Transaction transaction = AgentBridge.getAgent().getTransaction();
		
		MuleHttpRequest nrrequest = new MuleHttpRequest(sourceRequest);
		AgentBridge.getAgent().getTransaction().setWebRequest(nrrequest);
		HttpResponsePacket responsePacket = Weaver.callOriginal();
		MuleHttpResponse nrresponse = new MuleHttpResponse(responsePacket);
		transaction.setWebResponse(nrresponse);
		
		OutboundWrapper wrapper = new OutboundWrapper(responsePacket);
		long contentLength = getContentLength(httpResponse);
		AgentBridge.getAgent().getTransaction().getCrossProcessState().processOutboundResponseHeaders(wrapper, contentLength);
		AgentBridge.getAgent().getTransaction().addOutboundResponseHeaders();
		return responsePacket;
	}
	
    private static long getContentLength(HttpResponse muleResponse) {
        String contentLength = muleResponse.getHeaderValue("Content-Length");
        if (contentLength == null || contentLength.isEmpty()) {
            return -1L;
        } else {
        	if(contentLength.startsWith("[")) {
        		contentLength = contentLength.substring(1);
        	}
        	if(contentLength.endsWith("]")) {
        		int len = contentLength.length();
        		contentLength = contentLength.substring(0, len-1);
        	}
            return Long.parseLong(contentLength);
        }
    }

}
