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
     * Preenche o campo 'Quanto você quer poupar to do mês?'
     * @param texto: o conteúdo que deve ser preenchido no campo
     */
    public void preencheCampoQuantoInvestirPorMes(String texto){
        CAMPO_VALOR_INVESTIR.clear();
        CAMPO_VALOR_INVESTIR.sendKeys(texto);
        CAMPO_VALOR_INVESTIR.sendKeys(Keys.TAB);
    }

    /**
     * Preenche o campo 'Por quanto tempo você quer poupar?'
     * @param texto: o conteúdo que deve ser preenchido no campo
     */
    public void preencheCampoQuantoTempoPoupar(String texto){
        CAMPO_TEMPO.clear();
        CAMPO_TEMPO.sendKeys(texto);
        CAMPO_TEMPO.sendKeys(Keys.TAB);
    }

    /**
     * Seleciona a unidade de medida de tempo que será utilizada na simulação
     * @param opcao: a opção que deve ser selecionada. (Meses ou Anos)
     */
    public void selecionaUnidadeTempo(String opcao){
        BOTAO_UNIDADE_TEMPO.click();
        SeleniumUtils.aguardaElementoClicavel(OPCAO_ANOS, 2);
        if(opcao.equalsIgnoreCase("Meses")){
            OPCAO_MESES.click();
        }else{
            OPCAO_ANOS.click();
        }

    }

    /**
     * Clica no botão 'Simular'
     */
    public void clicaBotaoSimular(){
        BOTAO_SIMULAR.click();
    }

    /**
     * Retorna as opções de investimento apresentadas
     * @return Uma lista de opções de Investimento
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
     * Retorna o texto do label de erro do elemento 'Qual o valor que você quer aplicar?'
     * @return o texto do elemento
     */
    public String retornaTextoLabelErroValorAplicar(){
        return LABEL_ERRO_VALOR_APLICACAO.getText();
    }

    /**
     * Retorna o texto do label de erro do elemento 'Quanto você quer poupar to.do mês?'
     * @return o texto do elemento
     */
    public String retornaTextoLabelErroValorPoupar(){
        return LABEL_ERRO_VALOR_INVESTIR.getText();
    }

    /**
     * Retorna o texto do label de erro do elemento 'Por quanto tempo você quer poupar?'
     * @return o texto do elemento
     */
    public String retornaTextoLabelErroTempo(){
        return LABEL_ERRO_TEMPO.getText();
    }

    /**
     * Retorna o texto do label do valor guardado
     * @return o texto do elemento
     */
    public String retornaValorGuardado(){
        return LABEL_VALOR_GUARDADO.getText();
    }

    /**
     * Aguarda o resultado da simulação por 5 segundos
     * @return true se o resultado da simulação foi apresentado, false caso contrário
     */
    public boolean aguardaResultadoSimulacao(){
        return SeleniumUtils.aguardaElementoClicavel(BOTAO_REFAZER_SIMULACAO, 5);
    }

    /**
     * Retorna se o label de erro do elemento 'Qual o valor que você quer aplicar?' foi apresentado
     * @return se o elemento está sendo apresentado
     */
    public boolean labelErroValorAplicarEstaVisivel(){
        return LABEL_ERRO_VALOR_APLICACAO.isDisplayed();
    }

    /**
     * Retorna se o label de erro do elemento 'Quanto você quer poupar to.do mês?' foi apresentado
     * @return se o elemento está sendo apresentado
     */
    public boolean labelErroValorPouparEstaVisivel(){
        return LABEL_ERRO_VALOR_INVESTIR.isDisplayed();
    }

    /**
     * Retorna se o label de erro do elemento 'Por quanto tempo você quer poupar?' foi apresentado
     * @return se o elemento está sendo apresentado
     */
    public boolean labelErroTempoEstaVisivel(){
        return LABEL_ERRO_TEMPO.isDisplayed();
    }



}
