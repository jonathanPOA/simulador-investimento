package steps;

import Setup.TestRule;
import Utils.PropertyReader;
import actions.SimuladorAction;
//import cucumber.api.java.pt.*;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.hamcrest.Matchers.equalTo;

public class SimuladorSteps {

    private WebDriver driver;
    private SimuladorAction simuladorAction = new SimuladorAction();
    private String elemento;
    private Response response;
    private ValidatableResponse responseValidacao;
    private RequestSpecification request;
    private String BASEURL = new PropertyReader().getProperty("url_api");
    private String ENDPOINT_SIMULADOR_INVESTIMENTOS = "/api/v1/simulador";


    @Dado("^que estou na tela do simulador$")
    public void queEstouNaTelaDeSimulacao() {
        driver = TestRule.getDriver();
        driver.navigate().to(TestRule.getUrlSimulador());
    }


    @Quando("^faço uma simulação aplicando R\\$([^\"]*) e poupando R\\$([^\"]*) por ([^\"]*) \"([^\"]*)\"$")
    public void facoUmaSimulacao(String valor_aplicacao, String valor_poupar, String tempo, String unidade) {

        if (valor_aplicacao.equalsIgnoreCase("{vazio}")) valor_aplicacao = "";
        if (valor_poupar.equalsIgnoreCase("{vazio}")) valor_aplicacao = "";
        if (tempo.equalsIgnoreCase("{vazio}")) valor_aplicacao = "";

        simuladorAction.realizarSimulacao(valor_aplicacao, valor_poupar, tempo, unidade);
    }

    @Então("^são apresentada outras quatro opções de investimentos$")
    public void saoApresentadasAsInformacoes() {
        assertTrue(simuladorAction.validarApresentacaoTabelaResultados());
    }

    @Então("^é apresentado o valor \"([^\"]*)\" como valor guardado$")
    public void eApresentadoValorGuardado(String valor) {
        assertTrue(simuladorAction.validarApresentacaoValorGuardado(valor));
    }

    @Então("^é apresentado erro no campo \"([^\"]*)\"$")
    public void eApresentadoErroNoCampo(String campo){
        this.elemento = campo;
        assertTrue(simuladorAction.validarApresentacaoErro(campo));
    }

    @Então("^o texto do erro apresentado é \"([^\"]*)\"$")
    public void oTextoDoErroApresentadoE(String mensagem) {
        assertTrue(simuladorAction.validarTextoErro(elemento, mensagem));
    }

    @Então("^simulação não é realizada$")
    public void simulacaoNaoERealizada() {
        assertFalse(simuladorAction.validarApresentacaoTabelaResultados());
    }

    @Quando("^consulto o serviço de simulação de investimentos$")
    public void consultoOServicoDeSimulacaoDeInvestimentos() {
        response = request.when().get(ENDPOINT_SIMULADOR_INVESTIMENTOS);
//        System.out.println("response: " + response.prettyPrint());
    }

    @Dado("^que existe um serviço para realizar simulação de investimentos$")
    public void queExisteUmServicoParaRealizarSimulacaoDeInvestimentos() {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri(BASEURL)
                .build();
        request = given().spec(req);
    }

    @Então("^o código de status é (\\d+)$")
    public void oCodigoDeStatusE(int codigoStatus) {
        responseValidacao = response
                .then()
                .assertThat()
                .statusCode(codigoStatus);
    }

    @E("^a resposta retorna as seguintes informações$")
    public void aRespostaRetornaAsSeguintesInformacoes(List<Map<String, String>> dadosResposta) {
        List<String> item;

        for (Map<String, String> dado : dadosResposta) {
            for (Map.Entry<String, String> campo : dado.entrySet()) {
                item = Arrays.asList(campo.getValue().split(","));
                if (StringUtils.isNumeric(campo.getValue())) {
                    responseValidacao.body(campo.getKey(), equalTo(Integer.parseInt(campo.getValue())));
                } else {
                    for (int i = 0 ; i < item.size(); i++) {
                        responseValidacao.body(campo.getKey().concat(String.format("[%d]", i)), equalTo(item.get(i)));
                    }
                }
            }
        }
    }
}
