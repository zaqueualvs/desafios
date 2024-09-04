package com.alves.teste2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        List<Integer> fibonacci = new ArrayList<>();

        int anterior = 0;
        int proximo = 1;
        do {
            anterior = proximo - anterior;
            proximo = proximo + anterior;
            fibonacci.add(anterior);
        } while (anterior < num);
        if(fibonacci.contains(num)){
            System.out.println("Numero pertence a sequência de fibonacci");
        }else {
            System.out.println("Numero não pertence a sequência de fibonacci");
        }
    }
}
