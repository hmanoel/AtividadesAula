import java.util.Scanner;

public class IfElse{
    public static void main(String[] args){
        int idade;
        Scanner input = new Scanner(System.in);
        System.out.print("Digite sua idade: ");
        idade = input.nextInt();
        if(idade < 18){
            System.out.println("Entrada nao permitida");        
        }
        else {
            System.out.println("Entrada Permitida");
        }  
    }	
}
