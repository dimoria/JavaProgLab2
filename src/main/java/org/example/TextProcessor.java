package org.example;

public class TextProcessor {

    public static void main(String[] args) {
        try {
            String text = "Привітик усім! Приклад речення, щоб змінити. Давайте почнемо?";
            System.out.println("Original text:\n" + text);

            String[] sentences = text.split("(?<=[.!?])\\s*");
            StringBuilder result = new StringBuilder();

            for (String sentence : sentences) {
                String trimmed = sentence.trim();
                if (trimmed.isEmpty()) continue;

                char endSymbol = trimmed.charAt(trimmed.length() - 1);
                if (".!?".indexOf(endSymbol) >= 0) {
                    trimmed = trimmed.substring(0, trimmed.length() - 1);
                } else {
                    endSymbol = ' ';
                }

                String[] words = trimmed.split("\\s+");
                if (words.length > 1) {
                    String first = words[0];
                    String last = words[words.length - 1];
                    words[0] = last;
                    words[words.length - 1] = first;
                }

                String modifiedSentence = String.join(" ", words) + endSymbol + " ";
                result.append(modifiedSentence);
            }

            System.out.println("\nModified text:\n" + result.toString().trim());

        } catch (Exception e) {
            System.err.println("Помилка під час обробки тексту: " + e.getMessage());
        }
    }
}