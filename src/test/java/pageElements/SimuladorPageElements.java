package pageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SimuladorPageElements {

    @FindBy(id = "valorAplicar")
    protected WebElement CAMPO_VALOR_APLICACAO;

    @FindBy(id="valorInvestir")
    protected WebElement CAMPO_VALOR_INVESTIR;

    @FindBy(id="tempo")
    protected WebElement CAMPO_TEMPO;

    @FindBy(className = "btSelect")
    protected WebElement BOTAO_UNIDADE_TEMPO;

    @FindBy(linkText = "Meses")
    protected WebElement OPCAO_MESES;

    @FindBy(linkText = "Anos")
    protected WebElement OPCAO_ANOS;

    @FindBy(xpath="//*[@id='formInvestimento']/div[5]/ul/li[2]/button")
    protected WebElement BOTAO_SIMULAR;

    @FindBy(id = "valorAplicar-error")
    protected WebElement LABEL_ERRO_VALOR_APLICACAO;

    @FindBy(id = "valorInvestir-error")
    protected WebElement LABEL_ERRO_VALOR_INVESTIR;

    @FindBy(id = "tempo-error")
    protected WebElement LABEL_ERRO_TEMPO;

    @FindBy(xpath="/html/body/div[3]/div/div/div[1]/div/div[2]/span[2]")
    protected WebElement LABEL_VALOR_GUARDADO;

    @FindBy(xpath="/html/body/div[3]/div/div/div[1]/div/div[2]/div[1]/table/tbody/tr")
    protected List<WebElement> LINHAS_OPCOES_INVESTIMENTOS;

    @FindBy(xpath="/html/body/div[3]/div/div/div[1]/div/div[2]/a")
    protected WebElement BOTAO_REFAZER_SIMULACAO;

}
