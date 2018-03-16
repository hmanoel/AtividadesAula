import java.util.Scanner;

public class DoWhile{
    public static void main(String[] args){
        int op;
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a opcao: ");
        op = input.nextInt();
        do {
            System.out.println("Op vale " + op);
            op++;        
        } while(op <= 3);  
    }	
}
