package br.edu.cruzeirodosul.pri;

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

public class TestPriCenarioValidarCriarRecurso {
	
	UserLogin user = PriUsers.getUserCenarioProvaRealizadaSemRecurso(Cenario.DEV);
	
	@Test
	public void deveValidarCriarRecursoForaDoPerirodo() {
		Selenium selenium = irParaMenuPRI(user, 0);
		selenium.esperarPor(1);
		
		selenium.pegarItensPelaTagENome("span", "ver mais detalhes").get(0).click();
		selenium.esperarPor(1);
		selenium.pegarItensPelaTagENome("button", "Visualizar").get(1).click();
		selenium.esperarPor(1);
		selenium.clicarNoPrimeiroLinkComONome("button", "criar recurso");
		selenium.esperarPor(1);
		
		WebElement e = selenium.procurarItem(By.tagName("app-ucs-alert")).findElement(By.tagName("p"));
		assertTrue(!e.getText().isEmpty());
		
		sairDePRI(selenium);
				
	}

	private void sairDePRI(Selenium selenium) {
		selenium.esperarPor(1);
		selenium.clicarNoPrimeiroLinkComONome("button", "Fechar");
		PortalAlunoLogin.sairPortal(selenium);
	}
	
	private Selenium irParaMenuPRI(UserLogin user, Integer posicaoCurso) {
		Selenium selenium = PortalAlunoLogin.irParaAreaAluno(user.getRgm(), user.getPassword());
    	selenium.esperarPor(1);
    	selenium.pegarItensPelaTagENome("div", "acesse").get(posicaoCurso).click();
    	selenium.esperarPor(1);
        MenuPrincipal.irParaSubMenu(selenium, MenuPrincipalEnum.VIDA_ACADEMICA, "PRI");
		return selenium;
	}
		

}
