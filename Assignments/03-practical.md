# CSI607 - Sistemas WEB II

## Período Letivo 2025/1

### Prof. Fernando Bernardes de Oliveira, Ph.D

---

## Atividade Prática 03 - Desafio Técnico: API de Gerenciamento de Carteira de Investimentos

A proposta desta atividade prática é a implementação do seguinte desafio técnico utilizando Java/Spring Boot. Considere que uma fintech deseja lançar um app para usuários acompanharem suas **carteiras de investimentos**. A ideia é centralizar a visualização e o gerenciamento de diferentes tipos de ativos: **ações, criptomoedas, fundos de investimento, renda fixa e outros**.

O objetivo do desafio é criar uma *API RESTful* que permita aos usuários cadastrarem ativos que possuem, atualizarem informações, acompanharem saldos e obterem um resumo da carteira.

### Requisitos Funcionais

1. **Cadastrar um novo ativo na carteira**

   * Endpoint: `POST /investments`
   * Payload:

     ```json
     {
       "type": "ACAO",
       "symbol": "BBAS3",
       "quantity": 100,
       "purchasePrice": 19.68,
       "purchaseDate": "2025-07-31"
     }
     ```

2. **Listar todos os ativos da carteira**

   * Endpoint: `GET /investments`

3. **Filtrar ativos por tipo**

   * Endpoint: `GET /investments?type=CRIPTO`

4. **Atualizar um ativo**

   * Endpoint: `PUT /investments/{id}`

5. **Remover um ativo da carteira**

   * Endpoint: `DELETE /investments/{id}`

6. **Resumo da carteira**

   * Endpoint: `GET /investments/summary`
   * Exemplo de resposta:

     ```json
     {
       "totalInvested": 15000.00,
       "totalByType": {
         "ACAO": 8000.00,
         "CRIPTO": 1000.00,
         "FUNDO": 6000.00
       },
       "assetCount": 5
     }
     ```

---

### Tipos de ativos

Seguem alguns exemplos. Você pode incluir outros tipos também. A sugestão é que eles sejam definidos a partir de um `enum`.

* `ACAO` – Ações da bolsa
* `CRIPTO` – Criptomoedas
* `FUNDO` – Fundos de Investimento
* `RENDA_FIXA` – Títulos de renda fixa
* `OUTRO` – Qualquer outro tipo

---

### Requisitos Técnicos

* Java 17+ com Spring Boot 3.x
* Spring Data JPA com banco relacional: PostgreSQL ou MySQL (a sugestão que você utilize um container Docker para o banco)
* Uso de DTOs para entrada e saída
* Separação definida das camadas: Controller, Service, Repository, Model

---

### Diferenciais (opcionais)

* API para **atualizar valores de mercado** simulados (ex: via PATCH ou API externa mockada)
* Cálculo de lucro/prejuízo por ativo

---

### Entrega Esperada

* Repositório no GitHub com:

  * Código-fonte
  * README com instruções para rodar localmente
  * (Opcional) scripts para popular a base

---

### O que será avaliado

* Clareza e legibilidade do código
* Organização das camadas e uso correto de recursos do Spring
* Implementação das regras de negócio
* Simplicidade, mas com atenção aos detalhes

### Entrega

O código deve ser disponibilizado num repositório no Github e o link desse repositório deve ser inserido no Moodle no tópico correspondente à atividade.

---

**Uma excelente atividade para vocês!**

---

***Let's code!***

![Let's code!](https://media.giphy.com/media/USV0ym3bVWQJJmNu3N/giphy.gif)

![Happy coding](https://media.giphy.com/media/3bu85lsWhBTlWcOMN6/giphy.gif)

> ***What we have to learn to do, we learn by doing.***  
>
> --- Aristóteles.
