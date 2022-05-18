

import java.util.*;

public class Lab1 {

	public static void main(String[] args) {

		Scanner s = new Scanner (System.in);
		int n,k;
		int a = 0,l,d;
		 // System.out.println("input the size of the collection");
		n = s.nextInt();

		 // System.out.println("input the 1 st number");
		d = s.nextInt();

		for (k=0; k<n-1; k++){
			 // System.out.println("input more number");
			l = s.nextInt();

			if (l<d) a=d;
			else a=l;

			d=a;
		}
		// System.out.println("the maximum number is ");
		System.out.println(a);
		// TODO Auto-generated method stub

	}

}
