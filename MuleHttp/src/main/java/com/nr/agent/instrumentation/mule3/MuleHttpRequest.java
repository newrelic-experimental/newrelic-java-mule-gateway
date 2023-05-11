package com.nr.agent.instrumentation.mule3;

import java.util.Enumeration;

import org.glassfish.grizzly.http.HttpRequestPacket;

import com.newrelic.api.agent.ExtendedRequest;
import com.newrelic.api.agent.HeaderType;

public class MuleHttpRequest extends ExtendedRequest {
	
	private HttpRequestPacket requestPacket;

	public MuleHttpRequest(HttpRequestPacket request) {
		requestPacket = request;
	}
	
	@Override
	public String getRequestURI() {
		return requestPacket.getRequestURI();
	}

	@Override
	public String getRemoteUser() {
		return null;
	}

	@Override
	public Enumeration getParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAttribute(String name) {
		return requestPacket.getAttribute(name);
	}

	@Override
	public String getCookieValue(String name) {
		return null;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public String getHeader(String name) {
		return requestPacket.getHeader(name);
	}

	@Override
	public String getMethod() {
		return requestPacket.getMethod().getMethodString();
	}

}
