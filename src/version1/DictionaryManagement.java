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
        System.out.printf("%-8s%-24s%-24s\n", "No", "|English", "|Vietnamese");
        String target, explain;
        int index;
        for (int i = 0; i < dictionary.wordList.size(); i++) {
            index = i + 1;
            target = dictionary.wordList.get(i).getWord_target();
            explain = dictionary.wordList.get(i).getWord_explain();
            System.out.printf("%-8s%-24s%-24s\n", index, "|" + target, "|" + explain);
        }
    }
}
