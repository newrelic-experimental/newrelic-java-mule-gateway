package com.nr.agent.instrumentation.mule3;

import org.glassfish.grizzly.http.HttpResponsePacket;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.Response;

public class MuleHttpResponse implements Response {
	
	private HttpResponsePacket packet;
	
	public MuleHttpResponse(HttpResponsePacket p) {
		packet = p;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public void setHeader(String name, String value) {
		packet.setHeader(name, value);
	}

	@Override
	public int getStatus() throws Exception {
		return packet.getStatus();
	}

	@Override
	public String getStatusMessage() throws Exception {
		return packet.getReasonPhrase();
	}

	@Override
	public String getContentType() {
		return packet.getContentType();
	}

}
