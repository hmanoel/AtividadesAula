import java.util.Scanner;

public class While{
    public static void main(String[] args){
        int op;
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a opcao: ");
        op = input.nextInt();
        while(op <= 3){
                System.out.println("Op vale " + op);
                op++;
        }  
    }	
}
