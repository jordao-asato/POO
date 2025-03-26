/*
Crie um programa que imprima na tela vários triângulos de “*”. O número de
níveis do triângulo e a quantidade de triângulos deverão ser lidos do teclado.
Veja um exemplo abaixo com dois triângulos de três níveis cada:
 *
 **
 ***
 *
 **
 ***

*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int nivel, quant;

        System.out.println("Digite a quantidade de triangulos: ");
        quant = sc.nextInt();
        System.out.println("Digite o nível do(s) triangulo(s): ");
        nivel = sc.nextInt();

        while(quant > 0){
            for(int i = 1; i <= nivel; i++) {
                for(int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            quant--;
        }
        sc.close();
    }
}
