package popForm;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.Cursor;

import classMembers.BookClass;
import classMembers.BorrowerClass;
import classMembers.MemberRegisterClass;
import connection.UserConnection;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;

public class NewBorrower extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtStudentID;
	private JTextField txtStudentName;
	private JTextField txtContact;
	private JPanel panelLeft, panelRight, panelButton;
	
	private JPanel panelMain;
	private JTextField txtBorrowedDate;
	@SuppressWarnings("rawtypes")
	private JComboBox cboBorrowQty;
	private JButton btnAddnew, btnClear;
	private JTextField txtCurrentContact;
	private JTextField txtBookISBN;
	private JTextField txtBookQty;
	private JLabel lblBook_id;
	
	
	

	/**
	 * Create the panel.
	 */
	public NewBorrower() {
		setLayout(new BorderLayout(0, 0));
		
		initComponent();
		//initStudentInfo();
		
		borrowInfo();
		initButton();
		
		JOptionPane.showOptionDialog(null	, panelMain, "Create new Borrower", JOptionPane.CLOSED_OPTION, JOptionPane.CLOSED_OPTION, null, new Object[]{}, null);

	}
	
	public void initComponent () {
		panelMain = new JPanel();
		add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitle = new JPanel();
		panelMain.add(panelTitle, BorderLayout.NORTH);
		panelTitle.setBackground(new Color(255, 255, 255));
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblCreateNewBorrower = new JLabel("Create a new Borrower ");
		lblCreateNewBorrower.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewBorrower.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelTitle.add(lblCreateNewBorrower, BorderLayout.NORTH);
		
		JPanel panelContent = new JPanel();
		panelMain.add(panelContent);
		panelContent.setBackground(new Color(255, 255, 255));
		
		JPanel panelInner = new JPanel();
		panelInner.setBackground(new Color(255, 255, 255));
		panelContent.add(panelInner);
		panelInner.setLayout(new GridLayout(0, 2, 20, 0));
		
		panelLeft = new JPanel();
		panelLeft.setBackground(new Color(255, 255, 255));
		panelInner.add(panelLeft);
		panelLeft.setLayout(new GridLayout(12, 2, 0, 5));
		
		JLabel label = new JLabel("Student Information");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(65, 105, 225));
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(65, 105, 225)));
		panelLeft.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(65, 105, 225)));
		panelLeft.add(label_1);
		
		initStudentInfo();
		
		JPanel panelCurrentContact = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelCurrentContact.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panelCurrentContact.setBackground(Color.WHITE);
		panelLeft.add(panelCurrentContact);
		
		JLabel lblCurrentContact = new JLabel("Current Contact");
		panelCurrentContact.add(lblCurrentContact);
		
		txtCurrentContact = new JTextField();
		panelLeft.add(txtCurrentContact);
		txtCurrentContact.setColumns(10);
		
		lblBook_id = new JLabel("");
		lblBook_id.setVisible(false);
		panelLeft.add(lblBook_id);
		
		JLabel label_10 = new JLabel("");
		panelLeft.add(label_10);
		
		JLabel label_11 = new JLabel("");
		panelLeft.add(label_11);
		
		//initBookInfo();
		
		
		panelRight = new JPanel();
		panelRight.setBackground(new Color(255, 255, 255));
		panelInner.add(panelRight);
		panelRight.setLayout(new GridLayout(12, 2, 0, 5));
		
		JLabel label_5 = new JLabel("Book Information");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(new Color(65, 105, 225));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(65, 105, 225)));
		panelRight.add(label_5);
		
		JLabel label_3 = new JLabel("");
		label_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(65, 105, 225)));
		panelRight.add(label_3);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.setBackground(Color.WHITE);
		panelRight.add(panel);
		
		JLabel label_6 = new JLabel("Book ISBN ");
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		panel.add(label_7);
		
		initBookISBN();
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_3.setBackground(Color.WHITE);
		panelRight.add(panel_3);
		
		JLabel label_8 = new JLabel("Book Available");
		panel_3.add(label_8);
		
		JLabel label_1_1 = new JLabel("*");
		label_1_1.setForeground(Color.RED);
		panel_3.add(label_1_1);
		
		txtBookQty = new JTextField();
		panelRight.add(txtBookQty);
		txtBookQty.setColumns(10);
		
		JLabel lblBorrowerInformation = new JLabel("Borrower Information");
		lblBorrowerInformation.setHorizontalAlignment(SwingConstants.LEFT);
		lblBorrowerInformation.setForeground(new Color(65, 105, 225));
		lblBorrowerInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBorrowerInformation.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(65, 105, 225)));
		panelRight.add(lblBorrowerInformation);
		
		JLabel label_2 = new JLabel("");
		label_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(65, 105, 225)));
		panelRight.add(label_2);
	}
	
	public void initStudentInfo() {
		JPanel panelStudentID = new JPanel();
		panelStudentID.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_4 = (FlowLayout) panelStudentID.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panelLeft.add(panelStudentID);
		
		JLabel lblStudentId = new JLabel("Student ID");
		panelStudentID.add(lblStudentId);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		panelStudentID.add(label_3);
		
		initStudentID();
		
		JPanel panelStudentName = new JPanel();
		panelStudentName.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_3 = (FlowLayout) panelStudentName.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelLeft.add(panelStudentName);
		
		JLabel lblStudentName = new JLabel("Student Name");
		panelStudentName.add(lblStudentName);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		panelStudentName.add(label_4);
		
		txtStudentName = new JTextField();
		txtStudentName.setBackground(new Color(255, 255, 255));
		txtStudentName.setEditable(false);
		panelLeft.add(txtStudentName);
		txtStudentName.setColumns(10);
		
		JPanel panelStudentContact = new JPanel();
		panelStudentContact.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_8 = (FlowLayout) panelStudentContact.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		panelLeft.add(panelStudentContact);
		
		JLabel lblContact = new JLabel("Contact");
		panelStudentContact.add(lblContact);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		panelStudentContact.add(label_8);
		
		txtContact = new JTextField();
		txtContact.setBackground(new Color(255, 255, 255));
		txtContact.setEditable(false);
		panelLeft.add(txtContact);
		txtContact.setColumns(10);
	}
	
