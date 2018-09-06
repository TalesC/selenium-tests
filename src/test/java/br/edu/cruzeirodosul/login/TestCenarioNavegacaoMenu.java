package br.edu.cruzeirodosul.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.MenuPrincipal;
import br.edu.cruzeirodosul.util.PortalAlunoLogin;
import br.edu.cruzeirodosul.util.enums.MenuPrincipalEnum;

public class TestCenarioNavegacaoMenu {

	MenuPrincipal menu = new MenuPrincipal();
	
	@Test
	public void navegacaoPeloMenu() {
		Selenium selenium = PortalAlunoLogin.irParaAreaAluno("887277", "36219589831");
	
		List<WebElement> elements = new ArrayList<>();
		for(MenuPrincipalEnum  m : MenuPrincipalEnum.values()) {
			System.out.println(m +" " + m.getDescricao());
			menu.irParaMenu(selenium, m);
			WebElement element = selenium.pegarItemPelaTagENome("h3", getTitulo(m));
			elements.add(element);
		}		
		
		assertTrue(elements.size() > 0);
		assertTrue(elements.size() == 6);
		
		PortalAlunoLogin.sairPortal(selenium);
	}
	
	private String getTitulo(MenuPrincipalEnum m) {
		
		switch (m) {
			case HOME: return "MÍDIAS SOCIAIS";
			case MINHA_CONTA: return "MINHA CONTA";
			case MEUS_CURSOS: return "MEUS CURSOS";
			case VIDA_ACADEMICA: return "VIDA ACADÊMICA";
			case FINANCEIRO: return "FINANCEIRO";
			case CAA_ONLINE: return "CAA ONLINE";
			
			default: return ""	;	
		}
		
	}
	
}
