package pro.jrat.stub;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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
			final int secondsToAnswer = dis.readInt();
			
			@SuppressWarnings("serial")
			final DialogQuestion answer = new DialogQuestion(title, message) {
				@Override
				public void onAnswer() {
					try {
						dos.writeByte(HEADER);
						dos.writeUTF(this.getAnswer());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}	
			};
			
			answer.setVisible(true);
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						for (int i = secondsToAnswer; i > 0; i--) {
							answer.setTimeLeftToAnswer(i);
							Thread.sleep(1000L);
						}
						
						answer.onAnswer();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
				}
			}).start();
			
			
		}
	}

	@Override
	public void onEnable() throws Exception {
		
	}

}
