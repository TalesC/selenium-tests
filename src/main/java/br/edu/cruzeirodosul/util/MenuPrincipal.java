package br.edu.cruzeirodosul.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.enums.MenuPrincipalEnum;

public class MenuPrincipal {
		
		public Selenium irParaMenu(String rgm, String password, MenuPrincipalEnum menu, String submenu) {
			Selenium selenium = PortalAlunoLogin.irParaAreaAluno(rgm, password);
	
			WebElement element = selenium.pegarItemPeloTipoEClasseCss("div", menu.getDescricao());
			element.findElement(By.tagName("a")).click();
			selenium.esperarPor(1);
	
			selenium.pegarItemPelaTagENome("span", submenu).click();
			selenium.esperarPor(1);
	
			return selenium;
		}
}
