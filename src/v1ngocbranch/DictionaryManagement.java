package v1ngocbranch;

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
            String temp = input.nextLine();
            System.out.print("Word_target: ");
            newWord.setWord_target(input.nextLine());
            System.out.print("Word_explain: ");
            if (i == numOfWords - 1) {
                newWord.setWord_explain(input.nextLine());
            }
            newWord.setWord_explain(input.next());
            dictionary.wordList.add(newWord);
        }
    }

    void showAllWords() {
        System.out.printf("%-15s", "No");
        System.out.printf("%-30s", "|English");
        System.out.printf("%-30s", "|Vietnamese");
        System.out.println();

        for (int i = 0; i < dictionary.wordList.size(); i++) {
            System.out.printf("%-15s", i + 1);
            System.out.printf("%-30s", dictionary.wordList.get(i).getWord_target());
            System.out.printf("%-30s", dictionary.wordList.get(i).getWord_target());
            System.out.println();
        }
    }
}
