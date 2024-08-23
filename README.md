<h3 align="center">
  Desafio Backend do BTG Pactual
</h3>

<p align="center">

  <img alt="Language: Java" src="https://img.shields.io/badge/language-java-green">

</p>


## Desafio
1. Modele e implemente uma base de dados (PostgreSQL, MySQL, MongoDB).
2. Crie um micro serviço que consuma dados de uma fila RabbitMQ e grave os dados para conseguir listar as informações:

   - Valor total do pedido
   - Quantidade de Pedidos por Cliente
   - Lista de pedidos realizados por cliente

Exemplo da mensagem que deve ser consumida:

```
   {
       "codigoPedido": 1001,
       "codigoCliente":1,
       "itens": [
           {
               "produto": "lápis",
               "quantidade": 100,
               "preco": 1.10
           },
           {
               "produto": "caderno",
               "quantidade": 10,
               "preco": 1.00
           }
       ]
   }
```


3. Crie uma API REST, em que permita o consultar as seguintes informações:
   - Valor total do pedido
   - Quantidade de Pedidos por Cliente
   - Lista de pedidos realizados por cliente
   


## Banco de dados
- Foi utilizado [MongoDB Compass](https://www.mongodb.com/products/tools/compass)

## Testes de API
- Foi utilizado [Insomnia](https://insomnia.rest/)

## :rocket: Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data MongoDB
* RabbitMQ
* Docker
