import java.io.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();
    Scanner input = new Scanner(System.in);

    void insertFromCommandline() {
        System.out.print("Nhập vào số lượng từ vựng: ");
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

    void insertFromFile() {
        try {
            File text = new File("dictionaries.txt");
            FileInputStream fileInputStream = new FileInputStream(text);

            InputStream inputStream = new FileInputStream(text);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String line;
            String tab = "\t";
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(tab);
                Word newWord = new Word();
                newWord.setWord_target(words[0]);
                newWord.setWord_explain(words[1]);
                dictionary.wordList.add(newWord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void dictionaryLookup() {
        System.out.println("Để tìm kiếm từ, vui lòng nhập theo cú pháp:\nlookup<tab><từ muốn tìm>\n");
        String lookupWord = input.nextLine();
        StringTokenizer string = new StringTokenizer(lookupWord, "\t", false);
        String command = null;
        String target = null;
        while (string.hasMoreTokens()) {
            command = string.nextToken();
            target = string.nextToken();
        }
        if (command.equals("lookup")) {
            int index;
            String explain;
            for (int i = 0; i < dictionary.wordList.size(); i++) {
                if (target.equals(dictionary.wordList.get(i).getWord_target())) {
                    index = i + 1;
                    explain = dictionary.wordList.get(i).getWord_explain();
                    System.out.printf("%-8s%-24s%-24s\n", "No", "|English", "|Vietnamese");
                    System.out.printf("%-8s%-24s%-24s\n", index, "|" + target, "|" + explain);
                }
            }
        }
    }

    void dictionaryAdd() {
        String command = null;
        String target = null;
        String explain = null;
        System.out.println("Để thêm từ, vui lòng nhập theo cú pháp:\n<add><tab><từ mới><tab><giải thích>\n");
        Word newWord = new Word();
        String addNewWord = input.nextLine();
        StringTokenizer string = new StringTokenizer(addNewWord, "\t", false);
        while (string.hasMoreTokens()) {
            command = string.nextToken();
            if (!command.equals("add")) {
                return;
            }
            target = string.nextToken();
            explain = string.nextToken();
            newWord.setWord_target(target);
            newWord.setWord_explain(explain);
        }
        Boolean checkSameWord = false;
        for (int i = 0; i < dictionary.wordList.size(); i++) {
            if (newWord.getWord_target().equals(dictionary.wordList.get(i).getWord_target())) {
                checkSameWord = true;
            }
        }
        if (!checkSameWord) {
            dictionary.wordList.add(newWord);
        }
        dictionaryExportToFile();
    }

    void dictionaryEdit() {
        String command = null;
        String target = null;
        String explain = null;
        System.out.println("Để sửa từ, vui lòng nhập theo cú pháp:\n<edit><tab><từ mới><tab><giải thích>\n");
        String editWord = input.nextLine();
        StringTokenizer string = new StringTokenizer(editWord, "\t", false);
        while (string.hasMoreTokens()) {
            command = string.nextToken();
            target = string.nextToken();
            explain = string.nextToken();
            if (!command.equals("edit")) {
                return;
            }
        }
        for (int i = 0; i < dictionary.wordList.size(); i++) {
            if (dictionary.wordList.get(i).getWord_target().equals(target)) {
                dictionary.wordList.get(i).setWord_target(target);
                dictionary.wordList.get(i).setWord_explain(explain);
            }
        }
        dictionaryExportToFile();
    }

    void dictionaryDelete() {
        String command = null;
        String target = null;
        System.out.println("Để xóa từ, vui lòng nhập theo cú pháp:\n<delete><tab><từ mới>\n");
        String deleteWord = input.nextLine();
        StringTokenizer string = new StringTokenizer(deleteWord, "\t", false);
        while (string.hasMoreTokens()) {
            command = string.nextToken();
            target = string.nextToken();
            if (!command.equals("delete")) {
                return;
            }
        }
        for (int i = 0; i < dictionary.wordList.size(); i++) {
            if (dictionary.wordList.get(i).getWord_target().equals(target)) {
                dictionary.wordList.remove(i);
            }
        }
        dictionaryExportToFile();
    }

    public void dictionaryExportToFile() {
        try {
            FileWriter writer = new FileWriter("dictionaries.txt");
            String line;
            String target, explain;
            for (int i = 0; i < dictionary.wordList.size(); i++) {
                target = dictionary.wordList.get(i).getWord_target();
                explain = dictionary.wordList.get(i).getWord_explain();
                line = target + "\t" + explain + "\n";
                writer.write(line);
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}