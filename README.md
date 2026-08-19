# Sistema de Gestão de Pedidos — E-commerce

> Atividade desafiadora Unidade Curricular **Desenvolvimento Back-end**
> Curso Superior de Tecnologia em Análise e Desenvolvimento de Sistemas — Turma CSTADS601

## Equipe / Squad

| Nome | Quando foi responsável do dia |
|---|---|
| _(Eduardo Bruno Coppi)_ | Aulas: 01 |
| _(Beatriz Cardoso Rocha)_ | Aulas: 03 |
| _(João Paulo Oliveira)_ | Aulas: 02 |

## Descrição do desafio

_(Este projeto consiste no desenvolvimento de um sistema completo de gestão de pedidos para um e-commerce, permitindo o cadastro e o gerenciamento de produtos, clientes, pedidos e pagamentos de forma organizada e eficiente.)_

## Divisão do Trabalho

| Nome | Trabalho Responsável |
|---|---|
| _(Eduardo Bruno Coppi)_ | Cliente |
| _(Beatriz Cardoso Rocha)_ | Pedido, Pagamento |
| _(João Paulo Oliveira)_ | Produto |

## Funcionalidades previstas

- [ ] Cadastro e gerenciamento de produtos
- [ ] Cadastro e gerenciamento de clientes
- [ ] Criação e gerenciamento de pedidos
- [ ] Processamento de pagamentos (cartão, boleto, Pix)
- [ ] Testes automatizados (unitários e de integração)
- [ ] Pipeline de CI/CD
- [ ] API REST para consumo por um front-end

## Tecnologias

- Java
- Maven
- Git / GitHub
- _(demais tecnologias serão adicionadas ao longo do semestre: JUnit, Spring Boot, banco de
  dados, GitHub Actions...)_

## Estrutura de pastas

```
ecommerce-pedidos-NOMEDASQUAD/
ecommerce/
├── Back-end/
│   ├── src/
│   │   ├── main/
│   │   │   └── java/
│   │   │       └── com/
│   │   │           └── senai/
│   │   │               └── ecommerce/
│   │   │                   ├── modelo/
│   │   │                   ├── servico/
│   │   │                   ├── repositorio/
│   │   │                   └── util/
│   │   └── test/
│   │       └── java/
│   │           └── com/
│   │               └── senai/
│   │                   └── ecommerce/
│   │
│   ├── pom.xml
│   └── README.md
│
├── Front-end/
│
├── README.md
│
└── .gitignore
```

## Como rodar o projeto

_(Preencher a partir das próximas aulas, conforme o projeto evoluir.)_

## Roadmap do projeto (por aula)

| Aula | Entrega |
|---|---|
| 01 | Repositório criado, estruturado, com README e commit inicial |
| 02 | Fluxo de branches e primeiro Pull Request revisado |
| 03 | Classe utilitária (Utils) do domínio |
| 04 | Classes de domínio inicial (Produto, Cliente, Pedido, ItemPedido) |
| 05 | Encapsulamento e abstração aplicados |
| 06 | Hierarquia de formas de pagamento (herança) |
| 07 | Relacionamentos entre classes do domínio |
| 08 | Módulo de pagamento polimórfico |
| 09 | Tratamento de exceções |
| 10 | Suíte de testes unitários |
| 11 | Suíte de testes de integração + relatório de cobertura |
| 12 | Persistência: conexão, Create e Read |
| 13 | Persistência: Update, Delete e padrão DAO/Repository |
| 14 | Migração para Spring Boot |
| 15 | API REST + pipeline CI/CD |
| 16 | Entrega final, documentação e apresentação |

## Combinado da equipe (ética e convivência)

1. _(Respeitar a opinião de todos)_
2. _(Avisar a equipe caso haja algum imprevisto)_
3. _(Avisar a equipe caso seja necessário alterar o código alheio)_

## Licença

Projeto acadêmico — Faculdade de Tecnologia SENAI "Antonio Adolpho Lobbe".
