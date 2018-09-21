package br.edu.cruzeirodosul.pri;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.model.UserLogin;
import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.MenuPrincipal;
import br.edu.cruzeirodosul.util.PortalAlunoLogin;
import br.edu.cruzeirodosul.util.enums.Cenario;
import br.edu.cruzeirodosul.util.enums.MenuPrincipalEnum;
import br.edu.cruzeirodosul.util.pri.PriUsers;

public class TestPriCenarioCriaRecurso {
	
	UserLogin user = PriUsers.getUserPRIRealizadaComRecurso(Cenario.DEV);
	
	@Test
	public void deveCriarUmRecurso() {
		Selenium selenium = irParaCriarRecursos();
		selenium.esperarPor(1);
		
		WebElement e = selenium.procurarItem(By.tagName("app-tinymce")).findElement(By.tagName("iframe"));
		selenium.entrarNoIFrame(e);
		selenium.procurarItem(By.tagName("body")).sendKeys("Selenium Teste Automatizado Criacao");
		selenium.esperarPor(1);	
		selenium.sairDoIFrame();
		selenium.clicarNoPrimeiroLinkComONome("button", "Salvar");
		selenium.esperarPor(1);
		
		assertNotNull(selenium.pegarItemPelaTagENome("h4", "Questão n° 1"));
		
		selenium.clicarNoPrimeiroLinkComONome("button", "visualizar recursos");
		selenium.esperarPor(1);
		
		assertTrue(selenium.pegarItensPelaTagENome("p", "Selenium Teste Automatizado Criacao").size() > 0);		
		
		sairDePri(selenium);
		
	}

	private Selenium irParaCriarRecursos() {
		Selenium selenium = PortalAlunoLogin.irParaAreaAluno(user.getRgm(), user.getPassword());
		MenuPrincipal.irParaSubMenu(selenium, MenuPrincipalEnum.VIDA_ACADEMICA, "PRI");
		selenium.esperarPor(1);
		
		selenium.pegarItensPelaTagENome("span", "ver mais detalhes").get(0).click();
		selenium.esperarPor(1);
		selenium.pegarItensPelaTagENome("button", "Visualizar").get(0).click();
		selenium.esperarPor(1);
		selenium.clicarNoPrimeiroLinkComONome("button", "criar recurso");
		return selenium;
	}

	private void sairDePri(Selenium selenium) {
		selenium.esperarPor(1);
		selenium.clicarNoPrimeiroLinkComONome("button", "Fechar");
		PortalAlunoLogin.sairPortal(selenium);
	}
	
}
