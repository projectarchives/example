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

	@Override
	public void onEnable(OnEnableEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPacket(OnPacketEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnect(OnConnectEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisconnect(OnDisconnectEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisable(OnDisableEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSendPacket(OnSendPacketEvent event) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVersion() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuthor() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RATMenuItem> getMenuItems() throws Exception {
		// TODO Auto-generated method stub
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
