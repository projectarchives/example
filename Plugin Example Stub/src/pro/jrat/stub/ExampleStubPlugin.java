package pro.jrat.stub;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import pro.jrat.api.stub.StubPlugin;

public class ExampleStubPlugin extends StubPlugin {
	
	/**
	 * The packet header. Recommended -127 to 0 and 100 to 127. 0-100 jRAT reserved.
	 */
	public static final byte HEADER = 126;

	/**
	 * Should we print what is happening?
	 */
	public static final boolean DEBUG = true;
	
	/**
	 * Current DataInputStream
	 */
	public static DataInputStream dis;
	
	/**
	 * Current DataOutputStream
	 */
	public static DataOutputStream dos;
	
	@Override
	public void onDisconnect(Exception ex) throws Exception {
		
	}

	@Override
	public void onConnect(DataInputStream dis, DataOutputStream dos) throws Exception {
		ExampleStubPlugin.dis = dis;
		ExampleStubPlugin.dos = dos;
	}

	@Override
	public void onPacket(byte header) throws Exception {
		if (header == HEADER) {
			String title = dis.readUTF();
			String message = dis.readUTF();
			
			System.out.println(title + ", " + message);
			
			String answer = "Test Answer";
			
			dos.writeByte(HEADER);
			dos.writeUTF(answer);
		}
	}

	@Override
	public void onEnable() throws Exception {
		
	}

}
