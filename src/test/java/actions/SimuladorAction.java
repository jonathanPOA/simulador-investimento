package actions;

import objects.OpcaoInvestimento;
import pages.SimuladorPage;

import java.util.List;

public class SimuladorAction {

    private SimuladorPage simuladorPage = new SimuladorPage();

    public void realizarSimulacao(String valor_aplicacao, String valor_poupar, String meses){
        simuladorPage.preencheCampoValorAplicar(valor_aplicacao);
        simuladorPage.preencheCampoQuantoInvestirPorMes(valor_poupar);
        simuladorPage.preencheCampoQuantoTempoPoupar(meses);
        simuladorPage.clicaBotaoSimular();

    }

    public boolean validarApresentacaoTabelaResultados(){
        if (simuladorPage.aguardaResultadoSimulacao()) {
            List<OpcaoInvestimento> listaOpcoesInvestimento = simuladorPage.retornaLinhasTabelaResultados();

            for(OpcaoInvestimento opcaoInvestimento: listaOpcoesInvestimento){
                if (opcaoInvestimento.tempo.isBlank()) return false;
                if (opcaoInvestimento.valor.isBlank()) return false;
            }
            return listaOpcoesInvestimento.size() >= 4;
        }
        return false;
    }

    public boolean validarTextoErro(String campo, String mensagem){
        boolean textoCorretamenteApresentado;

        switch (campo){
            case "Qual o valor que você quer aplicar?":
                textoCorretamenteApresentado =
                        simuladorPage.retornaTextoLabelErroValorPoupar().equalsIgnoreCase(mensagem);
                break;
            case "Quanto você quer poupar todo mês?":
                textoCorretamenteApresentado =
                        simuladorPage.retornaTextoLabelErroValorAplicar().equalsIgnoreCase(mensagem);
                break;
            case "Por quanto tempo você quer poupar?":
                textoCorretamenteApresentado =
                        simuladorPage.retornaTextoLabelErroTempo().equalsIgnoreCase(mensagem);
                break;
            default:
                textoCorretamenteApresentado = false;
        }
        return textoCorretamenteApresentado;
    }

    public boolean validarApresentacaoErro(String campo){
        boolean erroFoiApresentado;

        switch (campo){
            case "Qual o valor que você quer aplicar?":
                erroFoiApresentado = simuladorPage.labelErroValorPouparEstaVisivel();
                break;
            case "Quanto você quer poupar todo mês?":
                erroFoiApresentado = simuladorPage.labelErroValorAplicarEstaVisivel();
                break;
            case "Por quanto tempo você quer poupar?":
                erroFoiApresentado = simuladorPage.labelErroTempoEstaVisivel();
                break;
            default:
                erroFoiApresentado = false;
        }
        return erroFoiApresentado;
    }
}
