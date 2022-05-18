import java.util.*;
public class LabC2 {


	public static void main(String[] args) {
		
		
        Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		String binaryString = sc.next();
		
		int count=0;
		
		for(int i = 0; i<l;i++)
			if(binaryString.charAt(i) == '1')
				count++;
		
		
		System.out.println(count);
		
		

	}

}
