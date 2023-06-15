package session8;

public class WhyMethods {
	static int maxValue(int[] array) {
		int max = array[0];
		for(int id=0;id<array.length;id++) {
			if(array[id]>max) {
				max=array[id];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] productPrices = {10,23,45,18,30};
		int[] cricketScores = {30,45,78,99,29};
		int[] covidCases = {3456,34523,4567};
		
		//WhyMethods ref = new WhyMethods();
		
		System.out.println("Max value in ProductPrices :"+WhyMethods.maxValue(productPrices));
		System.out.println("Max value in CricketScores :"+WhyMethods.maxValue(cricketScores));
		System.out.println("Max value in covidCases :"+WhyMethods.maxValue(covidCases));
	
	
	}

}
