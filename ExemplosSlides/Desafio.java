import java.util.*;
public class Desafio{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int fn = n;
		int r = 0, s, num=0, cont = 0;
		while(n > 0){
			s = n%2;
			r = (r*10) + s;
			n = n/2;
			cont++;
		}	

		for(int  i=0;i<cont;i++){
			s = r%10;
			num = (num*10) + s;
			r = r/10;
		}

		System.out.print(num);

	}
}

