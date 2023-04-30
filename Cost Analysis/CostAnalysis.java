//Name: Arjit Gupta
//Date: 3rd March 2023
//Assignment: PA02

package helperMethods;

import javax.swing.JOptionPane;

public class CostAnalysis {

	// Initialising variables
	public int costHeads = 4, precision = 2;
	public double[] prodOneCosts = new double[costHeads];
	public double[] prodTwoCosts = new double[costHeads];
	public double[] expenseAggregate = new double[costHeads];
	public double[] expensePercents = new double[costHeads];	
	public double sumP1 = 0, sumP2 = 0, sumTotal = 0;
	public int maxExpenseIndexP1 = 0, maxExpenseIndexP2 = 0, maxExpenseIndexBoth = 0, minExpenseIndexP1 = 0, minExpenseIndexP2 = 0, minExpenseIndexBoth = 0;
	public String[] costHeadMap = {
			"Website marketing & Search engine marketing",
			"Social media marketing",
			"Radio advertising",
			"Newspaper advertising"
	};

	public static void main(String[] args) {
		// create new instance
		CostAnalysis newAnalysis = new CostAnalysis();
		
		// analyze and display
		newAnalysis.analyze();
		newAnalysis.display();
	}

	public CostAnalysis() {
		// take cost inputs from user.
		for(int input=0; input<costHeads; ++input) {
			prodOneCosts[input] = DataEntries.doubleInput("Please input "+costHeadMap[input]+" costs for product 1");
			prodTwoCosts[input] = DataEntries.doubleInput("Please input "+costHeadMap[input]+" costs for product 2");
		}
	}

	public void analyze() {
		//calculate analysis
		this.totalCostPerProduct();
		this.totalCostPerExpenditure();
		this.highestCostCalculator();
		this.lowestCostCalculator();
		this.percentageCalculator();
	}

	public void display() {
		// Uses HTML tags to create a table and add as a string in a JOptionPane message box
		String rows = "<html><table border=\"1\"><tr><td>Expenditure Item Name</td><td>Product 1</td><td>Product 2</td><td>Cost per expenditure</td></th>";
		for(int i = 0; i < costHeads; i++) {
			rows = rows + "<tr>";

			rows = rows + "<td>";
			rows = rows + costHeadMap[i];
			rows = rows + "</td>";

			rows = rows + "<td>$";
			rows = rows + prodOneCosts[i];
			rows = rows + "</td>";

			rows = rows + "<td>$";
			rows = rows + prodTwoCosts[i];
			rows = rows + "</td>";

			rows = rows + "<td>";
			rows = rows + "$" + DataEntries.customRound(expenseAggregate[i], precision) + " (" + DataEntries.customRound(expensePercents[i], precision) + "%)";
			rows = rows + "</td>";

			rows = rows + "</tr>";
		}
		rows = rows + "<tr><td>Total cost per product</td><td>$" + sumP1 + "</td><td>$" + sumP2 + "</td><td>$" + sumTotal + "</td></tr>";

		String customRowString = "<tr><td>%s Expenditure</td><td>%s</td><td>%s</td><td>%s</td></tr>";
		rows = rows + "<tr><td></td><td>Product 1</td><td>Product 2</td><td>Product 1 and 2 combined</td></tr>";
		rows = rows + String.format(customRowString, "Highest", costHeadMap[maxExpenseIndexP1], costHeadMap[maxExpenseIndexP2], costHeadMap[maxExpenseIndexBoth]);
		rows = rows + String.format(customRowString, "Lowest", costHeadMap[minExpenseIndexP1], costHeadMap[minExpenseIndexP2], costHeadMap[minExpenseIndexBoth]);

		rows = rows + "</table></html>";
		JOptionPane.showMessageDialog(null, rows);
	}


	public void totalCostPerProduct() {
		// caculates total cost by summing over all costs
		for(int i=0; i<costHeads; ++i) {
			sumP1 += prodOneCosts[i];
			sumP2 += prodTwoCosts[i];
		}
		sumTotal = sumP1 + sumP2;
	}

	public void totalCostPerExpenditure() {
		// calculates total cost per expenditure for each expenditure
		for(int i=0; i<costHeads; ++i) {
			expenseAggregate[i] = prodOneCosts[i]+prodTwoCosts[i];
		}
	}

	public void highestCostCalculator() {
		//loop for product 1
		double maxCost = 0, maxCostBoth = 0;
		for(int i=0; i<costHeads; ++i) {
			if(prodOneCosts[i] > maxCost) {
				maxCost = prodOneCosts[i];
				maxExpenseIndexP1 = i;
			}
		}
		maxCostBoth = maxCost;

		//loop for product 2
		maxCost = 0;
		for(int i=0; i<costHeads; ++i) {
			if(prodTwoCosts[i] > maxCost) {
				maxCost = prodTwoCosts[i];
				maxExpenseIndexP2 = i;
			}
		}

		//assumption: costs would not be equal
		maxExpenseIndexBoth = maxExpenseIndexP2;
		if(maxCostBoth>maxCost) {
			maxExpenseIndexBoth = maxExpenseIndexP1;
		}

	}

	public void lowestCostCalculator() {
		//loop for product 1
		double minCost = 0, minCostBoth = 0;
		for(int i=0; i<costHeads; ++i) {
			if(prodOneCosts[i] < minCost) {
				minCost = prodOneCosts[i];
				minExpenseIndexP1 = i;
			}
		}
		minCostBoth = minCost;

		//loop for product 2
		minCost = 0;
		for(int i=0; i<costHeads; ++i) {
			if(prodTwoCosts[i] < minCost) {
				minCost = prodTwoCosts[i];
				minExpenseIndexP2 = i;
			}
		}

		//assumption: costs would not be equal
		minExpenseIndexBoth = minExpenseIndexP2;
		if(minCostBoth<minCost) {
			minExpenseIndexBoth = minExpenseIndexP1;
		}
	}

	public void percentageCalculator() {
		for(int i=0; i<costHeads; ++i) {
			expensePercents[i] = (expenseAggregate[i]/sumTotal)*100;
		}
	}
}
