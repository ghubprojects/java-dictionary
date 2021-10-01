package version1;

import java.util.Scanner;

public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();

    void insertFromCommandline() {
        System.out.print("Nhập vào số lượng từ vựng: ");
        Scanner input = new Scanner(System.in);
        int numOfWords = input.nextInt();
        for (int i = 0; i < numOfWords; i++) {
            Word newWord = new Word();
            System.out.println("No " + (i + 1) + ": ");
            if (i == 0) {
                String begin = input.nextLine();
            }
            System.out.print("Word_target: ");
            newWord.setWord_target(input.nextLine());
            System.out.print("Word_explain: ");
            newWord.setWord_explain(input.nextLine());
            dictionary.wordList.add(newWord);
        }
    }

    void showAllWords() {
        System.out.printf("%-8s", "No");
        System.out.printf("%-24s", "|English");
        System.out.printf("%-24s", "|Vietnamese");
        System.out.println();

        for (int i = 0; i < dictionary.wordList.size(); i++) {
            System.out.printf("%-8s", i + 1);
            System.out.printf("%-24s", "|" + dictionary.wordList.get(i).getWord_target());
            System.out.printf("%-24s", "|" + dictionary.wordList.get(i).getWord_explain());
            System.out.println();
        }
    }
}
