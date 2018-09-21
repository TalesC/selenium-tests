package br.edu.cruzeirodosul.util.portal;

import br.edu.cruzeirodosul.model.UserLogin;
import br.edu.cruzeirodosul.util.enums.Cenario;

public class PortalUser {

	private PortalUser() {
		super();
	}
	
	public static UserLogin getUserLogin(Cenario cenario) {
		switch (cenario) {
			case DEV: return new UserLogin("887277", "36219589831");
			case HOMOLOG: return null;
			case PROD: return null;
			default: return null;
		}
	}
	
}
