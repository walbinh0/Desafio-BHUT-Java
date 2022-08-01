# Feito por Walbert Chaves

Desafio realizado em Java para BHUT Serviços Tecnologia.

# Carros-api

Aplicação utilizando Spring Boot e MySQL

Requisitos:
Java/Maven/ Mysql

├───config        // Configurações do Swagger UI (Config do MongoDB 
Configure seu mongodb no application.properties caso tenho alterado a porta ou o usuário do seu mongodb, 
caso esteja o padrão não precisa alterar


├───controllers   // Lógica da aplicação (Method GET e Method POST)


├───entities      // Tabelas do banco (Criar as entidades do projeto)


├───helpers       // Funções auxiliares(DataFormat que poderia ser chamado em varias outras classes)


├───repositories  // Camada de interação com o banco (ICarRepository e ILogRepository)


├───request       // Requisição para cadastrar um car numa api externa


└───response      // Responses da API (fez envio de informcoes em json)

Maven - 
Bibliotecas importadas no mavem-

spring-boot-starter-data-mongodb
spring-data-mongodb
spring-boot-starter-web
spring-boot-devtools
spring-boot-starter-test
springfox-swagger-ui
springfox-boot-starter
lombok
lombok

O Projeto esta em Java 11, caso sua IDE nao reconheca o lombok tera que instalar ele na sua IDE 
link do instalador .jar: https://repo1.maven.org/maven2/org/projectlombok/lombok/1.18.24/lombok-1.18.24.jar
