package com.alves.hotmart;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class SepararParImpar {
    public static void main(String[] args) throws URISyntaxException {
        WebSocketClient client = new WebSocketClient(new
                URI("wss://ctf-challenges.devops.hotmart.com/echo")) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                send("start palindromo");
            }

            @Override
            public void onMessage(String message) {
                if (message.startsWith("[*] Word:")) {
                    send(palindromo(message));
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

    public static String palindromo(String message) {
        String[] messages = message.replace(" ", "").split(":");
        String word = messages[1];
        int n = word.length();
        String largestPalindrome = "";

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subStr = word.substring(i, j);
                if (subStr.length() > 1 && isPalindrome(subStr) && subStr.length() > largestPalindrome.length()) {
                    largestPalindrome = subStr;
                }
            }
        }

        return largestPalindrome.isEmpty() ? "Sem palindromo" : largestPalindrome;

    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
