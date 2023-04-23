package PP03;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class UserGUI extends JPanel {
	// private JLabel empHeadJLabel;
	private JLabel empIDJLabel;
	private JLabel empfNameJLabel;
	private JLabel emplNameLabel;
	private JLabel empStatusJLabel;
	private JTextField empIDJTextField;
	private JTextField empfNameJTextField;
	private JTextField emplNameTextField;
	// private JTextField empStatusJTextField;
	private JRadioButton fteEmployee;
    private JRadioButton hrlyEmployee;
	private ButtonGroup empStatusGrp;

	private JLabel addrStreetJLabel;
	private JLabel addrAptJLabel;
	private JLabel addrCityLabel;
	private JLabel addrStateJLabel;
	private JLabel addrZipJLabel;
	private JTextField addrStreetJTextField;
	private JTextField addrAptJTextField;
	private JTextField addrCitJTextField;
	private JTextField addrStateJTextField;
	private JTextField addrZipJTextField;

	private JLabel payPeriodJLabel;
	private JLabel ppIDJLabel;
	private JTextField ppIDJTextField;
	private JLabel ppsDateJLabel;
	private JTextField ppsDateJTextField;
	private JLabel ppeDateJLabel;
	private JTextField ppeDateJTextField;
	
	private JLabel payRecordJLabel;
	private JLabel prIDJLabel;
	private JLabel incomeJLabel;
	private JLabel monthsJLabel;
	private JLabel hoursJLabel;
	private JLabel rateJLabel;
	private JTextField prIDJTextField;
	private JTextField incomeJTextField;
	private JTextField monthsJTextField;
	private JTextField hoursJTextField;
	private JTextField rateJTextField;

	private JLabel statsJLabel;

	private JTextArea textArea;
	private JScrollPane jp;

	private JButton addEmpButton;
	private JButton addPayRecordButton;
	private JButton CloseButton;

	private PayRoll payRoll;
	private String fileName = "PayRoll.txt";
	private String payRecordFile = "PayRecord.txt";

	private void validateEmployeeFields(){
		if(this.empIDJTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Employee ID is empty");
			return;
		}
		if(this.empfNameJTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "First name is empty");
			return;
		}
		if(this.emplNameTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Last name is empty");
			return;
		}
	}

	private void validateAddrFields(){
		if(
			this.addrStateJTextField.getText().isEmpty() 
			|| this.addrAptJTextField.getText().isEmpty()
			|| this.addrCitJTextField.getText().isEmpty()
			|| this.addrZipJTextField.getText().isEmpty()
		){
			JOptionPane.showMessageDialog(null, "Address details are incomplete.");
			return;
		}
	}

	private void validatePayRecordFields(){
		if(this.prIDJTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Pay Record ID is empty");
			return;
		}
		if(fteEmployee.isSelected()){
			if(this.incomeJTextField.getText().isEmpty() || this.monthsJTextField.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Both Month and income should be present for fulltime employee");
				return;
			}
		}
		if(hrlyEmployee.isSelected()){
			if(this.hoursJTextField.getText().isEmpty() || this.rateJTextField.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Both hours and rate should be present for hourly employee");
				return;
			}
		}
		if(this.emplNameTextField.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Last name is empty");
			return;
		}
	}


	public UserGUI() {
		// prompt the user to input the number of pay records
		int n = DataEntries.intInput("Enter the number of pay records");
		this.payRoll = new PayRoll(fileName, n);

		initGUI();
		doTheLayout();
		updateTextarea();

		addEmpButton.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e){
				validateEmployeeFields();
				validateAddrFields();
				addEmployee();
				updateTextarea();
			}
		});

		addPayRecordButton.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(payRoll.employeeMap.get(Integer.parseInt(empIDJTextField.getText().trim())) == null){
					JOptionPane.showMessageDialog(null, "Please add employee first");
				}
				validatePayRecordFields();
				addPayRecord();
				updateTextarea();
			}
		});
		
		CloseButton.addActionListener( new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e){
				payRoll.writeToFile();
				close();
			}
		});	
	} // end of constructor

	private void initGUI(){
		// this.empHeadJLabel = new JLabel("Employee");
		this.empIDJLabel = new JLabel("ID");
		this.empfNameJLabel = new JLabel("First Name");
		this.emplNameLabel = new JLabel("Last Name");
		this.empStatusJLabel = new JLabel("Status");
		this.empIDJTextField = new JTextField(5);
		this.empfNameJTextField = new JTextField(10);
		this.emplNameTextField = new JTextField(10);
		this.fteEmployee = new JRadioButton("Fulltime", true);
		this.hrlyEmployee = new JRadioButton("Hourly");
		this.empStatusGrp = new ButtonGroup();
		this.empStatusGrp.add(fteEmployee);
		this.empStatusGrp.add(hrlyEmployee);

		this.addrStreetJLabel = new JLabel("Street");
		this.addrAptJLabel = new JLabel("Apt");
		this.addrCityLabel = new JLabel("City");
		this.addrStateJLabel = new JLabel("State");
		this.addrZipJLabel = new JLabel("Zip");
		this.addrStreetJTextField = new JTextField(10); 
		this.addrAptJTextField = new JTextField(5); 
		this.addrCitJTextField = new JTextField(10); 
		this.addrStateJTextField = new JTextField(10); 
		this.addrZipJTextField = new JTextField(6); 

		this.payPeriodJLabel = new JLabel("Pay Period");
		this.ppIDJLabel = new JLabel("ID");
		this.ppIDJTextField = new JTextField(5);
		this.ppsDateJLabel = new JLabel("Start date");
		this.ppsDateJTextField = new JTextField(9);
		this.ppeDateJLabel = new JLabel("End date");
		this.ppeDateJTextField = new JTextField(9);

		this.payRecordJLabel = new JLabel("Pay Record");		
		this.prIDJLabel = new JLabel("ID");
		this.incomeJLabel = new JLabel("Monthly Income");
		this.monthsJLabel = new JLabel("Months");
		this.hoursJLabel = new JLabel("Hours");
		this.rateJLabel = new JLabel("Hourly rate");
		this.prIDJTextField = new JTextField(5); 
		this.incomeJTextField = new JTextField(6); 
		this.monthsJTextField = new JTextField(6); 
		this.hoursJTextField = new JTextField(5); 
		this.rateJTextField = new JTextField(4); 
		
		this.statsJLabel = new JLabel("Statistics and current data");
		this.textArea = new JTextArea(10, 10);
		this.jp = new JScrollPane(textArea);
		this.textArea.setEditable(false);
		this.textArea.setLineWrap(true);
		this.textArea.setWrapStyleWord(true);

		this.addEmpButton = new JButton("Add Employee");
		this.addPayRecordButton = new JButton("Add Pay Record");
		this.CloseButton = new JButton("Close");
		
		// testing
		// textArea.append("This is an editable JTextArea. " +
		// 		"A text area is a \"plain\" text component, " +
		// 		"which means that although it can display text " +
		// 		"in any font, all of the text is in the same font."
		// );
		
	}// end of creating objects method
	
	private void doTheLayout(){
		JPanel topEmp = new JPanel();
		JPanel bottomEmp = new JPanel();
		JPanel bottomEmpAddr = new JPanel();
		JPanel bottomEmp2 = new JPanel();
		JPanel center = new JPanel();
		JPanel bottompr1 = new JPanel();
		JPanel bottompr2 = new JPanel();
		JPanel bottomStats = new JPanel();
		
		topEmp.setLayout( new FlowLayout());
		bottomEmp.setLayout( new FlowLayout());
		bottomEmpAddr.setLayout( new FlowLayout());
		bottomEmp2.setLayout( new FlowLayout());
		center.setLayout( new FlowLayout());
		bottompr1.setLayout( new FlowLayout());
		bottompr2.setLayout( new FlowLayout());
		bottomStats.setLayout( new FlowLayout());
		
		topEmp.add(empIDJLabel);
		topEmp.add(empIDJTextField);
		topEmp.add(empfNameJLabel);
		topEmp.add(empfNameJTextField);		
		topEmp.add(emplNameLabel);
		topEmp.add(emplNameTextField);		
		bottomEmp.add(empStatusJLabel);
		bottomEmp.add(fteEmployee);
		bottomEmp.add(hrlyEmployee);
		bottomEmpAddr.add(addrStreetJLabel);
		bottomEmpAddr.add(addrStreetJTextField);
		bottomEmpAddr.add(addrAptJLabel);
		bottomEmpAddr.add(addrAptJTextField);		
		bottomEmpAddr.add(addrCityLabel);
		bottomEmpAddr.add(addrCitJTextField);
		bottomEmpAddr.add(addrStateJLabel);
		bottomEmpAddr.add(addrStateJTextField);		
		bottomEmpAddr.add(addrZipJLabel);
		bottomEmpAddr.add(addrZipJTextField);	
		bottomEmp2.add(addEmpButton);
		center.add(payPeriodJLabel);
		center.add(ppIDJLabel);
		center.add(ppIDJTextField);
		center.add(ppsDateJLabel);
		center.add(ppsDateJTextField);
		center.add(ppeDateJLabel);
		center.add(ppeDateJTextField);
		bottompr1.add(payRecordJLabel);
		bottompr1.add(prIDJLabel);
		bottompr1.add(prIDJTextField);
		bottompr2.add(addPayRecordButton);
		bottompr2.add(incomeJLabel);
		bottompr2.add(incomeJTextField);
		bottompr2.add(monthsJLabel);
		bottompr2.add(monthsJTextField);
		bottompr2.add(hoursJLabel);
		bottompr2.add(hoursJTextField);
		bottompr2.add(rateJLabel);
		bottompr2.add(rateJTextField);
		bottomStats.add(statsJLabel);
		bottomStats.add(jp);
		bottomStats.add(CloseButton);

		add(topEmp, "North");
		add(bottomEmp, "North");
		add(bottomEmpAddr, "North");
		add(bottomEmp2, "North");
		add(center, "Center");
		add(bottompr1, "South");
		add(bottompr2, "South");
		add(bottomStats, "South");
	}// end of Layout method
	
	void addEmployee(){
		Address addr = new Address(
			addrStateJTextField.getText(), 
			Integer.parseInt(addrAptJTextField.getText()),
			addrCitJTextField.getText(),
			addrStateJTextField.getText(),
			Integer.parseInt(addrZipJTextField.getText())
		);

		Employee emp = this.payRoll.createEmployee(
			Integer.parseInt(empIDJTextField.getText()), 
			fteEmployee.isSelected()?Status.FullTime:Status.Hourly
		);

		emp.fName = empfNameJTextField.getText();
		emp.lName = emplNameTextField.getText();
		emp.address = addr;
		payRoll.employeeMap.put(Integer.parseInt(empIDJTextField.getText()), emp);
		JOptionPane.showMessageDialog(null, "Employee added");
		textArea.append(emp.toString());
		textArea.setText(textArea.getText());

		// String mytext = textArea.getText();
		
	}// end of transfer action event method

	void addPayRecord(){
		try {
			if(Math.abs(payRoll.format.parse(ppeDateJTextField.getText()).getTime() 
				- payRoll.format.parse(ppsDateJTextField.getText()).getTime()) < 1){
				JOptionPane.showMessageDialog(null, "Dates need to be correct.");
				return;
			}
			PayPeriod pp = new PayPeriod(
				Integer.parseInt(ppIDJTextField.getText().trim()),
				payRoll.format.parse(ppsDateJTextField.getText()),
				payRoll.format.parse(ppeDateJTextField.getText())
			);
			
			payRoll.createPayRecord(
				Integer.parseInt(empIDJTextField.getText()),
				payRoll.employeeMap.get(Integer.parseInt(empIDJTextField.getText())),
				pp,
				Double.parseDouble(incomeJTextField.getText()),
				Integer.parseInt(monthsJTextField.getText().trim()),
				Double.parseDouble(hoursJTextField.getText().trim()),
				Double.parseDouble(rateJTextField.getText().trim())
			);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// end of transfer action event method
	
	void updateTextarea(){
		textArea.setText(textArea.getText());
	}

	void close(){
		System.exit(0);
	}// end of transfer action event method

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Pay Roll");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = f.getContentPane();
		contentPane.add(new UserGUI());
		f.pack();
		f.setSize(800, 500);
		f.setVisible(true);
	}
}
