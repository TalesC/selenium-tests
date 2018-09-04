package br.edu.cruzeirodosul.login;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.PortalAlunoLogin;

public class TestCenarioLogin {
	
	@Test
	public void devefazerLoginEIrParaAreaDoAluno() {
		PortalAlunoLogin portal = new PortalAlunoLogin();
		Selenium sel = portal.irParaAreaAluno("887277", "36219589831");
		
		WebElement menu = sel.pegarItemPeloId("categorias-2");
		assertNotNull(menu);
		
		sel.esperarPor(1);
		WebElement exit = sel.pegarItemPelaTagENome("span", "SAIR");
		exit.click();
		
		sel.esperarPor(1);
		sel.fechar();
	}
	
	@Test
	public void devefazerLoginEIrParaBlackboard() {
		PortalAlunoLogin portal = new PortalAlunoLogin();
		Selenium sel = portal.irParaBlackboard("887277", "36219589831");
	}
	
}
