/**
 * 
 */
package it.wt;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author kurs
 * 
 */
public class MyFrame extends JFrame {
	private JTextField txtBlabla;

	public MyFrame() {
		setAlwaysOnTop(true);
		setTitle("Schach");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 910, 910);
		getContentPane().setLayout(null);
		txtBlabla = new JTextField();
		txtBlabla.setBounds(30, 30, 894, 20);
		txtBlabla.setText("blabla");
		getContentPane().add(txtBlabla);
		txtBlabla.setColumns(10);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(0, 846, 894, 25);
		getContentPane().add(splitPane);

		final JLabel lblLabel = new JLabel("Label");
		lblLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("mouse hat Label geklickt");
				lblLabel.setText("geklicktes Label");
			}
		});
		JButton btnOk = new JButton("ok");

		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("mouse hat Label geklickt");
				lblLabel.setText("geklicktes Label");
			}
		});
		btnOk.setBounds(74, 741, 820, 23);
		getContentPane().add(btnOk);

		JButton btnNiemals = new JButton("niemals");
		btnNiemals.setBounds(429, 775, 67, 23);
		getContentPane().add(btnNiemals);

		lblLabel.setBounds(59, 63, 46, 14);
		getContentPane().add(lblLabel);
		btnNiemals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		setVisible(true);
	}

	public static void main(String[] args) {

		new MyFrame();

	}
}
