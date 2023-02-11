package com.example.demo.controller;


import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;


public class TesteController {

	public static void main(String[] args) {
		
		//Fazer uma requisição
		//Para acessar o webservice, um CEP no formato de (8) digitos deve ser fornecido, por exemplo: "01001000".
		//Após o CEP, deve ser fornecido o tipo de retorno desejado, que deve ser "json", "xml", "piped" ou "querty".
		//Exemplo de pesquisa por CEP:
		//https://viacep.com.br/ws/21931190
		
		
		try {
			//criando um objeto URL
			URL url = new URL ("https://viacep.com.br/ws/21931190/json/");
			//Criando um objeto de conexão URL via HTTP -abrindo uma conexão
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			//Solicitando uma conexão através do verbo GET
			connection.setRequestMethod("GET");
			//Conectando
			connection.disconnect();
			
			//A conexão foi estabelecida?
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) { //A conexão não foi estabelecida
				throw new RuntimeException("Ocorreu um erro: " + responseCode);			
		} else {    //a conexão foi estabelecida
		//Abrindo um Scanner para ler um fluxo e dados
		StringBuilder informationString = new StringBuilder();
		Scanner scanner = new Scanner(url.openStream());
		
		//Lendo as linhas recebidas da requisição
		while (scanner.hasNext()) {
			informationString.append(scanner.nextLine());
		}
		
		//Fechando o objeto Scanner
		scanner.close();
		
		//Apresentando as informações obtidas da requisição no console
		System.out.println(informationString);
		}
	} catch(Exception e) {
	e.printStackTrace();	
	}
}
}
