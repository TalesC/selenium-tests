package br.edu.cruzeirodosul.pri;

import br.edu.cruzeirodosul.model.UserLogin;
import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.MenuPrincipal;
import br.edu.cruzeirodosul.util.PortalAlunoLogin;
import br.edu.cruzeirodosul.util.enums.Cenario;
import br.edu.cruzeirodosul.util.enums.MenuPrincipalEnum;
import br.edu.cruzeirodosul.util.pri.PriUsers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;

import java.util.List;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestPriCenarioSimulador {

	UserLogin user = PriUsers.getUserCenarioProvaNaoRealizada(Cenario.DEV);
	
    @Test
    public void abrirSimulador() {
    	Selenium selenium = irParaMenuPRI();
        
        selenium.esperarPor(2);
        selenium.clicarNoPrimeiroLinkComONome("button", "Simular nota");

        List<WebElement> inputs = selenium.pegarInputsNumericos();

        Assert.assertFalse("Não abriu o simulador", inputs.isEmpty());

        for (WebElement input : inputs) {
            input.click();
            input.sendKeys("0.9");
        }

        selenium.removerFocus();
        selenium.esperarPor(1);

        WebElement element = selenium.pegarItemPeloTipoEClasseCss("div", "col-xs-12 alert text-center alert-success no-margin");

        assertNotNull(element.getText());

        sairPRI(selenium);
    }

	private void sairPRI(Selenium selenium) {
		selenium.clicarNoPrimeiroLinkComONome("a", "voltar");
        selenium.clicarNoPrimeiroLinkComONome("button", "fechar");
        selenium.esperarPor(1);
        PortalAlunoLogin.sairPortal(selenium);
	}

	private Selenium irParaMenuPRI() {
		Selenium selenium = PortalAlunoLogin.irParaAreaAluno(user.getRgm(), user.getPassword());
    	selenium.esperarPor(1);
    	selenium.pegarItensPelaTagENome("div", "acesse").get(1).click();
    	selenium.esperarPor(1);
        MenuPrincipal.irParaSubMenu(selenium, MenuPrincipalEnum.VIDA_ACADEMICA, "PRI");
		return selenium;
	}
}
