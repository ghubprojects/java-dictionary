//package com.example.demo;

public class DictionaryCommandline {
    public void showAllWord(int n, Word[] newWord) {
        System.out.println("No" + "         " + "|English" + "     " + "|Vietnamese") ;
        for (int i = 1; i <= n; i++) {
            System.out.println(i + "     |" + newWord[i - 1].getWord_target() + "     |" + newWord[i - 1].getWord_explain());
        }
    }
}
