package jrat.plugin.example.client;

import java.io.IOException;

import jrat.api.events.AbstractEvent;
import jrat.api.events.Event;
import jrat.api.events.OnPacketEvent;
import jrat.plugin.example.client.ui.ExampleControlPanel;

public class PacketReceivedEvent extends Event {

	/**
	 * When we receive packet, check for our header then read the answer
	 * @param e
	 */
	@Override
	public void perform(AbstractEvent e) {
		if (e instanceof OnPacketEvent) {
			OnPacketEvent event = (OnPacketEvent) e;
			ExampleClientPlugin.log("Received packet: " + event.getPacket().getHeader());
			
			if (event.getPacket().getHeader() == ExampleClientPlugin.HEADER) {
				try {
					String answer = event.getServer().getDataInputStream().readUTF();
								
					ExampleControlPanel panel = ExampleControlPanel.INSTANCES.get(event.getServer().getUniqueId());
					if (panel != null) {
						panel.getAnswerTextField().setText(answer);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}		

}
