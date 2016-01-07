package jrat.plugin.example.client;

import iconlib.IconUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import jrat.api.Client;
import jrat.api.Icons;
import jrat.api.Plugin;
import jrat.api.events.AbstractEvent;
import jrat.api.events.Event;
import jrat.api.events.EventType;
import jrat.api.net.Packet;
import jrat.api.net.PacketListener;
import jrat.api.ui.RATMenuItem;
import jrat.api.ui.RATMenuItemActionListener;
import jrat.plugin.example.client.ui.DialogAbout;
import jrat.plugin.example.client.ui.ExampleControlPanel;

public class ExampleClientPlugin extends Plugin {

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
	public static final short HEADER = 126;

	public ExampleClientPlugin() {
		/** call super constructor, Icons.getIcon() argument 1 is the plugin file name ("files/plugins/Example.jar") and argument 2 is the resource location **/
		super("Example Plugin", "1.0", "jRAT Example Plugin", "jRAT", Icons.getIcon("Example", "/icons/icon.png"));

		Packet.registerIncoming(HEADER, new PacketListener() {
			@Override
			public void perform(Client client) {
				ExampleClientPlugin.log("Received packet with header " + HEADER + " from " + client.getIP());

				try {
					String answer = client.getDataInputStream().readUTF();

					ExampleControlPanel panel = ExampleControlPanel.INSTANCES.get(client);
					if (panel != null) {
						panel.getAnswerTextField().setText(answer);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
		Packet.registerOutgoing(HEADER, new PacketListener() {
			@Override
			public void perform(Client client) {
				log("Sent packet with header " + HEADER + " to " + client.getIP());
			}
		});
		
		Event.getHandler().register(EventType.EVENT_CLIENT_CONNECT, new ConnectEvent());
		Event.getHandler().register(EventType.EVENT_CLIENT_DISCONNECT, new DisconnectEvent());
		Event.getHandler().register(EventType.EVENT_PLUGIN_DISABLE, new Event() {
			@Override
			public void perform(AbstractEvent event) {
				log("Example Plugin disabled");
			}
		});

		RATMenuItem item = new RATMenuItem(new RATMenuItemActionListener() {
			@Override
			public void onClick(List<Client> servers) {

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
