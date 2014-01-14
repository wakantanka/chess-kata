import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class AddressBook extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	JPopupMenu popupMenu = new JPopupMenu();

	private AddressBook() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				try {
					if (resultSet != null) {
						resultSet.close();
					}

					if (statement != null) {
						statement.close();
					}

					if (connect != null) {
						connect.close();
					}
				} catch (Exception e) {

				}
			}
		});

		setName("AddressBook");
		setTitle("AddressBook");
		setSize(900, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// //////////////////////////////////////////////////////////////////////////

		table = new JTable();
		table.setBounds(10, 32, 864, 633);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 32, 864, 633);
		getContentPane().add(scrollPane);

		// table.setDefaultRenderer(String.class, new MultiLineCellRenderer());
		table.setPreferredScrollableViewportSize(new Dimension(864, 633));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(0, 4));
		
		JButton btnHinzufgen = new JButton("Hinzuf\u00FCgen");
		btnHinzufgen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {try {
				statement.execute("INSERT INTO address (name, phone, street, city) VALUES ('neu', 'neu', 'neu', 'neu')");
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { "neu", "neu", "neu", "neu" });
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		});
		btnHinzufgen.setBounds(720, 676, 154, 23);
		getContentPane().add(btnHinzufgen);
		table.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
		TableColumnModel cModel = table.getColumnModel();

		TableColumn nameColumn = cModel.getColumn(0);
		nameColumn.setPreferredWidth(50);
		nameColumn.setHeaderValue("Name");

		TableColumn phoneColumn = cModel.getColumn(1);
		phoneColumn.setPreferredWidth(50);
		phoneColumn.setHeaderValue("Telefon");

		TableColumn streetColumn = cModel.getColumn(2);
		streetColumn.setPreferredWidth(50);
		streetColumn.setHeaderValue("Straße");

		TableColumn townColumn = cModel.getColumn(3);
		townColumn.setPreferredWidth(50);
		townColumn.setHeaderValue("Stadt");

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int r = table.rowAtPoint(e.getPoint());
				if (r >= 0 && r < table.getRowCount()) {
					table.setRowSelectionInterval(r, r);
				} else {
					table.clearSelection();
				}

				int rowindex = table.getSelectedRow();
				if (rowindex < 0)
					return;
				if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
		CellEditorListener changeListener = new CellEditorListener() {
	        public void editingCanceled(ChangeEvent e) {
	        }

	        public void editingStopped(ChangeEvent e) {
	        	try {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int i = table.getSelectedRow();
					String sql = "UPDATE address SET name = '" + model.getValueAt(i, 0) + "', phone = '" + model.getValueAt(i, 1) + "', street = '" + model.getValueAt(i, 2) + "', city = '" + model.getValueAt(i, 3) + "' WHERE id = " + (table.getSelectedRow() + 1);
					statement.execute(sql);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        }
	    };
	    
	    table.getDefaultEditor(String.class).addCellEditorListener(changeListener);

		// //////////////////////////////////////////////////////////////////////////////

		JMenuItem deleteMenuItem = new JMenuItem("L\u00F6schen");
		deleteMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					statement.execute("DELETE FROM address WHERE id = " + (table.getSelectedRow() + 1));
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.removeRow(table.getSelectedRow());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		popupMenu.add(deleteMenuItem);

		// ////////////////////////////////////////////////////////////////////////////////
		// öffnet Verbindung zu Datenbank

		// This will load the MySQL driver, each DB has its own driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root"); //?user=...&password=...

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();

			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("SELECT * FROM address");
			while (resultSet.next()) {
				// It is possible to get the columns via name
				// also possible to get the columns via the column number
				// which starts at 1
				// e.g. resultSet.getSTring(2);
				String user = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				String street = resultSet.getString("street");
				String city = resultSet.getString("city");

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { user, phone, street, city });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(true);
	}

	public static void main(String[] arg) {
		new AddressBook();
	}
}
