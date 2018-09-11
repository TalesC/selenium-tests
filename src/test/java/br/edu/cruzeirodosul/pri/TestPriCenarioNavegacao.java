package br.edu.cruzeirodosul.pri;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.MenuPrincipal;
import br.edu.cruzeirodosul.util.PortalAlunoLogin;
import br.edu.cruzeirodosul.util.UserLogin;
import br.edu.cruzeirodosul.util.enums.MenuPrincipalEnum;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestPriCenarioNavegacao {

	UserLogin user = new UserLogin("1103148", "1534914692");
	
	@Test
	public void navegar() {
		Selenium selenium = PortalAlunoLogin.irParaAreaAluno(user.getRgm(), user.getPassword());
		MenuPrincipal.irParaSubMenu(selenium, MenuPrincipalEnum.VIDA_ACADEMICA, "PRI");

		selenium.esperarPor(2);
		this.clicarEmTodosVerMaisDetalhes(selenium);

		selenium.clicarNoPrimeiroLinkComONome("button", "visualizar");

		this.clicarEmTodosVerMaisDetalhes(selenium);

		selenium.clicarNoPrimeiroLinkComONome("button", "visualizar recursos");
		selenium.clicarNoPrimeiroLinkComONome("a", "voltar");
		selenium.clicarNoPrimeiroLinkComONome("a", "voltar");
		selenium.esperarPor(1);
		selenium.clicarNoPrimeiroLinkComONome("button", "Fechar");
		
		selenium.esperarPor(1);
		PortalAlunoLogin.sairPortal(selenium);
	}

	private void clicarEmTodosVerMaisDetalhes(Selenium selenium) {
		List<WebElement> webElements = selenium.pegarItensPelaTagENome("span", "ver mais detalhes");
		for (WebElement webElement : webElements) {
			webElement.click();
			selenium.esperarPor(1);
		}
	}
}
