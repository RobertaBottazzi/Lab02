package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	private List<Word> dictionary;
	
	public AlienDictionary() {
		this.dictionary = new ArrayList<>();
	}

	public void addWord(String alienWord, String translation) {
		for(Word w: dictionary) {
			if(w.getAlienWord().equals(alienWord))
				w.setTranslation(translation);
		}
		dictionary.add(new Word(alienWord,translation));		
	}
	
	public String translateWord(String alienWord) {
		for(Word w: dictionary) {
			if(w.getAlienWord().equals(alienWord))
				return w.getTranslation();
		}
		return null;		
	}
	
	@Override
	public String toString() {
		String risultato="";
		for(Word w: dictionary) {
			risultato+=w.getAlienWord()+" "+w.getTranslation()+"\n";			
		}
		return risultato;		
	}
	

}

