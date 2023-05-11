package com.nr.agent.instrumentation.mule3;

import java.util.Enumeration;

import org.glassfish.grizzly.http.HttpContent;

import com.newrelic.api.agent.ExtendedRequest;
import com.newrelic.api.agent.HeaderType;

public class InboundRequest extends ExtendedRequest {
	
	private HttpContent httpContent;
	
	public InboundRequest(HttpContent hc) {
		httpContent = hc;
	}

	@Override
	public String getRequestURI() {
		return httpContent.getHttpHeader().getContentType();
	}

	@Override
	public String getRemoteUser() {
		return null;
	}

	@Override
	public Enumeration getParameterNames() {
		return null;
	}

	@Override
	public String[] getParameterValues(String name) {
		return null;
	}

	@Override
	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCookieValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HeaderType getHeaderType() {
		// TODO Auto-generated method stub
		return HeaderType.HTTP;
	}

	@Override
	public String getHeader(String name) {
		return httpContent.getHttpHeader().getHeader(name);
	}

	@Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return httpContent.getHttpHeader().getProtocolString();
	}


}
