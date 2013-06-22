package pro.jrat.client;

import java.awt.event.ActionListener;
import java.util.List;

import pro.jrat.api.RATControlMenuEntry;
import pro.jrat.api.RATMenuItem;
import pro.jrat.api.RATPlugin;
import pro.jrat.api.events.OnConnectEvent;
import pro.jrat.api.events.OnDisableEvent;
import pro.jrat.api.events.OnDisconnectEvent;
import pro.jrat.api.events.OnEnableEvent;
import pro.jrat.api.events.OnPacketEvent;
import pro.jrat.api.events.OnSendPacketEvent;

public class ExampleClientPlugin extends RATPlugin {
	
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
		
	}

	@Override
	public void onPacket(OnPacketEvent event) throws Exception {
		
	}

	@Override
	public void onConnect(OnConnectEvent event) throws Exception {
		
	}

	@Override
	public void onDisconnect(OnDisconnectEvent event) throws Exception {
		
	}

	@Override
	public void onDisable(OnDisableEvent event) throws Exception {
		
	}

	@Override
	public void onSendPacket(OnSendPacketEvent event) throws Exception {
		
	}

	@Override
	public String getName() throws Exception {
		return "Example Plugin";
	}

	@Override
	public String getVersion() throws Exception {
		return "1.0";
	}

	@Override
	public String getDescription() throws Exception {
		return "jRAT Example Plugin";
	}

	@Override
	public String getAuthor() throws Exception {
		return "redpois0n";
	}

	@Override
	public List<RATMenuItem> getMenuItems() throws Exception {
		return null;
	}

	@Override
	public List<RATControlMenuEntry> getControlTreeItems() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionListener getGlobalMenuItemListener() {
		// TODO Auto-generated method stub
		return null;
	}

}
