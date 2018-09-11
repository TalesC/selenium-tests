package br.edu.cruzeirodosul.pri;

import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.MenuPrincipal;
import br.edu.cruzeirodosul.util.PortalAlunoLogin;
import br.edu.cruzeirodosul.util.UserLogin;
import br.edu.cruzeirodosul.util.enums.MenuPrincipalEnum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertNotNull;

import java.util.List;

@RunWith(BlockJUnit4ClassRunner.class)
public class TestPriCenarioSimulador {

	UserLogin user = new UserLogin("887277", "36219589831");
	private MenuPrincipal menu = new MenuPrincipal();
	
    @Test
    public void abrirSimulador() {
        Selenium selenium = menu.irParaSubMenu(user.getRgm(), user.getPassword(), MenuPrincipalEnum.VIDA_ACADEMICA, "PRI");
        
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

        WebElement element = selenium
                .pegarItemPeloTipoEClasseCss("div", "col-xs-12 alert text-center alert-success no-margin");

        assertNotNull(element.getText());

        selenium.clicarNoPrimeiroLinkComONome("a", "voltar");
        selenium.clicarNoPrimeiroLinkComONome("button", "fechar");
        selenium.esperarPor(1);
        PortalAlunoLogin.sairPortal(selenium);
    }
}
