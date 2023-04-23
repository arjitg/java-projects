//Name: Arjit Gupta
//Date: 30 March 2023
//Assignment: PP03

package PP03;

public class Sort {

	public static void selectionSortAudience(String[] audienceList) {
		for (int i = 0; i < audienceList.length - 1; i++) {
			// Find the minimum in the list[i..list.length-1]
			String currentMin = audienceList[i];
			int currentMinIndex = i;

			for (int j = i + 1; j < audienceList.length; j++) {
				if(currentMin.compareTo(audienceList[j]) == 1){
					currentMin = audienceList[j];
					currentMinIndex = j;
				}
			}

			//Swap
			if (currentMinIndex != i) {
				audienceList[currentMinIndex] = audienceList[i];
				audienceList[i] = currentMin;
			}
		}
	}
}