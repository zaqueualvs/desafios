package com.alves.teste5;

import java.util.Scanner;

public class Teste5 {

    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        String palavra = scan.nextLine();

        for(int i = palavra.length() - 1; i >= 0; i--) {
            System.out.print(palavra.charAt(i));
        }
    }
}
