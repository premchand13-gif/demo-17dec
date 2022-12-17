package com.example.demo1;

import java.util.HashMap;

public class DictionaryUsingHashMap {
    private HashMap<String,String> hashMap;

    public DictionaryUsingHashMap() {
        this.hashMap = new HashMap<>();
        addAllWord();
    }
    public void addWord(String word,String meaning){
        try {
            hashMap.put(word,meaning);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public String getMeaning(String word){
        if(hashMap.containsKey(word)) return hashMap.get(word);
        else{
            return "No word found";
        }
    }
    public void addAllWord(){
        addWord("prem","my name");
        addWord("hi","Greeting");
        addWord("Auction","sfsegjroghrifosfsfgsfng");
        addWord("pre3m","my n2ame");
        addWord("pre4m","my n54ame");
        addWord("pr6em","my na46me");

    }
}
