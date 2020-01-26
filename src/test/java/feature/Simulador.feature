#language: pt
#encoding: utf-8
@simulador-investimento
Funcionalidade: Simulador Investimento

  Com o propósito de Simular um Investimento na Poupança
  como um Associado,
  eu gostaria de preencher o formulário de simulação
  e ver a tabela de resultado com Mês e Valor.

  @UI
  Esquema do Cenario: Simulador
    Dado que estou na tela do simulador
    Quando faço uma simulação aplicando R$<valor_aplicacao> e poupando R$<valor_poupar> por <tempo> "<unidade>"
    Então é apresentado o valor "<valor_guardado>" como valor guardado
    E são apresentada outras quatro opções de investimentos
    Exemplos:
      | valor_aplicacao | valor_poupar | tempo | unidade | valor_guardado |
      | 1000,00         | 100,00       | 120   | Meses   | R$ 15.415      |
      | 1000,00         | 200,00       | 2     | Anos    | R$ 6.010       |

  @UI
  Esquema do Cenario: Erros simulação
    Dado que estou na tela do simulador
    Quando faço uma simulação aplicando R$<valor_aplicacao> e poupando R$<valor_poupar> por <tempo> "<unidade>"
    Então é apresentado erro no campo "Qual o valor que você quer aplicar?"
    E o texto do erro apresentado é "<mensagem_erro_aplicar>"
    E é apresentado erro no campo "Quanto você quer poupar todo mês?"
    E o texto do erro apresentado é "<mensagem_erro_poupar>"
    E é apresentado erro no campo "Por quanto tempo você quer poupar?"
    E o texto do erro apresentado é "<mensagem_erro_tempo>"
    E simulação não é realizada

    Exemplos:
      | valor_aplicacao | valor_poupar | tempo   | unidade | mensagem_erro_aplicar | mensagem_erro_poupar  | mensagem_erro_tempo        |
      | 19,99           | 19,99        | 0       | Meses   | Valor mínimo de 20.00 | Valor mínimo de 20.00 | Valor esperado não confere |
      | {vazio}         | {vazio}      | {vazio} | Anos    | Valor mínimo de 20.00 | Valor mínimo de 20.00 | Obrigatório                |
      | palavra         | palavra      | palavra | Meses   | Valor mínimo de 20.00 | Valor mínimo de 20.00 | Obrigatório                |

  @API
  Cenario: Services
    Dado que existe um serviço para realizar simulação de investimentos
    Quando consulto o serviço de simulação de investimentos
    Então o código de status é 200
    E a resposta retorna as seguintes informações
      | id | meses           | valor                   |
      | 1  | 112,124,136,148 | 2.802,3.174,3.564,3.971 |

