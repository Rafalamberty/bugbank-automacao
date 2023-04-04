package pageObjects;

import dto.DadosContaSegundoUsuarioDto;
import factory.BuscaDadosConta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPage {
    private static final String URL_LOGIN = "https://bugbank.netlify.app/";
    private WebDriver browser;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }

    public void clicarBotaoRegistrar() {
        this.browser.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();
    }

    public void preencherFormularioDeCadastro(String emailUsuario, String nomeUsuario, String senhaUsuario) {
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/div[2]/input")).clear();
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/div[2]/input")).sendKeys(emailUsuario);
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/div[3]/input")).clear();
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/div[3]/input")).sendKeys(nomeUsuario);
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/div[4]/div/input")).clear();
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/div[4]/div/input")).sendKeys(senhaUsuario);
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/div[5]/div/input")).clear();
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/div[5]/div/input")).sendKeys(senhaUsuario);
    }

    public DadosContaSegundoUsuarioDto SalvarDadosDaConta() {
        return BuscaDadosConta.BuscaDadosConta(
        this.browser.findElement(By.xpath("//*[@id='modalText']")).getText(),
        this.browser.findElement(By.xpath("//*[@id='modalText']")).getText()
        );
    }

    public void salvarContaComSaldo() {
        this.browser.findElement(By.id("toggleAddBalance")).click();
    }

    public void clicarBotaoRegistrarUsuario() {
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[2]/form/button")).click();
    }

    public void fecharModalContaRegistradaComSucesso() {
        this.browser.findElement(By.id("btnCloseModal")).click();
    }

    public void clicarFecharModalTrasferenciaRealizada() {
        this.browser.findElement(By.xpath("//*[@id='btnCloseModal']")).click();
    }
    public void clicarSairDaConta() {
        this.browser.findElement(By.id("btnExit")).click();
    }

    public void preencherCampoEmail(String emailPrimeiroUsuario) {
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[1]/input")).sendKeys(emailPrimeiroUsuario);
    }

    public void preencherCampoSenha(String senhaPrimeiroUsuario) {
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[2]/div/input")).sendKeys(senhaPrimeiroUsuario);
    }

    public void clicarBotaoLogin() {
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div[1]/form/div[3]/button[1]")).click();
    }

    public void clicarBotaoTranferencia() {
        this.browser.findElement(By.xpath("//*[@id='btn-TRANSFERÊNCIA']/span")).click();
    }

    public void preencherContaDigitoUsuario(DadosContaSegundoUsuarioDto dadosSalvosSegundoUsuario) {
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[1]/div[1]/input")).sendKeys(dadosSalvosSegundoUsuario.getNumeroDaConta());
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[1]/div[2]/input")).sendKeys(dadosSalvosSegundoUsuario.getDigitoDaConta());
    }

    public void preencherValorDaTransferencia(String valorParaTransferencia) {
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[2]/input")).sendKeys(valorParaTransferencia);
    }

    public void preencherCampoDescricao(String DescricaoTransferencia) {
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/div[3]/input")).sendKeys(DescricaoTransferencia);
    }

    public void clicarBotaoTranferirAgora() {
        this.browser.findElement(By.xpath("//*[@id='__next']/div/div[3]/form/button")).click();
    }

    public String validarValorTransferido() {
        String retornovalidarValorTransferido = this.browser.findElement(By.xpath("//*[@id='modalText']")).getText();
        return retornovalidarValorTransferido;
    }

    public void clicarBotaoExtrato() {
        this.browser.findElement(By.id("btn-EXTRATO")).click();
    }

    public String validarValorRecebido() {
        String retornoValidarValorRecebido = this.browser.findElement(By.xpath("")).getText();
        return retornoValidarValorRecebido;
    }

    public void Fechar() {
        this.browser.quit();
    }
}

