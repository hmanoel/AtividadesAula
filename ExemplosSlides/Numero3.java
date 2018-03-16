import java.util.Random;
import java.util.Scanner;

public class Numero3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random gerador = new Random();
		int acerto = gerador.nextInt(11);
		int tentativa;
		int numerotentativa = 3;
		do{
			System.out.printf("Digite um numero: ");
			tentativa = input.nextInt();
			if (tentativa == acerto){
				System.out.printf("Voce acertou Parabens");
				numerotentativa = 0;						
			}else {
				numerotentativa--;
			}
		} while(numerotentativa > 0);
	}
}
