package jrat.plugin.example.client;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import jrat.api.RATObject;
import jrat.api.RATPlugin;
import jrat.api.events.OnConnectEvent;
import jrat.api.events.OnDisableEvent;
import jrat.api.events.OnDisconnectEvent;
import jrat.api.events.OnEnableEvent;
import jrat.api.events.OnPacketEvent;
import jrat.api.events.OnSendPacketEvent;
import jrat.api.ui.RATControlMenuEntry;
import jrat.api.ui.RATMenuItem;
import jrat.api.ui.RATMenuItemActionListener;
import jrat.plugin.example.client.ui.DialogAbout;
import jrat.plugin.example.client.ui.ExampleControlPanel;

public class ExampleClientPlugin extends RATPlugin {
	
	/**
	 * Static about dialog
	 */
	public static final DialogAbout ABOUT_DIALOG = new DialogAbout();
	
	/**
	 * Location to our icon
	 */
	public static final String ICON_LOCATION = System.getProperty("jrat.dir") + File.separator + "files/plugins/Example Plugin/icon.png";
	
	/**
	 * Icon
	 */
	public static ImageIcon icon = null;

	/**
	 * Load icon from location
	 */
	static {
		icon = new ImageIcon(ICON_LOCATION);
	}
	
	/**
	 * Should we print out when events occurs?
	 */
	public static final boolean DEBUG = true;
	
	/**
	 * The packet header. Recommended -127 to 0 and 100 to 127. 0-100 jRAT reserved.
	 */
	public static final byte HEADER = 126;
	
	public ExampleClientPlugin() {
		super("Example Plugin", "1.0", "jRAT Example Plugin", "jRAT");
	}

	/**
	 * When we receive packet, check for our header then read the answer
	 */
	@Override
	public void onPacket(OnPacketEvent event) throws Exception {
		log("Received packet: " + event.getPacket().getHeader());
		
		if (event.getPacket().getHeader() == HEADER) {
			String answer = event.getServer().getDataInputStream().readUTF();
						
			ExampleControlPanel panel = ExampleControlPanel.INSTANCES.get(event.getServer().getUniqueId());
			if (panel != null) {
				panel.getAnswerTextField().setText(answer);
			}
		}
	}

	@Override
	public void onConnect(OnConnectEvent event) throws Exception {
		log(event.getServer().getIP() + " connected");
	}

	@Override
	public void onDisconnect(OnDisconnectEvent event) throws Exception {
		log(event.getServer().getIP() + " disconnected");
	}

	@Override
	public void onDisable(OnDisableEvent event) throws Exception {
		log("Example Plugin disabled");
	}

	@Override
	public void onSendPacket(OnSendPacketEvent event) throws Exception {
		log("Sent packet: " + event.getPacket().getHeader());
	}

	@Override
	public String getName() {
		return "Example Plugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public String getDescription() {
		return "jRAT Example Plugin";
	}

	@Override
	public String getAuthor() {
		return "redpois0n";
	}

	/**
	 * Menu item(s) to have on the right click menu
	 */
	@Override
	public List<RATMenuItem> getMenuItems() throws Exception {
		RATMenuItem item = new RATMenuItem(new RATMenuItemActionListener() {
			@Override
			public void onClick(List<RATObject> servers) {
				
			}
		}, "Example Plugin", icon);

		List<RATMenuItem> list = new ArrayList<RATMenuItem>();
		list.add(item);
		return list;
	}

	/**
	 * Tree items to have in control panel
	 */
	@Override
	public List<RATControlMenuEntry> getControlTreeItems() throws Exception {
		RATControlMenuEntry item = new RATControlMenuEntry("Example Plugin", icon, ExampleControlPanel.class);

		List<RATControlMenuEntry> list = new ArrayList<RATControlMenuEntry>();
		list.add(item);
		return list;
	}

	/**
	 * Global menubar listener, about dialog
	 */
	@Override
	public ActionListener getGlobalMenuItemListener() {
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
