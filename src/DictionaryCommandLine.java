import java.util.Scanner;

public class DictionaryCommandLine {
    Scanner input = new Scanner(System.in);

    void dictionarySearcher() {
        DictionaryManagement dictManagement = new DictionaryManagement();
        dictManagement.insertFromFile();
        dictManagement.showAllWords();
        System.out.println("Tra cứu: ");
        String wordSearching = input.nextLine();
        for (int i = 0; i < dictManagement.dictionary.wordList.size(); i++) {
            String target, explain;
            int index;
            index = i + 1;
            target = dictManagement.dictionary.wordList.get(i).getWord_target();
            explain = dictManagement.dictionary.wordList.get(i).getWord_explain();
            if (target.startsWith(wordSearching)) {
                System.out.printf("%-8s%-24s%-24s\n", index, "|" + target, "|" + explain);
            }
        }

    }

    void dictionaryBasic() {
        DictionaryManagement dictManagement = new DictionaryManagement();
        //dictManagement.insertFromCommandline();
        dictManagement.insertFromFile();
        dictManagement.showAllWords();
        /*dictManagement.dictionaryAdd();
        dictManagement.showAllWords();*/
        /*dictManagement.dictionaryEdit();
        dictManagement.showAllWords();*/
        dictManagement.dictionaryDelete();
        dictManagement.showAllWords();
    }

    void dictionaryAdvanced() {
        DictionaryManagement dictManagement = new DictionaryManagement();
        dictManagement.insertFromFile();
        dictManagement.showAllWords();
        dictManagement.dictionaryLookup();
    }


    public static void main(String[] args) {
        DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();
        Boolean loop = true;
        while (loop) {
            dictionaryCommandLine.dictionarySearcher();
            System.out.println("Do you want to continue? Press 'y' to continue or any keyword else to finish ");
            Scanner input = new Scanner(System.in);
            if (input.nextLine().equals("y")) {
                loop = true;
            } else {
                loop = false;
            }
        }
    }
}
