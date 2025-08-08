# Literalura - Catálogo de Livros

![Badge](https://img.shields.io/badge/Status-Finalizado-brightgreen)
![Badge](https://img.shields.io/badge/Challenge-ONE%20%2B%20Alura-blue)

## 📖 Sobre o Projeto

**Literalura** é uma aplicação de console desenvolvida como parte do desafio de conclusão da formação **Spring Boot** do programa **ONE (Oracle Next Education)** em parceria com a **Alura**.

O objetivo do projeto é construir um catálogo de livros interativo que consome a API pública [Gutendex](https://gutendex.com/) para buscar e registrar livros e autores em um banco de dados local. A aplicação permite que o usuário interaja via terminal para realizar diversas consultas ao catálogo.

---

## ✨ Funcionalidades

A aplicação oferece as seguintes funcionalidades através de um menu interativo no console:

1.  **Buscar Livro por Título**: Pesquisa um livro na API Gutendex pelo título e o salva no banco de dados, caso ainda não exista.
2.  **Listar Livros Registrados**: Exibe todos os livros que foram salvos no banco de dados.
3.  **Listar Autores Registrados**: Exibe todos os autores dos livros salvos no banco de dados.
4.  **Listar Autores Vivos em Determinado Ano**: Permite ao usuário inserir um ano e exibe os autores que estavam vivos naquele período.
5.  **Listar Livros por Idioma**: Permite ao usuário selecionar um idioma (português, inglês, etc.) e exibe os livros registrados naquele idioma.

---

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído com as seguintes tecnologias e ferramentas:

* **Linguagem**: Java 17
* **Framework**: Spring Boot 3
* **Módulos Spring**:
    * `Spring Data JPA`: Para persistência de dados e comunicação com o banco de dados.
    * `Spring Web`: Para realizar as requisições HTTP à API Gutendex através do `RestTemplate`.
* **Banco de Dados**: PostgreSQL
* **API Externa**: Gutendex API
* **Manipulação de JSON**: Biblioteca Jackson (integrada ao Spring)
* **Build Tool**: Apache Maven

---

## 🚀 Como Rodar o Projeto

Siga os passos abaixo para executar o projeto em sua máquina local.

### Pré-requisitos

Antes de começar, você precisará ter o seguinte instalado:
* [Java Development Kit (JDK) 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) ou superior.
* [Apache Maven](https://maven.apache.org/download.cgi).
* Um SGBD [PostgreSQL](https://www.postgresql.org/download/) ativo.

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/literalura.git](https://github.com/seu-usuario/literalura.git)
    cd literalura
    ```

2.  **Configure o Banco de Dados:**
    * Crie um novo banco de dados no seu PostgreSQL. Por exemplo, com o nome `literalura_db`.
    * Abra o arquivo `src/main/resources/application.properties`.
    * Atualize as propriedades de conexão com o seu usuário, senha e o nome do banco de dados que você criou:

    ```properties
    # URL de conexão com o banco de dados PostgreSQL
    spring.datasource.url=jdbc:postgresql://localhost:5432/literalura_db

    # Usuário e senha do banco de dados
    spring.datasource.username=seu-usuario-aqui
    spring.datasource.password=sua-senha-aqui

    # Configurações do JPA e Hibernate
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.show-sql=true # Opcional: mostra os comandos SQL no console
    ```

3.  **Execute a Aplicação:**
    * Abra um terminal na pasta raiz do projeto.
    * Use o Maven para compilar e executar a aplicação:

    ```bash
    mvn spring-boot:run
    ```
    * Após a inicialização do Spring, o menu interativo da aplicação será exibido no console, e você poderá começar a usar as funcionalidades.

---

## 👨‍💻 Autor

Desenvolvido por **Márcio Otávio]**.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/seu-linkedin/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/seu-usuario/)

*Projeto construído como parte do programa de formação da Alura e Oracle Next Education.*
