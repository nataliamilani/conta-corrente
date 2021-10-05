# Projeto final referente a matéria de Microservices & Serverless Architecture
## Curso: MBA em Full Stack Developer

**Aplicação:** conta-corrente

**Visão geral:** Essa aplicação tem por objetivo registrar movimentações de conta-corrente.
Sendo assim, nela temos os request para os seguintes objetivos:
- Criar uma conta-corrente (neste momento é executado requisições POST, para as aplicações de débito e crédito, criarem uma transação inicial com valores zerados, para que possamos ter o valor do saldo da conta-corrente);
- Consultar detalhes de uma conta corrente especifica;


**Requisitos minimos de instalação:**
- Java 11
- Docker desktop
- Maven

**Tecnologias utilizadas:**
- Spring Boot
- Java 11
- Maven
- Junit
- Swagger

**Monitoração:**
- Prometheus

**Segurança:**
- API Gateway

**Disponibilidade:**
- Eureka

**Postman - link para import na plataforma:**
- https://www.getpostman.com/collections/f8eea8546a1af821ef31

**OBS:** Para a execução das aplicações locais, aplicação de conta-corrente **DEPENDE** das aplicações:
- eureka (https://github.com/nataliamilani/eureka) já estar online para receber os registros;
- api-gateway (https://github.com/nataliamilani/api-gateway);
- prometheus (https://github.com/nataliamilani/prometheus);
- debito (https://github.com/nataliamilani/credito);
- credito (https://github.com/nataliamilani/credito);

Para subir os containers, basta utilizar o comando "docker-compose up", no diretório raiz das aplicações, após clonar os repositórios na máquina local.
