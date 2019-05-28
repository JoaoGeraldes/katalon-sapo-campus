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


WebUI.openBrowser('https://campus.dev.sapo.pt/bypass/vsilva')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://campus.dev.sapo.pt/bypass/vsilva"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
WebUI.delay(5)
selenium.open("https://campus.dev.sapo.pt/s/labs/groups")
WebUI.delay(4)
String now = WebUI.executeJavaScript("return Math.round(new Date().getTime() / 1000)", null)
selenium.click("link=criar")
 
// Clica no botão "Confirmar" - para criar grupo
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Restrita'])[1]/following::button[1]")

// Loading
WebUI.delay(4)

//Botão 'Confirmar' 
//String btnConfirmar = driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div[2]/div/div[2]/div/form/button")).getText()

driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[2]/div[2]/div/div[2]/div/form/button"))

//Home button
//driver.findElement(By.xpath("//*[@id='app']/div/div/div[2]/div[1]/header/div/div[2]/div[1]/nav/a[1]"))
 

//WebUI.closeBrowser();

