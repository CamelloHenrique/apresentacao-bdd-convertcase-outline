package acceptance;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConvertCase {
	private WebDriver driver = null;

	@Before
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
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

	private String recuperarIdDoBotao(String botao){
		return switch (botao) {
			case "UPPER CASE" -> "upper";
			case "lower case" -> "lower";
			case "Capitalized Case" -> "capitalized";
			default -> "";
		};
	}

	@When("^E clicar em \"(.*?)\"$")
	public void e_clicar_em(String botao) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id(recuperarIdDoBotao(botao))).click();
	}

	@Then("^\"(.*?)\" deve ser convertido para \"(.*?)\"$")
	public void deve_ser_convertido_para(String input, String output) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String actual = driver.findElement(By.id("content")).getAttribute("value");
		assertThat(output).isEqualTo(actual);
	}
}
