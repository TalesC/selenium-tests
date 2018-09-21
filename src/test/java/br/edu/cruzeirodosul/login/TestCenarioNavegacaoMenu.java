package br.edu.cruzeirodosul.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.model.UserLogin;
import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.MenuPrincipal;
import br.edu.cruzeirodosul.util.PortalAlunoLogin;
import br.edu.cruzeirodosul.util.enums.Cenario;
import br.edu.cruzeirodosul.util.enums.MenuPrincipalEnum;
import br.edu.cruzeirodosul.util.portal.PortalUser;

public class TestCenarioNavegacaoMenu {
	
	UserLogin user = PortalUser.getUserLogin(Cenario.DEV);

	@Test
	public void navegacaoPeloMenu() {
		Selenium selenium = PortalAlunoLogin.irParaAreaAluno(user.getRgm(), user.getPassword());
	
		List<WebElement> elements = new ArrayList<>();
		for(MenuPrincipalEnum  m : MenuPrincipalEnum.values()) {
			MenuPrincipal.irParaMenu(selenium, m);
			WebElement element = selenium.pegarItemPeloTipoEClasseCss("div", "box-"+m.get());
			elements.add(element);
		}		
				
		assertTrue(elements.size() > 0);
		assertTrue(elements.size() == 6);
		
		PortalAlunoLogin.sairPortal(selenium);
	}
	
	
}
