package pro.jrat.stub;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import pro.jrat.api.stub.StubPlugin;

public class ExampleStubPlugin extends StubPlugin {
	
	/**
	 * The packet header. Recommended -127 to 0 and 100 to 127. 0-100 jRAT reserved.
	 */
	public static final byte HEADER = 126;

	@Override
	public void onDisconnect(Exception ex) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnect(DataInputStream dis, DataOutputStream dos) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPacket(byte header) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
