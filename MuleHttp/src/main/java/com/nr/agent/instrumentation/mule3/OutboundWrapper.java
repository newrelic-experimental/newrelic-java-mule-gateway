package com.nr.agent.instrumentation.mule3;

import org.glassfish.grizzly.http.HttpResponsePacket;

import com.newrelic.api.agent.HeaderType;
import com.newrelic.api.agent.OutboundHeaders;

public class OutboundWrapper implements OutboundHeaders {
	
	private HttpResponsePacket packet;
	
	public OutboundWrapper(HttpResponsePacket rp) {
		packet = rp;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public void setHeader(String name, String value) {
		packet.setHeader(name, value);
	}

}
