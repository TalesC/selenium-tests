package br.edu.cruzeirodosul.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.selenium.Selenium;
import br.edu.cruzeirodosul.util.enums.MenuPrincipalEnum;

public class MenuPrincipal {
	
		private MenuPrincipal() {
			super();
		}
				
		public static void irParaMenu(Selenium selenium, MenuPrincipalEnum menu) {
			WebElement element = selenium.pegarItemPeloTipoEClasseCss("div", menu.get());
			element.findElement(By.tagName("a")).click();
			selenium.esperarPor(1);
		}
		
		public static void irParaSubMenu(Selenium selenium, MenuPrincipalEnum menu, String submenu) {
			WebElement element = selenium.pegarItemPeloTipoEClasseCss("div", menu.get());
			element.findElement(By.tagName("a")).click();
			selenium.esperarPor(1);
	
			selenium.pegarItemPelaTagENome("span", submenu).click();
			selenium.esperarPor(1);
		}
			
}
