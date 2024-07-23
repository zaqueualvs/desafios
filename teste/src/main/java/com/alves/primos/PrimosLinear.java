package com.alves.primos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimosLinear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Insira um número: ");
        int numero = scan.nextInt();

        if(numero < 2){
            System.out.printf("Número inválido: %d",numero);
            System.exit(0);
        }

        List<Integer> primos = new ArrayList<>();
        for (int i = 2; i <= numero; i++) {
            int aux = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    aux++;
                }
            }
            if (aux == 2) {
                primos.add(i);
            }
        }
        System.out.println("p(" + numero + ") = " + primos);
    }
}
