import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

public class Editor extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private String filePath = null;
	JTextArea textArea = new JTextArea();

	private Editor(){
		setName("Editor");
		setTitle("Editor");
		setSize(900, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnNewMenu = new JMenu("Datei");
		menuBar.add(mnNewMenu);
		

		
		JMenuItem menuItem1 = new JMenuItem("Öffnen");
		menuItem1.setMnemonic(KeyEvent.VK_O);
		menuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
		mnNewMenu.add(menuItem1);
		
				JMenuItem menuItem2 = new JMenuItem("Speichern");
				menuItem2.setMnemonic(KeyEvent.VK_S);
				menuItem2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (filePath != null)
							saveFileContent(filePath, textArea.getText());
					}
				});
				mnNewMenu.add(menuItem2);
				
				JMenuItem menuItem3 = new JMenuItem("Speichern unter");
				menuItem3.setMnemonic(KeyEvent.VK_N);
				menuItem3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						saveUnder();
					}
				});
				mnNewMenu.add(menuItem3);
				
		JScrollPane sPane = new JScrollPane(textArea);
		
		getContentPane().add(menuBar, BorderLayout.PAGE_START);
		getContentPane().add(sPane, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public static void main(String[] arg) {
		new Editor();
	}
	
	private void saveUnder() {
		JFileChooser fileChooser = new JFileChooser(".");
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getSelectedFile().getPath();
			saveFileContent(filePath, textArea.getText());
		}
	}
	
	private void open(){
		JFileChooser fileChooser = new JFileChooser(".");
		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getSelectedFile().getPath();
			getFileContent(filePath);
		}
	}
	
	static public void saveFileContent(String file, String content) {
		OutputStreamWriter osw;
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos, "UTF-8");
			osw.write(content);
			osw.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static public String getFileContent(String file) {
		BufferedReader reader;
		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			reader = new BufferedReader(isr);
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");

			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			isr.close();
			fis.close();
			return stringBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
