package com.alves.fibonacci;

import java.util.Scanner;

public class FibonacciLinear {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Insira um número: ");
        int numero = scan.nextInt();

        if (numero >= 0) {
            System.out.printf("fibonacci(%d) = %d", numero, fib(numero));
        } else {
            System.out.printf("Número inválido: %d", numero);
        }
    }
    public static int fib(int numero) {
        int fibonacci = 0, aux = 1;
        for (int i = 1; i <= numero; i++) {
            fibonacci = fibonacci + aux;
            aux = fibonacci - aux;
        }
        return fibonacci;
    }
}