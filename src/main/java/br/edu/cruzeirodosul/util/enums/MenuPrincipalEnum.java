package br.edu.cruzeirodosul.util.enums;

public enum MenuPrincipalEnum {
	VIDA_ACADEMICA("categoria-1"),
	FINANCEIRO("categoria-2"),
	CAA_ONLINE("categoria-3"),
	REMATRICULA("categoria-4"),
	ATIVIDADES_COMPLEMENTARES("categoria-5"),
	CONSULTAS("categoria-6");
	
	private String descricao;
	
	MenuPrincipalEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String get() {
		return this.descricao;
	}
}
