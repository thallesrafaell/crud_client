# Projeto CRUD de Cliente com JDBC

Este projeto demonstra o uso de JDBC (Java Database Connectivity) para criar um sistema CRUD (Create, Read, Update, Delete) para gerenciar clientes em um banco de dados relacional usando Java. Ele inclui classes para conexão com o banco de dados, acesso a dados (DAO), modelos de dados e testes unitários.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- **`src/main/java/dev/thallesrafael/jdbc`**: Contém as classes principais do projeto.
  - `connection`: Classes relacionadas à conexão com o banco de dados.
  - `dao`: Interfaces e implementações dos objetos de acesso a dados (DAO) para clientes.
  - `model`: Classes de modelos de dados para clientes.

- **`src/test/java/dev/thallesrafael/jdbc`**: Contém os testes unitários para as classes principais do projeto.
  - `connection`: Testes para as classes de conexão com o banco de dados.
  - `dao`: Testes para as interfaces e implementações dos objetos de acesso a dados (DAO) para clientes.
  - `model`: Testes para as classes de modelos de dados para clientes.

## Pré-requisitos

- JDK (Java Development Kit) instalado

## Como Executar os Testes

1. Clone o repositório do projeto:

   ```bash
   git clone https://github.com/thallesrafaell/crud_client.git
   ls
    ```  

2. Navegue até o diretório do projeto:
   ```bash
   cd crud_client
    ```
3. Execute os testes usando o seguinte comando
  ```bash
  javac -cp "src:test" -d out test/java/dev/thallesrafael/jdbc/*.java
  java -cp "out;lib/*" org.junit.runner.JUnitCore test.java.dev.thallesrafael.jdbc.AllTest
  ls
  ```

  - Certifique-se de que o arquivo 'AllTest.java' está localizado no diretório 'test/java/dev/thallesrafael/jdbc'.
    O comando acima compila os arquivos de teste e as classes principais e, em seguida, executa todos os testes.

## Contribuindo
  Sinta-se à vontade para abrir problemas (issues) ou enviar solicitações de recebimento (pull requests) para contribuir com melhorias ou corrigir problemas encontrados no projeto.

