import java.util.Scanner;
import java.util.*;

public class AreaCirculo{
    public static void main(String[] args){
        double area, raio;
        Scanner teclado = new Scanner(System.in);
        System.out.printf("Informe o raio do circulo: ");
        raio = Double.parseDouble(teclado.next());
        area = Math.PI * Math.pow(raio, 2);
        System.out.println("Area do circulo = " + area);  
    }	
}
