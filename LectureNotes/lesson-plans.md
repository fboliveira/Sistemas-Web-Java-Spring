# Roteiro de aulas

1. Introdução
    1. Estrutura do curso
    1. Plano de ensino
    1. Avaliações
1. Arquitetura das aplicações
    1. Microsserviços
    1. Clean code
    1. Arquitetura hexagonal.
1. [Spring e Spring boot](./spring-boot.md)
1. Primeiro projeto em spring boot:
    1. IDEs
    1. Spring initializr.
    1. [Hello word](../Codes/helloworld/)
        1. Estrutura do projeto
        1. Dependências
        1. Beans
        1. Lombok
1. Microsserviços - Sistema de venda de tickets
    1. [Arquitetura](../Docs/tickets-architecture.excalidraw)
    1. Bancos de dados: users, sales e notification
        1. Docker e [Docker compose](../Codes/ticket/docker-compose-dev.yaml)
    1. [Users service](../Codes/ticket/user/)
        1. Criação do projeto e dependências
        1. [Spring JPA](./spring-jpa.md)
        1. Definição da arquitetura: domain (use cases), model (entity jpa), dtos, converters, repositories (jpa), services e controllers
        1. CRUD users
            1. DTO de retorno: [SimpleUserRecordDTO](../Codes/ticket/user/src/main/java/br/ufop/edu/web/ticket/user/dtos/SimpleUserRecordDTO.java)
            1. Create
            1. Get all
            1. Get by id
            1. Update
            1. Update password
            1. Delete
        1. Entidade [CreditCardNetwork](../Codes/ticket/user/src/main/java/br/ufop/edu/web/ticket/user/models/CreditCardNetworkModel.java)
            1. Relação @ManyToOne -> users
            1. CRUD: create e get all
            1. Service e controller
        1. Users:
            1. Update user CCN - update service e controller
        1. Nameserver service
            1. Criação do projeto (restart vscode para o projeto ser carregado)
            1. Dependências: Eureka Server
            1. Definições no application.properties
            1. Anotação na main: `@EnableEurekaServer`
            1. Atualização das dependências nos projetos: eureka client
        1. Gateway
            1. Criação do projeto
            1. Dependências
            1. Atualização das dependências nos projetos
        1. Frontend
            1. Criação do projeto