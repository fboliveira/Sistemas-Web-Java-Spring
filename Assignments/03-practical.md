# CSI607 - Sistemas WEB II

## Período Letivo 2025/2

### Prof. Fernando Bernardes de Oliveira, Ph.D

---

## Atividade Prática 03 - Desafio Técnico: API de Gerenciamento de Carteira de Investimentos

A proposta desta atividade prática é a implementação do seguinte desafio técnico utilizando **Java/Spring Boot**. Considere que uma *fintech* deseja lançar um app para usuários acompanharem suas **carteiras de investimentos**. A ideia é centralizar a visualização e o gerenciamento de diferentes tipos de ativos: **ações, criptomoedas, fundos de investimento, renda fixa e outros**.

O objetivo do desafio é criar uma **API RESTful** que permita aos usuários cadastrarem ativos que possuem, atualizarem informações, acompanharem saldos e obterem um resumo da carteira.

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
* Separação definida das camadas: *Controller, Service, Repository, Model* (ou outra arquitetura que você preferir)

---

### Diferenciais (opcionais)

* API para **atualizar valores de mercado** simulados (exemplos: via PATCH ou API externa)
* Cálculo de lucro/prejuízo por ativo
* Arquivo .rest, Insomnia ou equivalente com a utilização dos endpoints.
* Implementação da interface Web com React.js (*pontuação extra*).

---

### Entregas

A entrega dos códigos deverá ser feito num repositório no GitHub, bem como o documento README com as instruções e critérios utilizados na implementação. O *link* com a apresentação deverá ser postado no Moodle. Fica ao seu critério incluir ou não o *link* da apresentação no GitHub.

* **Repositório no GitHub com:**

  * Código-fonte
  * README com instruções para rodar localmente e especificação dos critérios utilizados
  * (Opcional) scripts para popular a base

* **Moodle**: o *link* do vídeo publicado em alguma plataforma (YouTube, Vimeo, Google Meet/Drive, dentre outros).

---

### Critérios e pontuação

A apresentação do trabalho será realizada a partir da **gravação de um vídeo** contendo a descrição do projeto e a implementação. Os critérios estabelecidos a seguir serão utilizados para a avaliação do trabalho. As notas também serão compostas pela avaliação da turma (avaliação pelos pares).

O que será avaliado:

* Clareza e legibilidade do código.
* Organização das camadas e uso correto de recursos do Spring.
* Implementação das regras de negócio.
* Simplicidade, mas com atenção aos detalhes.

O **limite de tempo para o vídeo é entre 10 a 15 minutos**. A **nota final** é composta pela avaliações pelos pares e pela minha avaliação.

Como o Moodle tem restrição do tamanho de arquivos, eu sugiro que vocês postem os vídeos no *YouTube* (ou plataforma similar). Assim, vocês podem enviar apenas o *link* da apresentação produzida.

---

### Avaliação pelos pares

Na avaliação pelos pares, você fará a pontuação dos itens em formulário disponibilizado no *Google Forms* conforme os critérios indicados (os *links* estarão no Moodle). A coleta de e-mails será realizada apenas para fins de controle da pontuação individual.

É importante que você avalie todos os outros trabalhos. A participação na avaliação pelos pares das apresentações valem **10,0 pontos** (individual e atribuídos à pessoa que avaliou).

---

### Cronograma

O crograma a seguir é uma **recomendação**. É importante que as atividades sejam realizadas no prazo correto porque elas impactam tanto nas notas das outras pessoas, por causa da avaliação pelos pares, quanto na finalização das notas da disciplina.

* **Semana 16**: finalização dos trabalhos e divulgação dos materiais produzidos pela turma.
* **Semana 17**: avaliações por pares (preferencialmente, até **a data da última aula prevista no plano de ensino**).

---

> *"Nothing in life is to be feared, it is only to be understood.*  
> *Now is the time to understand more, so that we may fear less."*
>
> --- **Marie Skłodowska Curie** (1867 - 1934). :heart_eyes:  
> *Polish-French physcist and chemist.*
> *The first woman to win a Nobel Prize.*
> *The first person and the only woman to win the Nobel Prize twice.*  
> *The only person to win the Nobel Prize in two scientific fields.*
