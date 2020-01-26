
# TESTES SIMULADOR INVESTIMENTOS

Para executar os testes, abrir o terminal, navegar até o diretório root da aplicação e executar:

```sh
gradle cucumber 
```


# Docker
  
Para executar utilizando Docker favor seguir as instruções abaixo:

 > Pré-requisito:
 >   Possuir o docker instalado na máquina
 >  - [Instalaçao Docker]([https://docs.docker.com/install/](https://docs.docker.com/install/))


Iniciar servidor:
```sh
docker run -d --network host -p 4444:4444 selenium/standalone-chrome
```
Executar os testes:
```sh
docker run --network host simulador-investimento gradle cucumber
```


# Jenkins
 > Pré-requisito:
 >   Possuir o docker instalado na máquina que o jenkins está instalado
 >  - [Instalaçao Docker]([https://docs.docker.com/install/](https://docs.docker.com/install/))

Para utilizar o Jenkins, deve-se criar um job do tipo Pipeline e importar o arquivo Jenkinsfile nele

# Observações

  - Foram disponibilizados os drivers do Chrome para Linux e Windows, versão 79, no projeto. Caso o Chrome instalado na máquina seja de outra versão, será necessário o download do chromedriver correspondente e inserir no diretório "drivers";
  [download chromedriver](http://chromedriver.chromium.org/downloads)
  - Para acompanhar as execução dos testes de UI, visualizando o navegador, é necessário alterar a a propriedade 'headless' para "false" no arquivo src/test/resources/dados.properties