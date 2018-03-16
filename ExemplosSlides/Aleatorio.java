import java.util.Scanner;

public class Aleatorio{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String nome = "";
		System.out.printf("Digite seu nome: ");
		nome = input.next();
		int hrstrab;
        	System.out.printf("Digite as horas trabalhadas: ");
        	hrstrab = input.nextInt();
		int valortrab;
        	System.out.printf("Digite quanto tu ganha por hora: ");
        	valortrab = input.nextInt();
		int total;
		total = hrstrab * valortrab;
		System.out.printf("\nMeu salario é %d\n",total);
	}
}
