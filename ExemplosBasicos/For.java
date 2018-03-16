import java.util.Scanner;

public class For{
    public static void main(String[] args){
        int op;
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a opcao: ");
        op = input.nextInt();
        for(int x=1; x<=op; x++){
            System.out.println("Op vale " + op + " e x vale " + x);
        } 
    }	
}
