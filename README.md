# Projeto PLP - Geometria Analítica

## Aluno

Eduardo Arce de Sales (eas6@cin.ufpe.br).

## Disciplina

Disciplina: Paradigmas de Linguagem de Programação.

Professor: Dr. Augusto Cezar Alves Sampaio.

Campus: Centro de Informática (CIn).

Universidade: Universidade Federal de Pernambuco (UFPE).

## Sobre

Para este projeto, será feito o incremento de novas funcionalidades relacionadas a Geometria Analítica, dentro da linguagem imperativa 2.

As funcionalidades a ser desenvolvidas são:

* Tipo Double;

* Distância entre 2 pontos;

* Ponto médio;

* Ângulo entre vetores;

* Conversão de ângulos:

    - De graus para radianos;
    - De radianos para graus;


Mas para efetuar esses cálculos, também é necessário expandir as funcionalidades:

* Soma (Inteiro e/ou Double);

* Subtração (Inteiro e/ou Double);

* Multiplicação (Inteiro e/ou Double);

* Divisão (Inteiro e/ou Double);

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
cd Imperativa2/
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
<a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative2/Programa.java">Programa</a> ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/command/Comando.java">Comando</a> 

Comando ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/command/Atribuicao.java">Atribuicao</a>  
       |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/command/ComandoDeclaracao.java">ComandoDeclaracao</a>  
       |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/command/While.java">While</a>   
       |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/command/IfThenElse.java">IfThenElse</a>   
       |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/command/IO.java">IO</a>   
       |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/command/SequenciaComando.java">Comando ";" Comando</a>   
       |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/command/Skip.java">Skip</a>   
       |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative2/command/ChamadaProcedimento.java">ChamadaProcedimento</a>  

Skip ::=

Atribuicao ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/Id.java">Id</a> ":=" <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/Expressao.java">Expressao</a>

Expressao ::=  <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/Valor.java">Valor</a> | <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpUnaria.java">ExpUnaria</a> | <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpBinaria.java">ExpBinaria</a> | <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/Id.java">Id</a>

Valor ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ValorConcreto.java">ValorConcreto</a>

ValorConcreto ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ValorInteiro.java">ValorInteiro</a>
             |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ValorBooleano.java">ValorBooleano</a>
             |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ValorString.java">ValorString</a>
             |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ValorMatriz.java"><i>ValorMatriz</i></a>
             |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ValorDouble.java"><i>ValorDouble</i></a>
             

ExpUnaria ::=  <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpMenos.java">"-" Expressao</a> 
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpMenos.java">"not" Expressao</a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpLength.java">"length" Expressao</a> 
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpDist.java"><i>"dist" Expressao</i></a> 
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpPm.java"><i>"pm" Expressao</i></a>   
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpAng.java"><i>"ang" Expressao</i></a>   
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpGraus2Rad.java"><i>"graus2rad" Expressao</i></a>    
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpRad2Graus.java"><i>"rad2graus" Expressao</i></a>     


ExpBinaria ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpSoma.java"><i>Expressao "+" Expressao</i></a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpSub.java"><i>Expressao "-" Expressao</i></a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpMulti.java"><i>Expressao "*" Expressao</i></a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpDiv.java"><i>Expressao "/" Expressao</i></a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpAnd.java">Expressao "and" Expressao</a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpOr.java">Expressao "or" Expressao</a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpEquals.java">Expressao "==" Expressao</a>
          |    <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/expressions2/expression/ExpConcat.java">Expressao "++" Expressao</a>

ComandoDeclaracao :: = "{" <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/declaration/Declaracao.java">Declaracao</a> ";" Comando "}"

Declaracao ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/declaration/DeclaracaoVariavel.java">DeclaracaoVariavel</a> | <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative2/declaration/DeclaracaoProcedimento.java">DeclaracaoProcedimento</a> | <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/declaration/DeclaracaoComposta.java">DeclaracaoComposta</a>

DeclaracaoVariavel ::= "var" Id "=" Expressao

DeclaracaoProcedimento ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative2/declaration/DeclaracaoProcedimento.java">"proc" Id "(" [ ListaDeclaracaoParametro ] ")" "{" Comando "}"</a> 

ListaDeclaracaoParametro ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative2/declaration/DeclaracaoParametro.java">Tipo Id</a> |  <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative2/declaration/ListaDeclaracaoParametro.java">Tipo Id "," ListaDeclaracaoParametro</a> 

Tipo ::= "string" | "int" | "boolean" | <i>"matriz"</i> | <i>"double"</i>

While ::= "while" Expressao "do" Comando

IfThenElse ::= "if" Expressao "then" Comando "else" Comando

IO ::= <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/command/While.java">"write" "(" Expressao ")"</a> | <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative1/command/Read.java">"read" "(" Id ")"</a>

ChamadaProcedimento ::= "call" Id "(" [ <a href="https://github.com/eduardo-arce/Projeto-PLP-Geometria-Analitica/blob/feature/eduardo_arce/Imperativa2/src/li2/plp/imperative2/command/ListaExpressao.java">ListaExpressao</a> ] ")"
</pre>

## Previsão das Apresentações

* Apresentação 1 - 11/04/2022.
* Apresentação 2 - 11/05/2022.

## Fonte

Geometria Analítica. Alfredo Steinbruch, Paulo Winterle. 1º Edição. Pearson. 1995.

https://www.cin.ufpe.br/~in1007/linguagens/Imperativa2/imperativa2.html