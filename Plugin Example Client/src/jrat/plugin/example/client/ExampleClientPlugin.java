package jrat.plugin.example.client;

import iconlib.IconUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import jrat.api.RATObject;
import jrat.api.RATPlugin;
import jrat.api.events.AbstractEvent;
import jrat.api.events.Event;
import jrat.api.events.EventType;
import jrat.api.events.OnSendPacketEvent;
import jrat.api.ui.RATMenuItem;
import jrat.api.ui.RATMenuItemActionListener;
import jrat.plugin.example.client.ui.DialogAbout;

public class ExampleClientPlugin extends RATPlugin {

	/**
	 * Static about dialog
	 */
	public static final DialogAbout ABOUT_DIALOG = new DialogAbout();

	/**
	 * Should we print out when events occurs?
	 */
	public static final boolean DEBUG = true;

	/**
	 * The packet header. Recommended -127 to 0 and 100 to 127. 0-100 jRAT
	 * reserved.
	 */
	public static final byte HEADER = 126;

	public ExampleClientPlugin() {
		super("Example Plugin", "1.0", "jRAT Example Plugin", "jRAT");

		Event.getHandler().register(EventType.EVENT_CLIENT_PACKET_RECEIVED, new PacketReceivedEvent());
		Event.getHandler().register(EventType.EVENT_CLIENT_CONNECT, new ConnectEvent());
		Event.getHandler().register(EventType.EVENT_CLIENT_DISCONNECT, new DisconnectEvent());
		Event.getHandler().register(EventType.EVENT_PLUGIN_DISABLE, new Event() {
			@Override
			public void perform(AbstractEvent event) {
				log("Example Plugin disabled");
			}
		});
		Event.getHandler().register(EventType.EVENT_SERVER_PACKET_SEND, new Event() {
			@Override
			public void perform(AbstractEvent event) {
				if (event instanceof OnSendPacketEvent) {
					log("Sent packet: " + ((OnSendPacketEvent) event).getPacket().getHeader());
				}
			}
		});

		RATMenuItem item = new RATMenuItem(new RATMenuItemActionListener() {
			@Override
			public void onClick(List<RATObject> servers) {

			}
		}, "Example Plugin", IconUtils.getIcon("icon", ExampleClientPlugin.class));
		RATMenuItem.addItem(item);
	}

	/**
	 * Global menubar listener, about dialog
	 */
	@Override
	public ActionListener getGlobalActionListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ABOUT_DIALOG.setVisible(true);
			}
		};
	}

	public static void log(String s) {
		if (DEBUG) {
			System.out.println("[EXAMPLE DEBUG] " + s);
		}
	}
}
