package pro.jrat.client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

import pro.jrat.api.BaseControlPanel;
import pro.jrat.api.RATObject;
import pro.jrat.client.AskPacket;
import pro.jrat.client.ExampleClientPlugin;

@SuppressWarnings("serial")
public class ExampleControlPanel extends BaseControlPanel {

	public static final Map<RATObject, ExampleControlPanel> INSTANCES = new HashMap<RATObject, ExampleControlPanel>();
	
	private JTextField txtQuestion;
	private JTextPane txtMessage;
	private JTextPane txtAnswer;
	
	public ExampleControlPanel() {
		INSTANCES.put(super.getServer(), this);
		
		JLabel lblSendQuestion = new JLabel("Title:");
		
		txtQuestion = new JTextField();
		txtQuestion.setText("Question");
		txtQuestion.setColumns(10);
		
		JLabel lblMessage = new JLabel("Question:");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton btnAsk = new JButton("Ask");
		btnAsk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ask();
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JLabel lblAnswer = new JLabel("Answer:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAsk, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblMessage)
								.addComponent(lblSendQuestion))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
								.addComponent(txtQuestion, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblAnswer)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSendQuestion)
						.addComponent(txtQuestion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMessage)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAsk)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAnswer))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		
		txtAnswer = new JTextPane();
		scrollPane_1.setViewportView(txtAnswer);
		
		txtMessage = new JTextPane();
		txtMessage.setText("Do you know this is the example plugin?");
		scrollPane.setViewportView(txtMessage);
		setLayout(groupLayout);

	}
	
	public void ask() {
		try {
			super.getServer().addToSendQueue(new AskPacket(super.getServer(), txtQuestion.getText(), txtMessage.getText()));
		} catch (Exception ex) {
			ex.printStackTrace();
			ExampleClientPlugin.log("Failed to send packet: " + ex.getMessage());
		}
	}

	@Override
	public void onClose() {
		INSTANCES.remove(super.getServer());
	}

	public JTextPane getTxtAnswer() {
		return txtAnswer;
	}
}
