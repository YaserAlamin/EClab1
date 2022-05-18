import java.util.*;

public class LabE {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int l = sc.nextInt();
		
		ArrayList<BinaryString> binaryStrings = new ArrayList<BinaryString>();
		ArrayList<Double> u = new ArrayList<Double>();
		
		// Reads all the BinaryString and respective fitness values
		for(int i = 0; i<N; i++){
			BinaryString binaryString = new BinaryString();
			binaryString.setBinaryString(sc.next() + "");
			binaryString.setFitness(sc.nextDouble());
			binaryStrings.add(binaryString);
		}
		
		// Reads all the random values
		for(int i = 0; i<2*N; i++){
			u.add(sc.nextDouble());
		}
		
		Tournament tournament = new Tournament();
		
		// runs N tournament
		for(int i = 0; i <N; i++){
			
			// select the corresponding random numbers
			ArrayList<Double> u_ = new ArrayList<Double>();
			u_.addAll(u.subList(i*2, i*2+2));
			
			// select and prints the competition winner
			BinaryString winner = tournament.runTournament(binaryStrings, u_ );
			System.out.println(winner.getBinaryString());
		}

	
		
	}

}


class  Tournament{
	
	// Runs the tournament for the elements on binaryStrings list, randomly chooses u.size elements, and from those winner elements choose the fittest as the ultimate winner
	public BinaryString runTournament(ArrayList<BinaryString> binaryStrings, ArrayList<Double> u){
		ArrayList<BinaryString> randomBinaryStrings = new ArrayList<BinaryString>();
		
		// Selects u.size random binaryStrings
		for(int i = 0; i<u.size(); i++){
			randomBinaryStrings.add(this.selectRandomBinaryString(binaryStrings, u.get(i)));
		}
		
		return this.selectFittestBinaryString(randomBinaryStrings);
		
	}
	
	// Recieves a random number and the smallest and biggest index numbers, and returns a selected one
	public int selectRandom(int a, int b, double u){
		return (int)(a + (Math.floor(u * (double)(b - a + 1))));
	}
	
	// Recieves a list of BinaryString and a random number and returns the selected BinaryString
	public BinaryString selectRandomBinaryString(ArrayList<BinaryString> binaryStrings, double u){
		int index = this.selectRandom(1,binaryStrings.size(), u);
		return binaryStrings.get(index-1);
	}
	
	// Recieves a non-empty list of BinaryString and returns the fittest element
	public BinaryString selectFittestBinaryString(ArrayList<BinaryString> binaryStrings){
		Iterator<BinaryString> iterator = binaryStrings.iterator();

		// If the list is not empty search for the fittest element
		if(!binaryStrings.isEmpty()){
			BinaryString fittest, current;
			fittest = current = iterator.next();
			
			// while there is elementes on the list, update the fittest
			while(iterator.hasNext()){
				current = iterator.next();
				if(current.getFitness() > fittest.getFitness())
					fittest = current;
			}
			
			return fittest;

			
		}else // if the list is empty return null
			return null;
	}


}
class BinaryString {
	
	private String binaryString;
	private double fitness;
	
	public String getBinaryString() {
		return binaryString;
	}
	public void setBinaryString(String binaryString) {
		this.binaryString = binaryString;
	}
	public double getFitness() {
		return fitness;
	}
	public void setFitness(double d) {
		this.fitness = d;
	}
}

class BinaryStringManipulator {
	
	// Recieves a list with l random numbers and generates a binary string from those numbers
	public String generate(List<Double> u){
		
		// the default binary string
		String binaryString = "";
		
		// while there is random numbers, iterate through them (there should be l of them)
		Iterator<Double> iterator = u.iterator();
		double current;
		while(iterator.hasNext()){
			
			// gets the next random number
			current = iterator.next();
			
			// if the random number is bigger less than 0.5 add 1 to the binary string, else add 0
			if(current < 0.5)
				binaryString = binaryString + "0";
			else
				binaryString = binaryString + "1";
		}
		
		// return the binaryString
		return binaryString;		
	}
	
	// Recieves a binaryString and calculates the number of 1s in that String
	public int onemax(String binaryString, int length){
		int count=0;
		
		for(int i = 0; i<length;i++)
			if(binaryString.charAt(i) == '1')
				count++;
		
		return count;
	}

	// Converts the binaryString into a decimal number
	public int binaryStringtoDecimal(String binaryString, int length){
		int result = 0;
		
		for(int i =0; i<length; i++)
			result+=Math.pow(2, i) * Integer.parseInt(binaryString.charAt(length-i-1)+"");
		
		return result;
	}

	// calculates the fitness of a binaryString based on the function f(x)=x^2
	public int fitSquareX(String binaryString, int length){
		return (int) Math.pow(this.binaryStringtoDecimal(binaryString,length),2);
	}
}
