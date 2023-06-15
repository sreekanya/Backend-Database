package session6;

public class CovidCases {

	public static void main(String[] args) {
		String countryNames[] = {"USA","India","China","Japan"};
		String casesStatus[] = {"totalCases","recoveredCases","activeCases"};
		int totalCases = 0;
		int recovedCases = 1;
		int activeCases = 2;
		int[][] covidCases = {
				{2345,234,45},
				{345,235,290},
				{4566,3456,234},
				{2445,456,1234}
		};
		for(int id=0;id<covidCases.length;id++) {
			System.out.println("-------------------------------");
			System.out.println("Country : "+countryNames[id]);
			for(int c=0;c<casesStatus.length;c++) {
				System.out.print(casesStatus[c]+"\t");
			}
			System.out.println();
			for(int i=0;i<covidCases[id].length;i++) {
				
				System.out.print(covidCases[id][i]+"\t\t");
			}
			System.out.println();
		}

	}

}
