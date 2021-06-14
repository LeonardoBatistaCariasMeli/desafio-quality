# Desafio-quality

O objetivo deste desafio é aplicar os conteúdos dados até o momento durante o Programa de aceleração MeLi (Git, Java,
Spring e suas respectivias ferramentas para testes unitários e de integração), com a finalidade de poder implementar uma
API REST e os testes/validações necessárias a partir de um enunciado proposto, uma especificação de requisitos e
documentação anexada.

## como rodar o projeto

1. Clonar o projeto:

```
 git@github.com:LeonardoBatistaCariasMeli/desafio-quality.git
```

2. Rodar o projeto pelo IntelliJ IDEA.

## Testar as Rotas

1. Para testar as rotas foi disponibilizado a collection do postman na raiz do projeto.
```
desafio-quality.postman_collection.json
```
2. E por fim acessar cada endpoint através do endereço:
```
 http://localhost
```
## Endpoints

## US-0001:
```
POST /home-evaluate/square-meters
```

Exemplo do payload:

````json
{
  "propertyName": "Casa",
  "propertyDistrict": "Adalgisa",
  "rooms": [
    {
      "roomName": "Cozinha",
      "roomWidth": 7.5,
      "roomLength": 18.5
    },
    {
      "roomName": "Banheiro",
      "roomWidth": 5.0,
      "roomLength": 5.0
    },
    {
      "roomName": "Sala de estar",
      "roomWidth": 15.0,
      "roomLength": 7.5
    },
    {
      "roomName": "Quarto casal",
      "roomWidth": 15.0,
      "roomLength": 15.0
    },
    {
      "roomName": "Quarto infantil",
      "roomWidth": 7.5,
      "roomLength": 10.0
    }
  ]
}
````

Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| propertyName | String | Nome de identificação da propriedade |
| propertyDistrict | String | Nome de identificação do bairro |
| rooms | List | Lista de todos os comodos da propriedade |
| roomName | String | Nome de identificação do comodo |
| roomWidth | Double | Largura do comodo |
| roomLength | Double | Altura do comodo |

Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Requisição realizada com sucesso |
| 422 | UNPROCESSABLE_ENTITY | Validation error |

Retorno :

````json
{
  "propertyName": "Casa",
  "squareMeters": 512.5
}
````
Paramêtros De retorno :

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| propertyName | Strint | Nome de identificação da propriedade |
| squareMeters | Double | Tamanho em metros quadrados da propriedade |

## US-0002:
```
POST /home-evaluate/property-price
```

Exemplo do payload:

````json
{
  "propertyName": "Casa",
  "propertyDistrict": "Adalgisa",
  "rooms": [
    {
      "roomName": "Cozinha",
      "roomWidth": 7.5,
      "roomLength": 18.5
    },
    {
      "roomName": "Banheiro",
      "roomWidth": 5.0,
      "roomLength": 5.0
    },
    {
      "roomName": "Sala de estar",
      "roomWidth": 15.0,
      "roomLength": 7.5
    },
    {
      "roomName": "Quarto casal",
      "roomWidth": 15.0,
      "roomLength": 15.0
    },
    {
      "roomName": "Quarto infantil",
      "roomWidth": 7.5,
      "roomLength": 10.0
    }
  ]
}
````

Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| propertyName | String | Nome de identificação da propriedade |
| propertyDistrict | String | Nome de identificação do bairro |
| rooms | List | Lista de todos os comodos da propriedade |
| roomName | String | Nome de identificação do comodo |
| roomWidth | Double | Largura do comodo |
| roomLength | Double | Altura do comodo |

Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Requisição realizada com sucesso |
| 404 | NOT_FOUND | This neighborhood not exists |
| 422 | UNPROCESSABLE_ENTITY | Validation error |

Retorno :

````json
{
  "propertyName": "Casa",
  "propertyPrice": 57625.0
}
````
Paramêtros De retorno :

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| propertyName | String | Nome de identificação da propriedade |
| propertyPrice | Double | Valor total da propriedade |

## US-0003:
```
POST /home-evaluate/greater-room
```

Exemplo do payload:

````json
{
  "propertyName": "Casa",
  "propertyDistrict": "Adalgisa",
  "rooms": [
    {
      "roomName": "Cozinha",
      "roomWidth": 7.5,
      "roomLength": 18.5
    },
    {
      "roomName": "Banheiro",
      "roomWidth": 5.0,
      "roomLength": 5.0
    },
    {
      "roomName": "Sala de estar",
      "roomWidth": 15.0,
      "roomLength": 7.5
    },
    {
      "roomName": "Quarto casal",
      "roomWidth": 15.0,
      "roomLength": 15.0
    },
    {
      "roomName": "Quarto infantil",
      "roomWidth": 7.5,
      "roomLength": 10.0
    }
  ]
}
````

Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| propertyName | String | Nome de identificação da propriedade |
| propertyDistrict | String | Nome de identificação do bairro |
| rooms | List | Lista de todos os comodos da propriedade |
| roomName | String | Nome de identificação do comodo |
| roomWidth | Double | Largura do comodo |
| roomLength | Double | Altura do comodo |

Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Requisição realizada com sucesso |
| 422 | UNPROCESSABLE_ENTITY | Validation error |

Retorno :

````json
{
  "roomName": "Quarto casal",
  "roomWidth": 15.0,
  "roomLength": 15.0,
  "squareMeters": 225.0
}
````
Paramêtros De retorno :

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| roomName | String | Nome de identificação do comodo |
| roomWidth | Double | Largura do comodo |
| roomLength | Double | Altura do comodo |
| squareMeters | Double | Total em metros quadrados do comodo |

## US-0004:
```
POST /home-evaluate/square-meters-rooms
```

Exemplo do payload:

````json
{
  "propertyName": "Casa",
  "propertyDistrict": "Adalgisa",
  "rooms": [
    {
      "roomName": "Cozinha",
      "roomWidth": 7.5,
      "roomLength": 18.5
    },
    {
      "roomName": "Banheiro",
      "roomWidth": 5.0,
      "roomLength": 5.0
    },
    {
      "roomName": "Sala de estar",
      "roomWidth": 15.0,
      "roomLength": 7.5
    },
    {
      "roomName": "Quarto casal",
      "roomWidth": 15.0,
      "roomLength": 15.0
    },
    {
      "roomName": "Quarto infantil",
      "roomWidth": 7.5,
      "roomLength": 10.0
    }
  ]
}
````

Parametros:

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| propertyName | String | Nome de identificação da propriedade |
| propertyDistrict | String | Nome de identificação do bairro |
| rooms | List | Lista de todos os comodos da propriedade |
| roomName | String | Nome de identificação do comodo |
| roomWidth | Double | Largura do comodo |
| roomLength | Double | Altura do comodo |

Retorno :

| Código | nome | Descrição |
| ----------- | ---- | --------- |
| 200 | OK | Requisição realizada com sucesso |
| 422 | UNPROCESSABLE_ENTITY | Validation error |

Retorno :

````json
[
  {
    "roomName": "Cozinha",
    "roomWidth": 7.5,
    "roomLength": 18.5,
    "squareMeters": 138.75
  },
  {
    "roomName": "Banheiro",
    "roomWidth": 5.0,
    "roomLength": 5.0,
    "squareMeters": 25.0
  },
  ...
]
````
Paramêtros De retorno :

| Parametro | Tipo | Descrição |
| ----------- | ---- | --------- |
| roomName | String | Nome de identificação do comodo |
| roomWidth | Double | Largura do comodo |
| roomLength | Double | Altura do comodo |
| squareMeters | Double | Total em metros quadrados do comodo |
