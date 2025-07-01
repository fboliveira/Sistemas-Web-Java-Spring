# Ordem para definição/criação dos elementos no projeto

1. Definir a entidade do domínio (domain)
1. Refatorar/definir as relações com a nova entidade de domínio
1. Definir as regras de negócio - use case
1. Definir a entidade da infraestrutura (model) - JPA
1. Refatorar/definir as relações com a nova entidade JPA
1. Definir o repositório (interface) para a entidade JPA
1. Definir, se necessário, os métodos no repositório.
1. Definir o serviço (CRUD)
    - Estabelecer os DTOs de entrada e saída
    - Definir os conversores: model -> entity; entity -> dto, ...
    - Definir os serviços
1. Definir o controller/endpoints - utiliza o serviço para enviar requisições (DTOs) e receber respostas (DTOs).
1. Definir e escrever os testes unitários/integração.
