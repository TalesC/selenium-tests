package br.edu.cruzeirodosul.util.pri;

import br.edu.cruzeirodosul.model.UserLogin;
import br.edu.cruzeirodosul.util.enums.Cenario;

public class PriUsers {
	
	private PriUsers() {
		super();
	}
	
	public static UserLogin getUserCenarioProvaRealizadaComRecurso(Cenario cenario) {
		switch (cenario) {
			case DEV: return new UserLogin("1103148", "1534914692");
			case HOMOLOG: return null;
			case PROD: return null;
			default: return null;
		}
	}
	
	public static UserLogin getUserCenarioProvaRealizadaSemRecurso(Cenario cenario) {
		switch (cenario) {
			case DEV: return new UserLogin("1202472", "4799137140");
			case HOMOLOG: return null;
			case PROD: return null;
			default: return null;
		}
	}
	
	public static UserLogin getUserCenarioProvaNaoRealizada(Cenario cenario) {
		switch (cenario) {
			case DEV: return new UserLogin("1106295", "3726723102");
			case HOMOLOG: return null;
			case PROD: return null;
			default: return null;
		}
	}
	
	public static UserLogin getUserCenarioSemProva(Cenario cenario) {
		switch (cenario) {
			case DEV: return new UserLogin("18608388", "4793874193");
			case HOMOLOG: return null;
			case PROD: return null;
			default: return null;
		}
	}
	
}