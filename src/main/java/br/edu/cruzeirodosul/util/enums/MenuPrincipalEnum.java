package br.edu.cruzeirodosul.util.enums;

public enum MenuPrincipalEnum {
	
	HOME("categoria-1"),
	MINHA_CONTA("categoria-2"),
	MEUS_CURSOS("categora-3"),
	VIDA_ACADEMICA("categoria-4"),
	FINANCEIRO("categoria-5"),
	CAA_ONLINE("categoria-6");
	
	private String descricao;
	
	MenuPrincipalEnum(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
