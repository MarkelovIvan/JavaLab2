import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try {
            // Заданий текст
            StringBuffer text = new StringBuffer("Речення є питальне? Це не є питальне речення! Чого саме тут питання? Невже тут немає чотирьох літер? Є чотири малі літери у цьому реченні.");
            // Довжина слів
            int wordLength = 4;

            // Виклик методу для обробки тексту
            findAndPrintWords(text, wordLength);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void findAndPrintWords(StringBuffer text, int wordLength) {
        // Набір для зберігання знайдених слів без повторень
        Set<String> uniqueWords = new HashSet<>();
        StringBuffer currentSentence = new StringBuffer();

        // Проходимо по кожному символу тексту
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            currentSentence.append(c);

            // Якщо кінець речення є знаком питання
            if (c == '?') {
                extractWordsFromSentence(currentSentence, wordLength, uniqueWords);
                currentSentence.setLength(0); // Очищаємо для наступного речення
            } else if (c == '.' || c == '!') {
                currentSentence.setLength(0); // Очищаємо непитальні речення
            }
        }

        // Виведення знайдених слів
        System.out.println("Слова довжиною " + wordLength + " символів:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }

    public static void extractWordsFromSentence(StringBuffer sentence, int wordLength, Set<String> uniqueWords) {
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                currentWord.append(c);
            } else {
                // Якщо слово досягло необхідної довжини, додаємо його в набір
                if (currentWord.length() == wordLength) {
                    uniqueWords.add(currentWord.toString()); // Додаємо слово як String
                }
                currentWord.setLength(0); // Очищаємо для наступного слова
            }
        }

        // Обробка останнього слова в реченні
        if (currentWord.length() == wordLength) {
            uniqueWords.add(currentWord.toString());
        }
    }
}
