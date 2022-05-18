import java.util.*;
public class LabC {

	public static void main(String[] args) {
		
		
        Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		String binaryString = sc.next();
		
		
		BinaryStringManipulator BSm = new BinaryStringManipulator();
		System.out.println(BSm.onemax(binaryString, l));
		
		

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
}