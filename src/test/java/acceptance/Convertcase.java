package acceptance;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;

public class Convertcase {
	private WebDriver driver = null;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Given("^Eu abri o site \"(.*?)\"$")
	public void eu_abri_o_site(String site) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.navigate().to(site);
	}

	@When("^Eu digitar \"(.*?)\" no painel \"(.*?)\"$")
	public void eu_digitar_no_painel(String str, String painel) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id(painel)).sendKeys(str);
	}

	@When("^E clicar em \"(.*?)\"$")
	public void e_clicar_em(String botao) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id(recuperarIdDoBotao(botao))).click();
	}
	
	private String recuperarIdDoBotao(String botao){
		switch (botao) {
		case "UPPER CASE":
			return "upper";
		case "lower case":
			return "lower";
		case "Capitalized Case":
			return "capitalized";
		default:
			return "";
		}
	}
	
	@Then("^\"(.*?)\" deve ser convertido para \"(.*?)\"$")
	public void deve_ser_convertido_para(String input, String output) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String was = driver.findElement(By.id("content")).getAttribute("value");
		assertThat(output).isEqualTo(was);
	}

}
