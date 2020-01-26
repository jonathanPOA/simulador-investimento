package pages;

import Setup.TestRule;
import Utils.SeleniumUtils;
import objects.OpcaoInvestimento;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageElements.SimuladorPageElements;

import java.util.ArrayList;
import java.util.List;

public class SimuladorPage extends SimuladorPageElements {

    public SimuladorPage(){
        PageFactory.initElements(TestRule.getDriver(), this);
    }

    /**
     * Preenche o campo 'Qual o valor que você quer aplicar?'
     * @param texto: o conteúdo que deve ser preenchido no campo
     */
    public void preencheCampoValorAplicar(String texto){
        CAMPO_VALOR_APLICACAO.clear();
        CAMPO_VALOR_APLICACAO.sendKeys(texto);
        CAMPO_VALOR_APLICACAO.sendKeys(Keys.TAB);
    }

    /**
     * Preenche o campo 'Qual o valor que você quer aplicar?'
     * @param texto: o conteúdo que deve ser preenchido no campo
     */
    public void preencheCampoQuantoInvestirPorMes(String texto){
        CAMPO_VALOR_INVESTIR.clear();
        CAMPO_VALOR_INVESTIR.sendKeys(texto);
        CAMPO_VALOR_INVESTIR.sendKeys(Keys.TAB);
    }

    /**
     * Preenche o campo 'Qual o valor que você quer aplicar?'
     * @param texto: o conteúdo que deve ser preenchido no campo
     */
    public void preencheCampoQuantoTempoPoupar(String texto){
        CAMPO_TEMPO.clear();
        CAMPO_TEMPO.sendKeys(texto);
        CAMPO_TEMPO.sendKeys(Keys.TAB);
    }

    /**
     * Preenche o campo 'Qual o valor que você quer aplicar?'
     */
    public void clicaBotaoSimular(){
        BOTAO_SIMULAR.click();
    }

    /**
     * Preenche o campo 'Qual o valor que você quer aplicar?'
     */
    public List<OpcaoInvestimento> retornaLinhasTabelaResultados(){
        List<OpcaoInvestimento> listaOpcoesInvestimento = new ArrayList<>();
        for(WebElement resultado : LINHAS_OPCOES_INVESTIMENTOS){
            listaOpcoesInvestimento.add(new OpcaoInvestimento(resultado.getText().split(" R\\$ ")[0],
                    resultado.getText().split(" R\\$ ")[1]));
        }
        return  listaOpcoesInvestimento;
    }

    /**
     * Preenche o campo 'Qual o valor que você quer aplicar?'
     */
    public boolean aguardaResultadoSimulacao(){
        return SeleniumUtils.aguardaElementoClicavel(BOTAO_REFAZER_SIMULACAO, 5);
    }

    /**
     * Retorna o texto do label de erro do elemento 'Qual o valor que você quer aplicar?'
     * @return o texto do elemento
     */
    public String retornaTextoLabelErroValorAplicar(){
        return LABEL_ERRO_VALOR_APLICACAO.getText();
    }

    /**
     * Retorna se o label de erro do elemento 'Qual o valor que você quer aplicar?' foi apresentado
     * @return se o elemento está sendo apresentado
     */
    public boolean labelErroValorAplicarEstaVisivel(){
        return LABEL_ERRO_VALOR_APLICACAO.isDisplayed();
    }

    /**
     * Retorna o texto do label de erro do elemento 'Quanto você quer poupar to.do mês?'
     * @return o texto do elemento
     */
    public String retornaTextoLabelErroValorPoupar(){
        return LABEL_ERRO_VALOR_INVESTIR.getText();
    }

    /**
     * Retorna se o label de erro do elemento 'Quanto você quer poupar to.do mês?' foi apresentado
     * @return se o elemento está sendo apresentado
     */
    public boolean labelErroValorPouparEstaVisivel(){
        return LABEL_ERRO_VALOR_INVESTIR.isDisplayed();
    }

    /**
     * Retorna o texto do label de erro do elemento 'Por quanto tempo você quer poupar?'
     * @return o texto do elemento
     */
    public String retornaTextoLabelErroTempo(){
        return LABEL_ERRO_TEMPO.getText();
    }

    /**
     * Retorna se o label de erro do elemento 'Por quanto tempo você quer poupar?' foi apresentado
     * @return se o elemento está sendo apresentado
     */
    public boolean labelErroTempoEstaVisivel(){
        return LABEL_ERRO_TEMPO.isDisplayed();
    }


}
