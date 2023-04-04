package Test;

import dto.DadosContaSegundoUsuarioDto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pageObjects.LoginPage;
import static constantes.DadosUsuarios.*;


public class loginTest {
    private LoginPage paginaDeLogin;


    @Before
    public void before() {
        this.paginaDeLogin = new LoginPage();
    }

    @Test
    public void validarTranferenciaUsuarios() throws InterruptedException {
        paginaDeLogin.clicarBotaoRegistrar();
        paginaDeLogin.preencherFormularioDeCadastro(emailPrimeiroUsuario, nomePrimeiroUsuario, senhaPrimeiroUsuario);
        paginaDeLogin.salvarContaComSaldo();
        paginaDeLogin.clicarBotaoRegistrarUsuario();
        Thread.sleep(2000);
        paginaDeLogin.fecharModalContaRegistradaComSucesso();
        paginaDeLogin.clicarBotaoRegistrar();
        paginaDeLogin.preencherFormularioDeCadastro(emailSegundoUsuario, nomeSegundoUsuario, senhaSegundoUsuario);
        paginaDeLogin.salvarContaComSaldo();
        paginaDeLogin.clicarBotaoRegistrarUsuario();
        DadosContaSegundoUsuarioDto dadosSalvosSegundoUsuario = paginaDeLogin.SalvarDadosDaConta();
        paginaDeLogin.fecharModalContaRegistradaComSucesso();
        paginaDeLogin.preencherCampoEmail(emailPrimeiroUsuario);
        paginaDeLogin.preencherCampoSenha(senhaPrimeiroUsuario);
        paginaDeLogin.clicarBotaoLogin();
        Thread.sleep(2000);
        paginaDeLogin.clicarBotaoTranferencia();
        Thread.sleep(2000);
        paginaDeLogin.preencherContaDigitoUsuario(dadosSalvosSegundoUsuario);
        paginaDeLogin.preencherValorDaTransferencia(valorParaTransferencia);
        paginaDeLogin.preencherCampoDescricao(descricaoTransferencia);
        paginaDeLogin.clicarBotaoTranferirAgora();
        Assert.assertEquals(MensagemTransferenciaRealizada, paginaDeLogin.validarValorTransferido());
        paginaDeLogin.clicarFecharModalTrasferenciaRealizada();
        paginaDeLogin.clicarSairDaConta();
        paginaDeLogin.preencherCampoEmail(emailSegundoUsuario);
        paginaDeLogin.preencherCampoSenha(senhaSegundoUsuario);
        paginaDeLogin.clicarBotaoLogin();
        paginaDeLogin.clicarBotaoExtrato();
        Assert.assertEquals(valorParaTransferencia, paginaDeLogin.validarValorRecebido());
    }

    @After
    public void after() {
        this.paginaDeLogin.Fechar();
    }

}
