package br.edu.managedbean;

import java.util.List;

public class formularioMB {

	List<Questao> questoes;

}

class Questao{
   	List<Pergunta> perguntas;
}

class Pergunta{
	List<Alternativa> alternativas;
	String escolha;
}

class Alternativa{
	
}