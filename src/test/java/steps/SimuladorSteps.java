package steps;

import Setup.TestRule;
import actions.SimuladorAction;
import cucumber.api.java.pt.*;
//import cucumber.api.java.pt.Então;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SimuladorSteps {

    public WebDriver driver = TestRule.getDriver();
    public SimuladorAction simuladorAction = new SimuladorAction();
    private String campo;

//    @Dado("que estou na tela de simulaçãAo")
//    public void que_possuo_token_de_service() {
//        driver.navigate().to("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
//    }

    @Dado("^que estou na tela do simulador$")
    public void queEstouNaTelaDeSimulacao() {
        driver.navigate().to("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
    }

    @Dado("que estou na tela de simulaçãoo")
    public void que_estou_na_tela_de_simulaooo() {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
        driver.navigate().to("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
    }

    @Quando("^faço uma simulação aplicando R\\$([^\"]*) e poupando R\\$([^\"]*) por ([^\"]*) meses$")
    public void facoUmaSimulacao(String valor_aplicacao, String valor_poupar, String meses) {

        if (valor_aplicacao.equalsIgnoreCase("{vazio}")) valor_aplicacao = "";
        if (valor_poupar.equalsIgnoreCase("{vazio}")) valor_aplicacao = "";
        if (meses.equalsIgnoreCase("{vazio}")) valor_aplicacao = "";

        simuladorAction.realizarSimulacao(valor_aplicacao, valor_poupar, meses);
    }

    @Então("^é apresentado o resultado da simulação$")
    public void saoApresentadasAsInformacoes() {
        assertTrue(simuladorAction.validarApresentacaoTabelaResultados());
    }

    @Então("^sao apresentadas alertas de erro indicando que o valor deve ser maior que R\\$20,00$")
    public void saoApresentadasAlertasDeErroIndicandoQueOValorDeveSerMaiorQueRS() {
    }

    @Então("^é apresentado erro no campo \"([^\"]*)\"$")
    public void eApresentadoErroNoCampo(String campo){
        this.campo = campo;
        assertTrue(simuladorAction.validarApresentacaoErro(campo));
    }

    @Então("^o texto do erro apresentado é \"([^\"]*)\"$")
    public void oTextoDoErroApresentadoE(String mensagem) {
        assertTrue(simuladorAction.validarTextoErro(campo, mensagem));
    }

    @Então("^simulação não é realizada$")
    public void simulacaoNaoERealizada() {
        assertFalse(simuladorAction.validarApresentacaoTabelaResultados());
    }
}
