/**
 * 
 */
package it.wt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * @author kurs
 * 
 */
public class ChessBoard_j extends JFrame {

	public ChessBoard_j() {
		setAlwaysOnTop(true);
		setTitle("Schach");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 910, 910);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JPanel[][] panel = new JPanel[8][8];

		for (int i = 0; i < panel.length; i++) {

			for (int j = 0; j < panel[i].length; j++) {
				System.out.println(i + " " + j);
				
//				getContentPane().add(panel[i][j]);
//				panel[i][j].setLayout(new GridLayout(1, 0, 0, 0));
//				panel[i][j].setForeground(Color.DARK_GRAY);
			}
		}

		setVisible(true);
	}

	public static void main(String[] args) {

		new ChessBoard_j();

	}
}
