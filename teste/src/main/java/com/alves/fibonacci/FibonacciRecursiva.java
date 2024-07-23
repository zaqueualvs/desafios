package com.alves.fibonacci;

import java.util.Scanner;

public class FibonacciRecursiva {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Insira um numero: ");
        int numero = scan.nextInt();

        if(numero >= 0){
            System.out.printf("fib(%d) = %d",numero ,fib(numero));
        }else{
            System.out.printf("Número inválido: %d",numero);
        }

    }

    public static int fib(int n) {
        return (n < 2) ? n : fib(n - 1) + fib(n - 2);
    }
}