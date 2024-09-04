package com.alves.teste4;

import java.util.Arrays;
import java.util.List;

public class Teste4 {

    public static void main(String[] args) {
        List<Estado> estados = Arrays.asList(
                new Estado("SP", 67.836),
                new Estado("RJ", 36.678),
                new Estado("MG", 29.229),
                new Estado("ES", 27.165),
                new Estado("Outros", 19.849)
        );

        double total = estados.stream().map(aux -> aux.valor()).reduce(0.0, Double::sum);
        estados.stream().forEach(aux -> {
            System.out.printf("%s representa  %5.3f \n", aux.nome(), (aux.valor()/total)*100);
        });

    }
}

record Estado(
        String nome,
        Double valor) {

}
