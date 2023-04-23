package PP03;

public class TaxIncome implements Taxable {

	@Override
	public double compStateTax(double grossPay) {
		return Taxable.STATE_TAX*grossPay;
	}

	@Override
	public double compFederalTax(double grossPay) {
		return Taxable.FEDERAL_TAX*grossPay;
	}

	@Override
	public double compIncomeTax(double grossPay) {
		return compStateTax(grossPay) + compFederalTax(grossPay);
	}
	// 1- this class implements the Taxable interface
	// 2- implement all the unimplemented abstract methods in the Taxable Interface, income tax is computed based on state and federal taxes   
}
