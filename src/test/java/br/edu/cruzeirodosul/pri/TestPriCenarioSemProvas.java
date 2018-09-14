package br.edu.cruzeirodosul.pri;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.MenuPrincipal;
import br.edu.cruzeirodosul.util.PortalAlunoLogin;
import br.edu.cruzeirodosul.util.UserLogin;
import br.edu.cruzeirodosul.util.enums.MenuPrincipalEnum;

public class TestPriCenarioSemProvas {
	
	UserLogin user = new UserLogin("18608388", "4793874193");

	@Test
	public void deveRetornarMensagemDeErroQuandoNaoHouverprovas() {
		Selenium selenium = PortalAlunoLogin.irParaAreaAluno(user.getRgm(), user.getPassword());
		MenuPrincipal.irParaSubMenu(selenium, MenuPrincipalEnum.VIDA_ACADEMICA, "PRI");
		selenium.esperarPor(1);
		
		WebElement e = selenium.procurarItem(By.tagName("app-ucs-alert")).findElement(By.tagName("p"));
		assertTrue(!e.getText().isEmpty());
		
		selenium.esperarPor(1);
		selenium.clicarNoPrimeiroLinkComONome("button", "Fechar");
		PortalAlunoLogin.sairPortal(selenium);		
	}
	
}
