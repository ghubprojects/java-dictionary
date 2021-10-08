import java.io.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
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

    void insertFromFile() throws IOException {
        File text = new File("C:/Users/phamb/source/repos/Ver2_dictionary_git/java-dictionary/dictionaries.txt");
        FileInputStream fileInputStream = new FileInputStream(text);

        InputStream inputStream = new FileInputStream(text);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line ;
        String tab = "\t";
        while((line = reader.readLine()) != null) {
            String[] words = line.split(tab);
            Word newWord = new Word();
            newWord.setWord_target(words[0]);
            newWord.setWord_explain(words[1]);
            dictionary.wordList.add(newWord);
        }

    }

    void dictionaryLookup() {
        System.out.println("Để tìm kiếm từ, vui lòng nhập theo cú pháp:\nlookup<dấu cách><từ muốn tìm>\n");
        Scanner in = new Scanner(System.in);
        String commandline = in.nextLine();
        String[] words = commandline.split(" ");
        if(words[0].equals("lookup")) {
            int index;
            String target, explain;
            for (int i = 0; i < dictionary.wordList.size(); i++) {
                index = i + 1;
                target = dictionary.wordList.get(i).getWord_target();
                explain = dictionary.wordList.get(i).getWord_explain();
                if(target.equals(words[1])) {
                    System.out.printf("%-8s%-24s%-24s\n", "No", "|English", "|Vietnamese");
                    System.out.printf("%-8s%-24s%-24s\n", index, "|" + target, "|" + explain);
                }
            }
        }
    }

    void dictionaryAdd() {
        System.out.println("Để thêm từ, vui lòng nhập theo cú pháp:\n<từ mới><enter><giải thích>\n");
        Word newWord = new Word();
        Scanner input = new Scanner(System.in);
        newWord.setWord_target(input.nextLine());
        newWord.setWord_explain(input.nextLine());
        Boolean checkSameWord = false;
        for(int i = 0; i < dictionary.wordList.size(); i++) {
            if(newWord.getWord_target().equals(dictionary.wordList.get(i).getWord_target())) {
                checkSameWord = true;
            }
        }
        if(!checkSameWord) {
            dictionary.wordList.add(newWord);
        }
    }

    void dictionaryEdit() {

    }

    void dictionaryDelete() {

    }

}