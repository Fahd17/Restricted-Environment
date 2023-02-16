import java.util.Scanner;

public class FactorialCorrect {

    public static void main(String[] args) {
	Scanner myObj = new Scanner(System.in);  
    

		int number = myObj.nextInt();  
		int i,fact=1;  
 
		for(i=1;i<=number;i++){    
			fact=fact*i;    
		}   
		System.out.println(fact);

    }
}
