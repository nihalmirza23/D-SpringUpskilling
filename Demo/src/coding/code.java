package coding;

import java.util.Scanner;

public class code {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
	System.out.println("Number is"+num);
	int sum=0;
	while(num>0) {
		sum=sum+(num%10);
			num=num/10;
	}
	}

}
