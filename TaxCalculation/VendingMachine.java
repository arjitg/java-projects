
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class VendingMachine {

	public static void main(String[] args) {
		String tMixItem = "Trail Mix", snickersItem = "Snickers", gumItem = "Chewing gum", cheetosItem = "Cheetos";
		double tMixPrice = 1.25, snickersPrice = 2, gumPrice = 0.5, cheetosPrice = 5.75;

		String catalogInputString="", chosenItemName;
		double chosenItemPrice;
		int catalogInputInt = 0;

		String catalogMsg = "1."+tMixItem+"\t\t$"+tMixPrice+"\n"
				+ "2."+snickersItem+"\t\t$"+snickersPrice+"\n"
				+ "3."+gumItem+"\t$"+gumPrice+"\n"
				+ "4."+cheetosItem+"\t\t$"+cheetosPrice;

		try {
			catalogInputString = JOptionPane.showInputDialog(
					null,
					new JTextArea(catalogMsg),
					"MY VENDING MACHINE OPTIONS",
					JOptionPane.INFORMATION_MESSAGE
					).trim();

			if(catalogInputString.isEmpty()) {
				throw new Exception("No input received. System aborting!");
			}
			catalogInputInt = Integer.parseInt(catalogInputString);

			if(!(catalogInputInt==1 || catalogInputInt==2 || catalogInputInt==3 || catalogInputInt==4)) {
				throw new Exception();
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(
					null,
					"You entered: "+catalogInputString+"\nInput must be 1,2,3 or 4. System Abort!",
					"ERROR",
					JOptionPane.ERROR_MESSAGE
					);
			System.exit(0);
		}

		//Item assignment
		if(catalogInputInt == 1) {
			chosenItemName = tMixItem;
			chosenItemPrice = tMixPrice;
		}
		else if(catalogInputInt == 2) {
			chosenItemName = snickersItem;
			chosenItemPrice = snickersPrice;
		}
		else if(catalogInputInt == 3) {
			chosenItemName = gumItem;
			chosenItemPrice = gumPrice;
		}
		else {
			chosenItemName = cheetosItem;
			chosenItemPrice = cheetosPrice;
		}

		//Bill insertion
		String billInputMsg = "Please insert money for "+chosenItemName
				+"\nExpected money is $"+chosenItemPrice
				+"\nYou many insert only $1, $5 and $10 bills."
				+"\nWe accept only one of these 3 bills"
				+"\nCards and changes are not accepted";

		String billInputString;
		double billInputValue = 0;
		double balancePrice = 0;
		int fiveDollarBills = 0, oneDollarBills = 0, halfDollarBills = 0, quarterDollarBills = 0;

		try {
			billInputString = JOptionPane.showInputDialog(
					null,
					new JTextArea(billInputMsg),
					"INSERT BILL",
					JOptionPane.INFORMATION_MESSAGE
					).trim();
			if(billInputString.isEmpty()) {
				throw new Exception("Invalid input. System aborting!");
			}

			billInputValue = Double.parseDouble(billInputString);

			if(!(billInputValue==1 || billInputValue==5 || billInputValue==10)) {
				throw new Exception("You entered: "+billInputValue+"\nBill must be 1,5 or 10 without decimals. System Abort!");
			}
			if(billInputValue < chosenItemPrice) {
				throw new Exception("You entered: "+billInputValue+"\nBill must be greater than "+chosenItemPrice+". System Abort!");
			}

			balancePrice = billInputValue-chosenItemPrice;
			if(balancePrice >= 5) {
				fiveDollarBills = (int)balancePrice/5;
			}
			balancePrice -= 5*fiveDollarBills;

			if(balancePrice >= 1) {
				oneDollarBills = (int)balancePrice/1;
			}
			balancePrice -= 1*oneDollarBills;

			if(balancePrice >= 0.5) {
				halfDollarBills = (int)(balancePrice/0.5);
			}
			balancePrice -= 0.5*halfDollarBills;

			if(balancePrice >= 0.25) {
				quarterDollarBills = (int)(balancePrice/0.25);
			}
			balancePrice -= 0.25*fiveDollarBills;

			String txnSummaryMsg = "You selected item "+catalogInputInt+" which is "+chosenItemName
					+"\n\nCost of "+chosenItemName+" is $"+chosenItemPrice
					+"\nYou inserted $"+billInputValue
					+"\nYour balance is $"+(billInputValue-chosenItemPrice)
					+"\n\nThe change you get is:"
					+"\n\t"+fiveDollarBills+" * $5"
					+"\n\t"+oneDollarBills+" * $1"
					+"\n\t"+halfDollarBills+" * $0.50"
					+"\n\t"+quarterDollarBills+" * $0.25";

			JOptionPane.showMessageDialog(
					null,
					new JTextArea(txnSummaryMsg),
					"TRANSACTION SUMMARY",
					JOptionPane.INFORMATION_MESSAGE
					);


		} catch (Exception ex) {
			JOptionPane.showMessageDialog(
					null,
					ex.getMessage(),
					"ERROR",
					JOptionPane.ERROR_MESSAGE
					);
			System.exit(0);
		}


	}

}
