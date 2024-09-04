package com.alves.hotmart;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class IndicePerfeito {
    public static void main(String[] args) throws URISyntaxException {
        WebSocketClient client = new WebSocketClient(new
                URI("wss://ctf-challenges.devops.hotmart.com/echo")) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                send("start twosum");
            }

            @Override
            public void onMessage(String message) {
                if (message.startsWith("[*] Array:")) {
                        send(twoSum(message).toString());
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

    public static List twoSum(String message) {

        String[] messages1 = message
                .replace("\n", "")
                .replace(" ", "")
                .split("Target:");

        Integer target = Integer.parseInt(messages1[1]);
        String[] messages2 = messages1[0].split("Array:");
        Integer[] numbers = getNumbers(messages2);

        for (int number1 : numbers) {
            for (int number2 : numbers) {
                if (target == (number1 + number2)) {
                    return List.of(number1, number2);
                }
            }
        }
        return List.of();

    }

    public static Integer[] getNumbers(String[] messages) {
        return Arrays.stream(messages[1]
                        .replace("[", "")
                        .replace("]", "")
                        .split(","))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
