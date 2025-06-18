# Spring Boot

- Framework que auxilia a criação de aplicações Java baseadas no Spring Framework.
- Define as configurações necessárias para execução: *just run*.
- Criação de um projeto: [Spring Initializr](https://start.spring.io/)
- Possíveis dependências:
  - Spring Boot DevTools: LiveReload, fast restart, dentre outros.
  - Spring Web: construção de aplicações Web/RESTful
  - Lombok: simplifica a escrita do código evitando repetições por meio de anotações (*@Getter, @Setter*, dentre outras).

- Estrutura do projeto (Java/Maven):

  - pom.xml: arquivo do projeto e dependências
  - src/main/java - classes (aplicação)
  - src/main/resources - arquivos de configuração, templates e estáticos (imagens, css, dentre outros)
  - application.properties - configurações
  - src/test - testes da aplicação

- `@SpringBootApplication`

  - @Configuration: define que a classe como origem/fonte de *beans*.
  - @EnableAutoConfiguration: ativa a configuração automática para o contexto de uma aplicação Spring.
  - @ComponentScan: especifica os pacotes / define a procura por componentes. Descobre e registra classes anotadas com @Component, @Service, @Repository, @Controller, or @Configuration.

- A anotação `@Bean` é utilizada para declarar e registrar instâncias no Spring container.

- **Bean** é um objeto que é instanciado, montado/definido e gerenciado pelo *Spring IoC (Inversion of Control) container*.

- *Spring Web*

  - `@RestController: @Controller + @ResponseBody`
