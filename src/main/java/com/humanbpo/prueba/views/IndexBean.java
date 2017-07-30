package com.humanbpo.prueba.views;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.humanbpo.prueba.dto.MatrixImpl;

@ManagedBean
@ViewScoped
public class IndexBean {
	private String input;
	private String output;

	@PostConstruct
	public void initBean() {
		this.input = null;
		this.output = "";
	}

	public void calcularListener() {
		int linea = 0;
		String[] entrada = this.input.split("\\r\\n");
		System.out.println("entrada de la linea");
		int numeroPruebas = Integer.parseInt(entrada[linea++]);
		
		for (int prueba = 0; prueba < numeroPruebas; prueba++) {
			int tamano = Integer.parseInt(entrada[linea].split(" ")[0]);
			int calculos = Integer.parseInt(entrada[linea++].split(" ")[1]);
			MatrixImpl matrix = new MatrixImpl(tamano);
			for (int q = 0; q < calculos; q++) {
				String tipo = entrada[linea].split(" ")[0];
				if (tipo.equals("UPDATE")) {
					matrix.update(entrada[linea].substring(tipo.length()+1, entrada[linea++].length()));
				}
				if (tipo.equals("QUERY")) {
					matrix.query(entrada[linea].substring(tipo.length()+1, entrada[linea++].length()));
					this.output += matrix.getSuma()+ "\r\n";
				}
			}
			
		}

	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

}
