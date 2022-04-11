package it.polito.tdp.anagrammi.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {
	private DizionarioDAO dizionarioDao;
	private  List<String> soluzioneCorretta;
	private  List<String> soluzioneErrata;
	

public Model() {
	dizionarioDao = new DizionarioDAO();
	soluzioneCorretta = new LinkedList();
	soluzioneErrata = new LinkedList();
}
public List<String> getTutteLeParole(){
	return dizionarioDao.getTutteLeParole();
}

public void anagrammi(String rimanente){
	soluzioneCorretta.clear();
	soluzioneErrata.clear();
    anagrammi_ricorsiva("",0,rimanente);
    
}
private void anagrammi_ricorsiva(String parziale, int livello, String rimanente) {
	if(rimanente.length()==0) {
	if (dizionarioDao.isCorretta(parziale)==true) {
		soluzioneCorretta.add(parziale);
	} else {
		soluzioneErrata.add(parziale);
	}
	} else {
		for(int pos=0; pos<rimanente.length();pos++) {
			anagrammi_ricorsiva(parziale+rimanente.charAt(pos),livello+1,rimanente.substring(0,pos)+rimanente.substring(pos+1));
		}
	}
}


public List<String> getSoluzioneCorretta() {
	return soluzioneCorretta;
}
public List<String> getSoluzioneErrata() {
	return soluzioneErrata;
}



}