//	public void initBookInfo() {
//		
//		initBookISBN();
//	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void borrowInfo() {
		JPanel panelBorrowQty = new JPanel();
		panelBorrowQty.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_6 = (FlowLayout) panelBorrowQty.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panelRight.add(panelBorrowQty);
		JLabel lblQtyOfBorrowing = new JLabel("QTY of Borrowing");
		panelBorrowQty.add(lblQtyOfBorrowing);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		panelBorrowQty.add(label_7);
		
		cboBorrowQty = new JComboBox(new String[] {"1", "2", "3"});
		cboBorrowQty.setFocusable(false);
		cboBorrowQty.setBackground(Color.WHITE);
		panelRight.add(cboBorrowQty);
		
		JPanel panelBorrowDate = new JPanel();
		panelBorrowDate.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_7 = (FlowLayout) panelBorrowDate.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panelRight.add(panelBorrowDate);
		
		JLabel lblNewLabel_8 = new JLabel("Borrowed Date (MMM, d, yyy)");
		panelBorrowDate.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("*");
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		panelBorrowDate.add(lblNewLabel_9);
		
		txtBorrowedDate = new JTextField();
		txtBorrowedDate.setEditable(false);
		panelRight.add(txtBorrowedDate);
		txtBorrowedDate.setColumns(10);
		
		DateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
		txtBorrowedDate.setText(df.format(new Date()));
		
		JLabel label_6 = new JLabel("");
		panelRight.add(label_6);
		
		JLabel label_9 = new JLabel("");
		panelRight.add(label_9);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panelRight.add(panel_2);
		
		panelButton = new JPanel();
		panelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		FlowLayout flowLayout_11 = (FlowLayout) panelButton.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		panelButton.setBackground(new Color(255, 255, 255));
		panelRight.add(panelButton);
		
		
	}
	
	public void initButton() {
		btnAddnew = new JButton("Add New");
		btnAddnew.setFocusPainted(false);
		btnAddnew.setBackground(new Color(65, 105, 225));
		btnAddnew.setForeground(new Color(65, 105, 225));
		panelButton.add(btnAddnew);
		
		btnClear = new JButton("Clear All");
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setFocusPainted(false);
		panelButton.add(btnClear);
		
		btnAddnew.addActionListener(this);
		btnClear.addActionListener(this);
	}
	
	public void initStudentID() {
		txtStudentID = new JTextField();
		panelLeft.add(txtStudentID);
		txtStudentID.setColumns(10);
		
		txtStudentID.addActionListener(action);
		
	}
	
	public void initBookISBN() {
		txtBookISBN = new JTextField();
		txtBookISBN.setColumns(20);
		panelRight.add(txtBookISBN);
		txtBookISBN.addActionListener(action);
	}

	Action action = new AbstractAction()
	{
		private static final long serialVersionUID = 1L;

		public void actionPerformed(ActionEvent e)
	    {
			try {
				if(e.getSource() == txtStudentID) {
					
					if(txtStudentID.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "StudentID is required");
						txtStudentName.setText("");
						txtContact.setText("");
					}
					else {
						MemberRegisterClass borrowList = new UserConnection().getReturnDate(Integer.parseInt(txtStudentID.getText()));
						txtStudentName.setText(borrowList.getFullname());
						txtContact.setText(borrowList.getPhone());
					}
				}
				else if(e.getSource() == txtBookISBN) {
					if(txtBookISBN.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Book ISBN is required");
						txtBookQty.setText("");
						lblBook_id.setText("");
					}
					else {
						BookClass book = new UserConnection().getBookInfo(txtBookISBN.getText());
						System.out.println(book.getTitle());
						txtBookQty.setText(book.numBookAvailable(book.getNumBorrow()) + "");
						lblBook_id.setText(book.getID() + "");
					}
				}
			} catch (Exception e1) {
				//JOptionPane.showMessageDialog(null, e1.getMessage());
			}
	        		
	    }

	};
	
	

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnAddnew)
			try {
				addNewBorrow();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		else if(e.getSource() == btnClear)
			clearText();
		
	}
	
	public void addNewBorrow() throws Exception {
			if(txtBookISBN.getText().isEmpty()) 
				throw new Exception("Book ISBN is required");
		
			
			if(txtCurrentContact.getText().isEmpty())
				txtCurrentContact.setText(txtContact.getText());
			
			if(Integer.parseInt(txtBookQty.getText()) < 1)
				throw new Exception("We are sorry! Our Books are out of stock!");
			
			int status = 1; // status == 1 means borrow but not yet return
			
			BorrowerClass borrow = new BorrowerClass(Integer.parseInt(txtStudentID.getText()), Integer.parseInt(lblBook_id.getText()), txtStudentName.getText(), txtCurrentContact.getText(), 
					txtBookISBN.getText(), Integer.parseInt(cboBorrowQty.getSelectedItem().toString()) , txtBorrowedDate.getText(), status);
			
			new UserConnection().addBorrower(borrow);

	}
	
	public void clearText() {
		txtStudentID.setText("");
		txtStudentName.setText("");
		txtContact.setText("");
		txtCurrentContact.setText("");
		
		txtBookISBN.setText("");
		txtBookQty.setText("");
		txtBorrowedDate.setText("");
	}
	
}