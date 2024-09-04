package com.alves.teste3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class Teste3 {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Gasto> gastos = mapper.readValue(new File("src/main/resources/dados.json"), new TypeReference<List<Gasto>>() {
            });

            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double soma = 0.0;
            int count = 0;

            for (Gasto gasto : gastos) {
                if (gasto.valor() != 0.0) {
                    if (gasto.valor() < menorValor) {
                        menorValor = gasto.valor();
                    }
                    if (gasto.valor() > maiorValor) {
                        maiorValor = gasto.valor();
                    }
                    soma += gasto.valor();
                    count++;
                }
            }
            double media = soma / count;
            System.out.println("Menor valor: " + menorValor);
            System.out.println("Maior valor: " + maiorValor);
            System.out.println("Total de dias maior que a media: " + gastos.stream().filter(aux -> aux.valor() > media).count());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

record Gasto(
        String dia,
        Double valor) {

}