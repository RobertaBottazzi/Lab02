package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private AlienDictionary model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnTranslate;
    
    @FXML
    private Button btnReset;
    
    @FXML
    private TextField txtAlien;

    @FXML
    private TextArea txtTranslation;

    @FXML
    void doTranslate(ActionEvent event) {
    	String word=txtAlien.getText();
    	//controllo che le parole inserite siano valide (quindi tutte composte da caratteri alfabetici)
    	String wordSenzaSpazi= word.replaceFirst(" ","");
    	char[] wordInChar= wordSenzaSpazi.toCharArray();
    	boolean wordOk=true;
    	boolean question=false;
    	for(char c: wordInChar) {
    		if(c==' ') {
    			txtTranslation.appendText("You can only add one translation at a time!"+"\n");
    			return;
    		}
    		if(!Character.isAlphabetic(c))
    			wordOk=false;
    		if(c=='?')
    			question=true;
    	}
    	if(wordOk) {
    		String wordLower=word.toLowerCase();
    		int i= wordLower.indexOf(" ");
    		if(i!=-1) {
    			model.addWord(wordLower.substring(0,i), wordLower.substring(i+1,wordLower.length()));
        		txtTranslation.appendText("New Alien word added: "+wordLower+"\n"+"Dictionary: "+model.toString()); 
    		}
        	else {
        		txtTranslation.appendText("Translation: "+model.translateWord(wordLower)+"\n");        		
        	}
    	}
    	//controllo se nella parola inserita c'è un ?
    	if(question) {
    		String wordLower=word.toLowerCase();
    		int i=0;
    		char[] wordLowerInChar=wordLower.toCharArray();
    		for(char c: wordLowerInChar) {
    			if(c=='?')
    				i+=1;
    		}
    		if(i>1) {
    			txtTranslation.appendText("Action not allowed!"+"\n");
    			return;
    		}
    		char c='a';
    		String wordQuestion = "";
    		boolean trovata=false;
    		while(c<='z'){
    			wordQuestion=wordLower.replace('?', c++);
    			if(model.translateWord(wordQuestion)!="") 
    				trovata=true;
    			if(trovata)
    				break;
    		}
    		txtTranslation.appendText("Translation: "+model.translateWord(wordQuestion).toString()+"\n");
    	}
    }    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtTranslation.clear();
    	model.getDictionaryMap().clear();
    }
    
    public void setModel(AlienDictionary model) {
    	this.model=model;
    }
    
    @FXML
    void initialize() {
    	assert txtAlien != null : "fx:id=\"txtAlien\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTranslation != null : "fx:id=\"txtTranslation\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}