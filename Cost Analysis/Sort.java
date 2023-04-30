//Name: Arjit Gupta
//Date: 3rd March 2023
//Assignment: PA02

package helperMethods;

import javax.swing.JOptionPane;

public class Sort {

	public static void selectionSort(Double priceArr[], String nameArray[]) {
		// implemented selection sort based on logic shown during class

		int i,j;
		for (i = 0; i < priceArr.length - 1; i++) {

			int currentMinIndex = i;
			double currentMin = priceArr[i];
			String currentMinInfo=nameArray[i];


			for(j=i+1;j<priceArr.length;j++) {
				if(priceArr[j]<currentMin) {
					currentMin=priceArr[j];
					currentMinInfo=nameArray[j];
					currentMinIndex=j;
				}
			}

			//swap priceArr[i] and priceArr[currentMinIndex] if necessary
			if(currentMinIndex!=j) {
				priceArr[currentMinIndex]=priceArr[i];
				priceArr[i]=currentMin;

				nameArray[currentMinIndex]=nameArray[i];
				nameArray[i]=currentMinInfo;

			}
		}

		JOptionPane.showMessageDialog(null, "Completed Sorting Arrays");
	}
}



