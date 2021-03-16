package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	private Map<String, Word> dictionaryMap;
	
	public AlienDictionary() {
		this.dictionaryMap= new HashMap<>();
	}

	public void addWord(String alienWord, String translation) {
		if(dictionaryMap.containsKey(alienWord)) {
			dictionaryMap.get(alienWord).addTranslation(translation);
		}
		else {
			dictionaryMap.put(alienWord, new Word(alienWord));
			dictionaryMap.get(alienWord).addTranslation(translation);
		}		
	}
	
	public String translateWord(String alienWord) {
		String risultato="";
		if(dictionaryMap.containsKey(alienWord)) {
			for(String s: dictionaryMap.get(alienWord).getTranslation()) {
				risultato+=s+"\n";
			}
		}
		return risultato;		
	}
	
	@Override
	public String toString() {
		String risultato="";
		for(Word w:dictionaryMap.values()) {
			risultato+=w.getAlienWord()+" "+w.toString()+"\n";
		}
		return risultato;
	}
	

}

