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
			menu.irParaMenu(selenium, m);
			WebElement element = selenium.pegarItemPeloTipoEClasseCss("div", "box-"+m.getDescricao());
			elements.add(element);
		}		
				
		assertTrue(elements.size() > 0);
		assertTrue(elements.size() == 6);
		
		PortalAlunoLogin.sairPortal(selenium);
	}
	
	
}
