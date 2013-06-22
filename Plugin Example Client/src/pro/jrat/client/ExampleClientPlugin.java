package pro.jrat.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import pro.jrat.api.RATControlMenuEntry;
import pro.jrat.api.RATMenuItem;
import pro.jrat.api.RATMenuItemActionListener;
import pro.jrat.api.RATObject;
import pro.jrat.api.RATPlugin;
import pro.jrat.api.events.OnConnectEvent;
import pro.jrat.api.events.OnDisableEvent;
import pro.jrat.api.events.OnDisconnectEvent;
import pro.jrat.api.events.OnEnableEvent;
import pro.jrat.api.events.OnPacketEvent;
import pro.jrat.api.events.OnSendPacketEvent;
import pro.jrat.client.ui.DialogAbout;
import pro.jrat.client.ui.ExampleControlPanel;

public class ExampleClientPlugin extends RATPlugin {
	
	/**
	 * Static about dialog
	 */
	public static final DialogAbout ABOUT_DIALOG = new DialogAbout();
	
	/**
	 * Location to our icon
	 */
	public static final String ICON_LOCATION = System.getProperty("jrat.dir") + File.separator + "plugins/Webcam/icon.png";
	
	/**
	 * Icon
	 */
	public static ImageIcon icon = null;

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

	@Override
	public void onEnable(OnEnableEvent event) throws Exception {
		log("Example Plugin enabled, jRAT version: " + event.getVersion());
	}

	@Override
	public void onPacket(OnPacketEvent event) throws Exception {
		log("Received packet: " + event.getPacket().getHeader());
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

	@Override
	public List<RATControlMenuEntry> getControlTreeItems() throws Exception {
		RATControlMenuEntry item = new RATControlMenuEntry("Example Plugin", icon, ExampleControlPanel.class);

		List<RATControlMenuEntry> list = new ArrayList<RATControlMenuEntry>();
		list.add(item);
		return list;
	}

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
