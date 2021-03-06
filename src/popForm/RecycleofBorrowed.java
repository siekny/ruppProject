package popForm;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classMembers.BorrowerClass;
import connection.UserConnection;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;
import java.awt.Color;
import java.awt.Font;

public class RecycleofBorrowed extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable recycleBorrowedtable;
	private JPanel panelContent;
	private DefaultTableModel model;
	private JPanel panelBtn;
	private JButton btnRestore;
	private JButton btnDelete;

	/**
	 * Create the panel.
	 */
	public RecycleofBorrowed() {
		setBackground(new Color(255, 255, 255));
		
		setLayout(new BorderLayout(0, 0));
		
		initComponent();
		initDateTable();
		initBtn();
		JOptionPane.showOptionDialog(null	, panelContent, "Recycle Bin of Borrowing", JOptionPane.CLOSED_OPTION, JOptionPane.CLOSED_OPTION, null, new Object[]{}, null);
	}
	
	public void initDateTable() {
		model.setRowCount(0);
		
		ArrayList<BorrowerClass> borrowList = new UserConnection().borrowView(2); // show return date
		
		for(int i=0; i<borrowList.size(); i++) {
			BorrowerClass book = borrowList.get(i);
			model.addRow(book.getBorrowColumns());
		}
	}
	
	public void initComponent() {
		panelContent = new JPanel();
		panelContent.setBackground(new Color(255, 255, 255));
		add(panelContent, BorderLayout.CENTER);
		panelContent.setLayout(new BorderLayout(0, 0));
		panelContent.setPreferredSize(new Dimension(800, 500));
		
		model = new DefaultTableModel(null, new String[] {"id", "StudentID", "BookID", "Full Name", "Contact", "Book ISBN", "Borrowed BookQTY", "Borrowed Date", "Return Date"}){
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		        return column == 0;
		    }
		};
		recycleBorrowedtable = new JTable(model);
		
		JScrollPane scroll = new JScrollPane(recycleBorrowedtable);
		panelContent.add(scroll);
	}
	
	public void initBtn() {
		panelBtn = new JPanel();
		panelBtn.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout = (FlowLayout) panelBtn.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelContent.add(panelBtn, BorderLayout.SOUTH);
		
		btnRestore = new JButton("Restore");
		btnRestore.setContentAreaFilled(false);
		btnRestore.setBackground(new Color(60, 179, 113));
		btnRestore.setForeground(new Color(255, 255, 255));
		btnRestore.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRestore.setFocusPainted(false);
		btnRestore.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRestore.setOpaque(true);
		panelBtn.add(btnRestore);
		
		btnDelete = new JButton("Delete");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBackground(new Color(220, 20, 60));
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setOpaque(true);
		btnDelete.setFocusPainted(false);
		panelBtn.add(btnDelete);
		
		btnDelete.addActionListener(this);
		btnRestore.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDelete)
			deleteRecycleBin();
		else if(e.getSource() == btnRestore)
			restoreRecycleBin();
		
	}
	
	public void deleteRecycleBin() {
		if(recycleBorrowedtable.getSelectionModel().isSelectionEmpty())
			JOptionPane.showConfirmDialog(null, "Please select at least one row to Remove", "",  JOptionPane.CLOSED_OPTION , JOptionPane.ERROR_MESSAGE);
		else {
			int row = recycleBorrowedtable.getSelectedRow();
			
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure?", "Deleting...", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
			if(confirm == JOptionPane.OK_OPTION) {
				while (row != -1)
	            {
	                int modelRow = recycleBorrowedtable.convertRowIndexToModel( row );
	                String id = recycleBorrowedtable.getModel().getValueAt(modelRow, 0).toString();
	                String bookID = recycleBorrowedtable.getModel().getValueAt(modelRow, 2).toString();
	                String numBorrow = recycleBorrowedtable.getModel().getValueAt(modelRow, 6).toString();
	                
	                new UserConnection().removeRecycleBinofBorrowing(Integer.parseInt(id),  Integer.parseInt(bookID), Integer.parseInt(numBorrow));
					model.removeRow( modelRow );
		            row = recycleBorrowedtable.getSelectedRow();  
	            }
				
				JOptionPane.showConfirmDialog(null, "Data has been removed successfully !", "",  JOptionPane.CLOSED_OPTION , JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}
	
	public void restoreRecycleBin() {
		if(recycleBorrowedtable.getSelectionModel().isSelectionEmpty())
			JOptionPane.showConfirmDialog(null, "Please select at least one row to Restore", "",  JOptionPane.CLOSED_OPTION , JOptionPane.ERROR_MESSAGE);
		else {
			int row = recycleBorrowedtable.getSelectedRow();
			
			int confirm = JOptionPane.showConfirmDialog(null, "Wanna Restore", "Restoring...", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
			if(confirm == JOptionPane.OK_OPTION) {
				while (row != -1)
	            {
	                int modelRow = recycleBorrowedtable.convertRowIndexToModel( row );
	                String id = recycleBorrowedtable.getModel().getValueAt(modelRow, 0).toString();
	                new UserConnection().restoreRecycleBinofBorrowing(Integer.parseInt(id));
					model.removeRow( modelRow );
		            row = recycleBorrowedtable.getSelectedRow();  
	            }
				
				JOptionPane.showConfirmDialog(null, "Data has been restored successfully !", "",  JOptionPane.CLOSED_OPTION , JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}

}
