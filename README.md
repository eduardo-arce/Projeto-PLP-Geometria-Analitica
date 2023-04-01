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

As funcionalidades a ser desenvolvidas estão exibidas a seguir:
* Ponto e Reta:
    - Distância entre 2 pontos;
    - Ponto médio;
    - Ângulo entre vetores;
    - Converter ângulos de graus para radianos e de radianos para graus;
* A definir.

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
mvn package
# Jar será gerado em ./Applet/target/
```

* Abrir Aplicação

```bash
# Acessar a pasta ./Applet/target/ e executar no terminal:
java -jar Applet-0.0.1-jar-with-dependencies.jar
```


## Previsão das Apresentações

* Apresentação 1 - 11/04/2022.
* Apresentação 2 - 16/05/2022.

## Fonte

Geometria Analítica. Alfredo Steinbruch, Paulo Winterle. 1º Edição. Pearson. 1995.

