package org.example;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("Racecar"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));

        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(13));
    }

    public static boolean checkForPalindrome(String text) {
        // İstenen özel karakterleri ve boşlukları temizle, hepsini küçük harfe çevir
        String cleaned = text.replaceAll("[.,?!_\\-\\s]", "").toLowerCase();
        
        // Veri yapısı olarak LinkedList'i bir Stack (Yığın) gibi kullanıyoruz
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : cleaned.toCharArray()) {
            stack.push(c); // LIFO mantığıyla en son giren en üste
        }

        StringBuilder reversedText = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedText.append(stack.pop()); // Çekerken tersten almış oluyoruz
        }

        return cleaned.equals(reversedText.toString());
    }

    public static String convertDecimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0";
        }
        
        // Binary çevirisi tam bir Stack (Yığın) operasyonudur. Kalanları üst üste yazar, tersten okuruz.
        LinkedList<Integer> stack = new LinkedList<>();
        
        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal = decimal / 2;
        }

        StringBuilder binaryString = new StringBuilder();
        while (!stack.isEmpty()) {
            binaryString.append(stack.pop());
        }

        return binaryString.toString();
    }
}
