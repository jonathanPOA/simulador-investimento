#language: pt
#encoding: utf-8
@simulador-investimentos
Funcionalidade: Com o propósito de Simular um Investimento na Poupança

  Esquema do Cenario: Simulador
    Dado que estou na tela do simulador
    Quando faço uma simulação aplicando R$<valor_aplicacao> e poupando R$<valor_poupar> por <meses> meses
    Então é apresentado o resultado da simulação
    Exemplos:
      | valor_aplicacao | valor_poupar | meses |
      | 1000,00         | 100,00       | 120   |
      | 1000,00         | 200,00       | 100   |

  Esquema do Cenario: Erros simulação
    Dado que estou na tela do simulador
    Quando faço uma simulação aplicando R$<valor_aplicacao> e poupando R$<valor_poupar> por <meses> meses
    Então é apresentado erro no campo "Qual o valor que você quer aplicar?"
    E o texto do erro apresentado é "<mensagem_erro_aplicar>"
    E é apresentado erro no campo "Quanto você quer poupar todo mês?"
    E o texto do erro apresentado é "<mensagem_erro_poupar>"
    E é apresentado erro no campo "Por quanto tempo você quer poupar?"
    E o texto do erro apresentado é "<mensagem_erro_tempo>"
    E simulação não é realizada

    Exemplos:
      | valor_aplicacao | valor_poupar | meses   | mensagem_erro_aplicar | mensagem_erro_poupar  | mensagem_erro_tempo        |
      | 19,99           | 19,99        | 0       | Valor mínimo de 20.00 | Valor mínimo de 20.00 | Valor esperado não confere |
      | {vazio}         | {vazio}      | {vazio} | Valor mínimo de 20.00 | Valor mínimo de 20.00 | Obrigatório                |
      | palavra         | palavra      | palavra | Valor mínimo de 20.00 | Valor mínimo de 20.00 | Obrigatório                |


