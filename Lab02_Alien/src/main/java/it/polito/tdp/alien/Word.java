package it.polito.tdp.alien;

import java.util.*;

public class Word {
	
	private String alienWord;
	private List<String> translation;
	
	public Word(String alienWord) {
		this.alienWord = alienWord;
		this.translation=new ArrayList<>();
	}
	
	public String getAlienWord() {
		return alienWord;
	}

	public List<String> getTranslation() {
		return translation;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public void addTranslation(String traduzione) {
		this.translation.add(traduzione);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alienWord == null) ? 0 : alienWord.hashCode());
		result = prime * result + ((translation == null) ? 0 : translation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		if (translation == null) {
			if (other.translation != null)
				return false;
		} else if (!translation.equals(other.translation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String risultato="";
		for(String s: translation) 
			risultato+=s+" ";
		return risultato;
	}

	
	
	
	
	

}

