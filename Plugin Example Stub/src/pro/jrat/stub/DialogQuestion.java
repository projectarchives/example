package pro.jrat.stub;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public abstract class DialogQuestion extends JDialog {
	
	private JTextPane txtQuestion;
	private JTextPane txtAnswer;
	private JLabel lblTimeLeftTo;

	public DialogQuestion(String title, String message) {
		setTitle(title);
		setResizable(false);
		setBounds(100, 100, 450, 270);
		
		JLabel lblQuestion = new JLabel("Question:");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JLabel lblAnswer = new JLabel("Answer:");
		
		JButton btnAnswer = new JButton("Answer");
		btnAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onAnswer();
			}
		});
		
		lblTimeLeftTo = new JLabel("Time left to answer: 15");
		lblTimeLeftTo.setForeground(Color.RED);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblQuestion)
						.addComponent(lblAnswer))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblTimeLeftTo)
							.addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
							.addComponent(btnAnswer))
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuestion))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAnswer))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnswer)
						.addComponent(lblTimeLeftTo))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		txtAnswer = new JTextPane();
		scrollPane_1.setViewportView(txtAnswer);
		
		txtQuestion = new JTextPane();
		txtQuestion.setText(message);
		scrollPane.setViewportView(txtQuestion);
		getContentPane().setLayout(groupLayout);

	}

	public abstract void onAnswer();

	public String getAnswer() {
		return txtAnswer.getText();
	}

	public void setTimeLeftToAnswer(int seconds) {
		lblTimeLeftTo.setText("Time left to answer: " + seconds);
	}
}
