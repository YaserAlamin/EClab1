import java.util.*;


public class LabB2 {

	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		Scanner read = new Scanner (System.in);
		int N,l,n,L;
		double u;
				
		N = read.nextInt();
		l = read.nextInt();
		
		int[][] pop = new int [N][l];
		
		for (n=0; n<N; n++){
			for (L=0; L<l;L++){
				u = read.nextDouble();
				
				if (u>=0.5) pop[n][L]=1;
				else pop[n][L]=0;
				
			}				
		}
		
		for (n=0; n<N; n++){
			for (L=0; L<l;L++){		
				System.out.print(pop[n][L]);	
			}	
			System.out.println();
		}
			
				
	}
}
