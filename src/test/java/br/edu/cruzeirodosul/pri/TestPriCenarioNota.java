package br.edu.cruzeirodosul.pri;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
public class TestPriCenarioNota {

	UserLogin user = new UserLogin("887277", "36219589831");
	private MenuPrincipal menu = new MenuPrincipal(); 
	
    @Test
    public void verificarNota() {
        Selenium selenium = menu.irParaSubMenu(user.getRgm(), user.getPassword(), MenuPrincipalEnum.VIDA_ACADEMICA, "PRI");

        selenium.esperarPor(2);
        selenium.pegarItensPelaTagENome("span", "ver mais detalhes").get(0).click();

        selenium.esperarPor(1);
        List<WebElement> elements = selenium.pegarItensPelaTagENome("span", "C");
        
        assertNotNull(elements);
        assertTrue(elements.size() > 0);
        assertTrue(elements.get(0).getText().equalsIgnoreCase("C"));

        selenium.esperarPor(1);
        selenium.clicarNoPrimeiroLinkComONome("button", "Fechar");
        selenium.esperarPor(1);
        PortalAlunoLogin.sairPortal(selenium);
    }
}
