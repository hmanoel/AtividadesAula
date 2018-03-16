import java.util.Scanner;

public class Switch{
    public static void main(String[] args){
        int op;
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a opcao: ");
        op = input.nextInt();
        switch(op){
            case 1:
                System.out.println("Opcao 1");
                break;
            case 2:
                System.out.println("Opcao 2");
                break;
            case 3:
                System.out.println("Opcao 3");
                break;
            default:
                System.out.println("Opcao Invalida");
        }  
    }	
}
