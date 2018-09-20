package br.edu.cruzeirodosul.pri;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.MenuPrincipal;
import br.edu.cruzeirodosul.util.PortalAlunoLogin;
import br.edu.cruzeirodosul.util.UserLogin;
import br.edu.cruzeirodosul.util.enums.MenuPrincipalEnum;

public class TestPricenarioEditarRecurso {

	UserLogin user = new UserLogin("1103148", "1534914692");
	
	@Test
	public void deveEditarUmRecurso() {
		Selenium selenium = irParaEditarRecursos();
				
		WebElement e = selenium.procurarItem(By.tagName("app-tinymce")).findElement(By.tagName("iframe"));
		selenium.entrarNoIFrame(e);
		
		selenium.procurarItem(By.tagName("body")).clear();
		selenium.esperarPor(1);
		selenium.procurarItem(By.tagName("body")).sendKeys("Selenium Teste Automatizado Edicao");
		selenium.esperarPor(1);	
		selenium.sairDoIFrame();
		selenium.clicarNoPrimeiroLinkComONome("button", "Salvar");
		selenium.esperarPor(1);
		
		assertNotNull(selenium.pegarItemPelaTagENome("h4", "Questão n° 1"));
		
		selenium.clicarNoPrimeiroLinkComONome("button", "visualizar recursos");
		selenium.esperarPor(1);
		
		assertTrue(selenium.pegarItensPelaTagENome("p", "Selenium Teste Automatizado Edicao").size() > 0);
		
		sairDePri(selenium);
	}
		
	private Selenium irParaEditarRecursos() {
		Selenium selenium = PortalAlunoLogin.irParaAreaAluno(user.getRgm(), user.getPassword());
		MenuPrincipal.irParaSubMenu(selenium, MenuPrincipalEnum.VIDA_ACADEMICA, "PRI");
		selenium.esperarPor(1);
		
		selenium.pegarItensPelaTagENome("span", "ver mais detalhes").get(0).click();
		selenium.esperarPor(1);
		selenium.pegarItensPelaTagENome("button", "Visualizar").get(0).click();
		selenium.esperarPor(1);
		selenium.clicarNoPrimeiroLinkComONome("button", "visualizar recursos");
		selenium.esperarPor(1);
		selenium.clicarNoPrimeiroLinkComONome("button", "Editar");
		selenium.esperarPor(1);
		
		return selenium;
	}
		
	private void sairDePri(Selenium selenium) {
		selenium.esperarPor(1);
		selenium.clicarNoPrimeiroLinkComONome("button", "Fechar");
		PortalAlunoLogin.sairPortal(selenium);
	}
	
}
