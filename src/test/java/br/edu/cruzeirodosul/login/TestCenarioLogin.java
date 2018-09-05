package br.edu.cruzeirodosul.login;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.PortalAlunoLogin;

public class TestCenarioLogin {
	
	@Test
	public void devefazerLoginEIrParaAreaDoAluno() {
		Selenium selenium = PortalAlunoLogin.irParaAreaAluno("887277", "36219589831");
		
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
