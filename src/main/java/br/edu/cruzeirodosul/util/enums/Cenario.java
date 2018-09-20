package br.edu.cruzeirodosul.util.enums;

public enum Cenario {
	DEV("dev"),
	HOMOLOG("homolog"),
	PROD("prog");
	
	private String descricao;
	
	Cenario(String descricao) {
		this.descricao = descricao;
	}
	
	public String get() {
		return this.descricao;
	}
}
