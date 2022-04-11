package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;
	
	public void setModel(Model model) {
		this.model = model;
		//model.getTutteLeParole();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextField txtAnagramma;
    
    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
        model.anagrammi(txtAnagramma.getText());
        for(String s:model.getSoluzioneCorretta()) {
        	txtCorretti.setText(txtCorretti.getText()+s+"\n");
        }
        for(String s:model.getSoluzioneErrata()) {
        	txtErrati.setText(txtErrati.getText()+s+"\n");
        }
       // txtErrati.setText(""+model.getSoluzioneErrata().size());
       // con questo comando commentato ho verificato che la complessita
       // è di tipo O(n!), pertanto non posso anagrammare parole piu 
       //lunghe di 6 lettere. per farlo, dal momento che è possibile 
       // dovrei ottimizzare il problema fino a farlo diventare 
       // di complessità O(2^n).
    }

    @FXML
    void doReset(ActionEvent event) {
       txtErrati.clear();
       txtCorretti.clear();
       txtAnagramma.clear();
    }

    @FXML
    void initialize() {
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagramma != null : "fx:id=\"txtAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
