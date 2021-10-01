package v1ngocbranch;

public class DictionaryCommandLine {
    void dictionaryBasic() {
        DictionaryManagement dictManagement = new DictionaryManagement();
        dictManagement.insertFromCommandline();
        dictManagement.showAllWords();
    }

    public static void main(String[] args) {
        DictionaryCommandLine dictionaryCommandLine = new DictionaryCommandLine();
        dictionaryCommandLine.dictionaryBasic();
    }
}
