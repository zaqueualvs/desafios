package com.alves.primos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimosRecursiva {
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
            if (primo(i, 2)) {
                primos.add(i);
            }
        }
        System.out.println("p(" + numero + ") = " + primos);
    }

    private static boolean primo(int numero, int divisor) {
        if (numero / 2 < divisor) {
            return true;
        } else {
            if (numero % divisor == 0) {
                return false;
            } else {
                return primo(numero, divisor + 1);
            }
        }
    }
}
