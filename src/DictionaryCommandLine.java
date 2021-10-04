import java.io.IOException;

public class DictionaryCommandLine {
    void dictionaryBasic() throws IOException {
        DictionaryManagement dictManagement = new DictionaryManagement();
        //dictManagement.insertFromCommandline();
        dictManagement.insertFromFile();

        dictManagement.showAllWords();
    }

    void dictionaryAdvanced() throws IOException {
        DictionaryManagement dictManagement = new DictionaryManagement();
        dictManagement.insertFromFile();
        dictManagement.showAllWords();
        dictManagement.dictionaryLookup();
    }

    void dictionarySearcher() {

    }

    public static void main(String[] args) throws IOException {
        DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();
        //File text = new File("C:/Users/phamb/source/repos/java_dictionary2/Dictionary ver2/dictionaries.txt");
        //dictionaryCommandLine.dictionaryBasic();
        dictionaryCommandLine.dictionaryAdvanced();
    }
}
