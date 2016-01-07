package jrat.plugin.example.client;

import jrat.api.events.AbstractEvent;
import jrat.api.events.Event;
import jrat.api.events.OnDisconnectEvent;

public class DisconnectEvent extends Event {

	@Override
	public void perform(AbstractEvent event) {
		if (event instanceof OnDisconnectEvent) {
			ExampleClientPlugin.log(((OnDisconnectEvent) event).getServer().getIP() + " disconnected");
		}
	}

}
