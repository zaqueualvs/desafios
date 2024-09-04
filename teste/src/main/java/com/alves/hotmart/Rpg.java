package com.alves.hotmart;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

public class Rpg {
    public static void main(String[] args) throws URISyntaxException {
        WebSocketClient client = new WebSocketClient(new
                URI("wss://ctf-challenges.devops.hotmart.com/echo")) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                send("start behappy");
            }

            @Override
            public void onMessage(String message) {
                if (message.startsWith("[*] Number:")) {
                    send(isHappy(message));
                }
                System.out.println(message);
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
            }
        };
        client.connect();
    }

    public static String isHappy(String message) {
        String[] messages = message
                .replace(" ", "")
                .replace("\n", "")
                .split(":");
        String number = messages[1];

        return calcularNumeroFeliz(Integer.parseInt(number)) ? "Feliz" : "Infeliz";
    }

    public static boolean calcularNumeroFeliz(int number) {
        Set<Integer> visitados = new HashSet<>();
        while (number != 0 && !visitados.contains(number)) {
            visitados.add(number);
            number = somaQuadradosDosDigitos(number);
        }
        return number == 1;
    }


    public static int somaQuadradosDosDigitos(int numero) {
        int soma = 0;
        while (numero > 0) {
            int digito = numero % 10;
            soma += digito * digito;
            numero /= 10;
        }
        return soma;
    }
}
