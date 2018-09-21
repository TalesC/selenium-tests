package br.edu.cruzeirodosul.login;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.model.UserLogin;
import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.PortalAlunoLogin;
import br.edu.cruzeirodosul.util.enums.Cenario;
import br.edu.cruzeirodosul.util.portal.PortalUser;

public class TestCenarioLogin {
	
	UserLogin user = PortalUser.getUserLogin(Cenario.DEV);
	
	@Test
	public void devefazerLoginEIrParaAreaDoAluno() {
		Selenium selenium = PortalAlunoLogin.irParaAreaAluno(user.getRgm(), user.getPassword());
		
		WebElement menu = selenium.pegarItemPeloId("categorias-2");
		assertNotNull(menu);
		
		selenium.esperarPor(1);
		PortalAlunoLogin.sairPortal(selenium);
	}
	
	/*@Test
	public void devefazerLoginEIrParaBlackboard() {
		PortalAlunoLogin portal = new PortalAlunoLogin();
		Selenium sel = portal.irParaBlackboard("887277", "36219589831");
	}*/
	
}
