# Desafio Backend Empréstimo
Este projeto foi feito para estudo e aperfeiçoamento das ferramentas Java, Spring. A ideia partiu como uma proposta de solução ao Desafio de Empréstimo do repositório do Backend Brasil.

## Sobre o desafio
O desafio propõe a construção de uma API web que irá receber uma requisição POST com os dados de um determinado cliente, estes dados passarão por regras de negócio que determinarão quais empréstimos estão disponíveis para o cliente. O desafio com maior detalhes você pode encontrar no repositório do [Backend Brasil](https://github.com/backend-br/desafios).

### Regras
- Conceder o empréstimo pessoal se o salário do cliente for igual ou inferior a R$ 3000.
- Conceder o empréstimo pessoal se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver menos de 30 anos e residir em São Paulo (SP).
- Conceder o empréstimo consignado se o salário do cliente for igual ou superior a R$ 5000.
- Conceder o empréstimo com garantia se o salário do cliente for igual ou inferior a R$ 3000.
- Conceder o empréstimo com garantia se o salário do cliente estiver entre R$ 3000 e R$ 5000, se o cliente tiver menos de 30 anos e residir em São Paulo (SP).

### Exemplo de Requisição:
- Rota "/api/v1/loan"

```json
{
  "age": 26,
  "cpf": "275.484.389-23",
  "name": "Vuxaywua Zukiagou",
  "income": 7000.00,
  "location": "SP"
}
```

### Exemplo de Responsta:

```json
{
  "customer": "Vuxaywua Zukiagou",
  "loans": [
    {
      "type": "PERSONAL",
      "interest_rate": 4
    },
    {
      "type": "GUARANTEED",
      "interest_rate": 3
    },
    {
      "type": "CONSIGNMENT",
      "interest_rate": 2
    }
  ]
}
```
