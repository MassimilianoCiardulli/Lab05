package it.polito.tdp.anagrammi.controller;

import java.util.ArrayList;
import java.util.List;

public class AnagrammiModel {
	
		//LIVELLO: numero della lettera nell'anagramma
		//SOLUZIONE PARZIALE: n*(n-1)!
		//SOLUZIONE PARZIALE COMPLETA: se n=0;
		//SOLUZIONE VALIDA: controllare nel db del dizionario italiano se la parola esiste o no
		//STRUTTURA DATI SOLUZIONE: stringa
		//STRUTTURA DATI RICORSIONE: arraylist di stringhe
	
	char[] arrayChar ;
	List<String> anagrammi;
	
	
	public AnagrammiModel(String parola) {
		
		anagrammi = new ArrayList<String>();
		
		//prendo la parola e la modifico in un array di char
		arrayChar = parola.toCharArray();
		
		//aggiungo la parola alla lista degli anagrammi
		anagrammi.add(parola);
		
		int livello = 1;
		
		for(int i = 0; i < fatt(parola.length()); i++) {
			generaAnagramma(arrayChar, livello, 0);
		}
			
	}
	

	private void generaAnagramma(char[] arrayChar, int livello, int letteraDaCuiPartire) { //questo è il mio metodo ricorsivo
		
		if(livello == arrayChar.length+1) {
			
			System.out.println(anagrammi);
			return ;
			
		}
		
		for( int i = letteraDaCuiPartire; i < livello; i++ ) {
			if(livello < arrayChar.length-1)
				arrayChar = cambiaOrdine(i, livello+1);
			
			if(isNew(arrayChar)) {
				String anagramma = "";
				for(int j = 0; j < arrayChar.length; j++)
					anagramma += arrayChar[j];
				anagrammi.add(anagramma);
			}
			
			generaAnagramma(arrayChar, livello+1, letteraDaCuiPartire+1);
			
		}
		
		
	}

	private boolean isNew(char[] arrayChar) {
		
		String anagramma = "";
		for(int j = 0; j < arrayChar.length; j++)
			anagramma += arrayChar[j];
		
		if(!anagrammi.contains(anagramma))
			return true;
		
		return false;
	}

	private char[] cambiaOrdine(int c, int d) {
		
		char temp = arrayChar[c];
		arrayChar[c] = arrayChar[d];
		arrayChar[d] = temp;
		
		return arrayChar;
		
	}
	
	private int fatt(int length) {
		int fatt = 1;
		
		for(int i = 1; i <= length; i++)
			fatt = fatt*i;
		
		return fatt;
	}

}
