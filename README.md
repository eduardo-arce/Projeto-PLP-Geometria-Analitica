# Projeto PLP - Geometria Analítica

## Alunos

Eduardo Arce de Sales (eas6@cin.ufpe.br).

Wendell Pinheiro Abreu Marques (wpam@cin.ufpe.br).

## Disciplina

Disciplina: Paradigmas de Linguagem de Programação.

Professor: Dr. Augusto Cezar Alves Sampaio.

Campus: Centro de Informática (CIn).

Universidade: Universidade Federal de Pernambuco (UFPE).

## Sobre

Para este projeto, será feito o incremento de novas funcionalidades relacionadas a Geometria Analítica, dentro da linguagem imperativa 2.

As funcionalidades a ser desenvolvidas são:

* Distância entre 2 pontos;

* Ponto médio;

* Ângulo entre vetores;

* Conversão de ângulos:

    - De graus para radianos;
    - De radianos para graus;

## Execução

* Instalar Maven

```bash
sudo apt install maven -y
```

* Instalar JDK

```bash
sudo apt install openjdk-11-jdk
```

* Local

```bash
cd Imperativa2
mvn clean generate-sources compile exec:java
```

* Applet

```bash
cd ..
mvn package
# Jar será gerado em ./Applet/target/
```

* Abrir Aplicação

```bash
# Acessar a pasta ./Applet/target/ e executar no terminal:
java -jar Applet-0.0.1-jar-with-dependencies.jar
```

# BNF

<pre>
Programa ::= Comando

Comando ::= Atribuicao 
       |    ComandoDeclaracao
       |    While 
       |    IfThenElse 
       |    IO 
       |    Comando ";" Comando 
       |    Skip 
       |    ChamadaProcedimento

Skip ::=

Atribuicao ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/Id.java">Id</a> ":=" <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/Expressao.java">Expressao</a>

Expressao ::=  <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/Valor.java">Valor</a> | <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ExpUnaria.java">ExpUnaria</a> | <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ExpBinaria.java">ExpBinaria</a> | <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/Id.java">Id</a>

Valor ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ValorConcreto.java">ValorConcreto</a>

ValorConcreto ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ValorInteiro.java">ValorInteiro </a>
             |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ValorBooleano.java">ValorBooleano</a>
             |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ValorString.java">ValorString </a>
             |    ValorPonto

ExpUnaria ::= "-" Expressao 
             |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ExpMenos.java">"not" Expressao </a>
             |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ExpLength.java">"length" Expressao </a> 
             |    "dist" Expressao 
             |    "pm" Expressao
             |    "ang" Expressao 
             |    "ang2rad" Expressao
             |    "rad2gr" Expressao


ExpBinaria ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ExpSoma.java">Expressao "+" Expressao</a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ExpSub.java">Expressao "-" Expressao</a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ExpMulti.java">Expressao "*" Expressao</a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ExpAnd.java">Expressao "and" Expressao</a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ExpOr.java">Expressao "or" Expressao</a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ExpEquals.java">Expressao "==" Expressao</a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/tree/main/Imperativa2/src/li2/plp/expressions2/expression/ExpConcat.java">Expressao "++" Expressao</a>

ComandoDeclaracao :: = "{" Declaracao ";" Comando "}"

Declaracao ::= DeclaracaoVariavel | DeclaracaoProcedimento | Declaracao "," Declaracao

DeclaracaoVariavel ::= "var" Id "=" Expressao

DeclaracaoProcedimento ::= "proc" Id "(" [ ListaDeclaracaoParametro ] ")" "{" Comando "}"

ListaDeclaracaoParametro ::= Tipo Id | Tipo Id "," ListaDeclaracaoParametro

Tipo ::= "string" | "int" | "boolean" | "ponto"

While ::= "while" Expressao "do" Comando

IfThenElse ::= "if" Expressao "then" Comando "else" Comando

IO ::= "write" "(" Expressao ")" | "read" "(" Id ")"

ChamadaProcedimento ::= "call" Id "(" ListaExpressao ")"
</pre>

## Previsão das Apresentações

* Apresentação 1 - 11/04/2022.
* Apresentação 2 - 16/05/2022.

## Fonte

Geometria Analítica. Alfredo Steinbruch, Paulo Winterle. 1º Edição. Pearson. 1995.

