import java.util.Scanner;

public class LabD {

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		int bin = 0;
		int j = 0;
		
		
		int l = 0;
		l = read.nextInt();
		
		String str;
		str = read.next();
		
		for(int i = 0; i < l; i++){
		    if(str.charAt(i) == '1'){ 
		        j = j + (int) Math.pow(2, l - 1 - i);
		    } 
		}
		
		System.out.println((int) Math.pow(j, 2));
	}
}