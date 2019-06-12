import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import org.openqa.selenium.By
import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement


WebUI.openBrowser('https://campus.dev.sapo.pt/bypass/vsilva')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://campus.dev.sapo.pt/bypass/vsilva"
selenium = new WebDriverBackedSelenium(driver, baseUrl)

//////////////////////////
////// CRIAR GRUPO //////
//////////////////////////


def espera(elemento){
	int maxWaitTime = 20;
	assert WebUI.waitForElementClickable(findTestObject(elemento), maxWaitTime, FailureHandling.STOP_ON_FAILURE)
}

// Verifica a existência da imagem de avatar do user - se está na página newsfeed (autenticado)
espera('ObjectElements/userImageAvatar')
//WebUI.waitForElementVisible(findTestObject('ObjectElements/userImageAvatar'), 20)
//assert WebUI.verifyElementVisible(findTestObject('ObjectElements/userImageAvatar')) == true
selenium.open("https://campus.dev.sapo.pt/s/labs/groups")
String now = WebUI.executeJavaScript("return Math.round(new Date().getTime() / 1000)", null)

//Link 'Criar' na página GRUPOS
//selenium.click("link=criar")
//WebUI.verifyElementVisible(findTestObject('ObjectElements/modal_GroupCreate'))
espera('ObjectElements/modal_GroupCreate')
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='criar'])[1]/i[1]")



//Nome do grupo no formulário do modal
selenium.click("xpath=(.//*[@id='app']/div/div/div[2]/div[2]/div[2]/div/div[2]/div/form/div[1]/div/label/input)")

//Insere nome do grupo
selenium.type("name=displayName", "NOME-"+now)

//Seleciona o campo da descrição do grupo
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Descrição'])[1]/textarea[1]")

//Insere a descrição do grupo
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Nome'])[1]/following::textarea[1]", "DESC-"+now)

//Gravar o nome do grupo numa variável
String displayNameInput = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div[2]/div/div[2]/div/form/div[1]/div/label/input")).getAttribute("value")
 
// Clica no botão "Confirmar" - para criar grupo
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Restrita'])[1]/following::button[1]")


//////////////////////////
////// APAGAR GRUPO //////
//////////////////////////

// Espera pelo título do grupo
//WebUI.verifyElementVisible(findTestObject('ObjectElements/h1_groupTitle'))
espera('ObjectElements/h1_groupTitle')

// Espera botão (roda dentada - canto superior direito) settings do grupo
//ebUI.verifyElementVisible(findTestObject('ObjectElements/btn_groupSettings'))
espera('ObjectElements/btn_groupSettings')

// Mostrar título do grupo
String groupTitle = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[1]/header/div/div[3]/div/div[1]/div/h1")).getText()
println(groupTitle);

selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Guardar'])[1]/following::span[5]")
selenium.click("link=Apagar")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Cancelar'])[2]/following::button[1]")

//Procura elemento para procura de grupos
//WebUI.verifyElementVisible(findTestObject('ObjectElements/btn_searchGroup'))
espera('ObjectElements/btn_searchGroup')

// Clicla no searchbar
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Convites'])[1]/following::button[1]")
// Escreve nome do grupo
selenium.type("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Convites'])[1]/following::input[1]", groupTitle)
// Submete com um press ENTER/RETURN
WebElement searchGroup = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[1]/main/div/div[2]/div/div[1]/form/input"));
searchGroup.sendKeys(Keys.RETURN);

// Fecha browser
//WebUI.closeBrowser();

