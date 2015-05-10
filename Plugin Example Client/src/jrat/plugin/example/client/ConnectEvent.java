package jrat.plugin.example.client;

import jrat.api.events.AbstractEvent;
import jrat.api.events.Event;
import jrat.api.events.OnConnectEvent;

public class ConnectEvent extends Event {

	@Override
	public void perform(AbstractEvent event) {
		if (event instanceof OnConnectEvent) {
			ExampleClientPlugin.log(((OnConnectEvent) event).getServer().getIP() + " connected");
		}
	}

}
