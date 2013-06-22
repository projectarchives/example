package pro.jrat.stub;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
public class DialogQuestion extends JDialog {

	public DialogQuestion(String title, String message) {
		setResizable(false);
		setBounds(100, 100, 450, 300);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 444, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 272, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);

	}

}
