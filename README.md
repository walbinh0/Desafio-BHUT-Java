# Feito por Walbert Chaves

Desafio realizado em Java para BHUT Serviços Tecnologia.

# carros-api

Aplicação utilizando Spring Boot e MySQL

Requisitos:
Java/Maven/ Mysql

# - Passos para o SETUP -

Para acessar a api use a url: http://localhost:8080/swagger-ui/index.html#/

Config do MongoDB
Configure seu mongodb no application.properties caso tenho alterado a porta ou o usuário do seu mongodb,
caso esteja o padrão não precisa alterar.

Controller
CarsController -
Method GET - Esta fazendo uma consulta numa api externa para retorna uma lista de car,
utilizei o RestTemplate para fazer essa requisição, onde ele retorna um array de objetc,
e utilizo o Arrays.aslist para enviar no body do ResponseEntity.

Method POST - Esta fazendo uma requisição para cadastrar um car numa api externa,
utilizei uma Classe auxiliar Chamada carRequest,
para pegar os dados que queria em json e passar para classe car,
onde utilizei a biblioteca do spring-data-mongodb para fazer o cadastro do car,
e enviei a requisição utilizando RestTemplate passando a classe car,
criei uma classe log para salvar o log das requisições feitas.

LogController -

Method GET - Esta fazendo uma consulta no banco de dados e retornando todos os logs.

Repositories
ICarRepository - Utilizei a biblioteca do spring-data-mongodb para extender a Classe MongoRepository,
e utilizei os metodos de crud desta classe para me auxiliar.

ILogRepository - Utilizei a biblioteca do spring-data-mongodb para extender a Classe MongoRepository,
e utilizei os metodos de crud desta classe para me auxiliar.

Pacotes -
Config - utilizei para Criar as classes de configuração do projeto.

Controllers - Utilizei para Criar as Classes Controller do projeto.

Entities - Utilizei para Criar as entidades do projeto.

Helpers - Utilizei para criar metodos auxiliares, como o DataFormat que poderia ser chamado em varias outras classes.

Repositories - Utilizei para as minhas classes Repository.

Request - Utilizei para minhas classes de Request, que fazem o recebimento das informacoes em json.

Response - Utilizei para minhas classes de Response, que fazem o envio de informcoes em json.

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
