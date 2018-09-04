package br.edu.cruzeirodosul.util;

import org.openqa.selenium.WebElement;

import br.edu.cruzeirodosul.selenium.Selenium;

public class PortalAlunoLogin {
	
	public Selenium irParaAreaAluno(String rgm, String password) {
		Selenium selenium = login(rgm, password);	
		selenium.pegarItemPelaTagENome("span", "ÁREA DO ALUNO").click();
		return selenium;
	}
	
	public Selenium irParaBlackboard(String rgm, String password) {
		Selenium selenium = login(rgm, password);	
		selenium.pegarItemPelaTagENome("a", "BLACKBOARD").click();
		return selenium;
	}
	
	private Selenium login(String rgm, String password) {
		Selenium selenium = Selenium.abrir("http://localhost:4200");
		selenium.maximizar();
		
		WebElement field = selenium.pegarItemPelaTagEPlaceholder("input", "Seu RGM ou CPF");
		field.sendKeys(rgm);
		
		selenium.removerFocus();
		
		field = selenium.pegarItemPelaTagEPlaceholder("input", "Senha");
		field.sendKeys(password);
		
		selenium.removerFocus();
		selenium.esperarPor(1);
		
		return selenium;
	}
}
