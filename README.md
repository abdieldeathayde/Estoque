# Gestão de Estoque

Este é um projeto de frontend para um sistema de Gestão de Estoque, desenvolvido em HTML, CSS, JavaScript e integrado a um backend Java (Spring Boot) com banco de dados MySQL.

## Funcionalidades

- Listagem de produtos com paginação
- Busca e filtro por descrição ou ID
- Filtro de baixo estoque
- Ordenação por ID, nome, quantidade ou preço
- Adição, edição e exclusão de produtos via modal
- Estatísticas rápidas (total de produtos, valor total, em estoque, em falta)
- Comunicação com backend via HTTP (REST API)

## Tecnologias Utilizadas

- **Frontend:**
  - HTML5
  - CSS3 (TailwindCSS via CDN)
  - JavaScript puro (ES6+)
  - Font Awesome (ícones)
- **Backend:**
  - Java (Spring Boot)
  - MySQL

## Como Executar

1. **Backend:**
   - Certifique-se de que o backend Java (Spring Boot) está rodando em `http://localhost:8080` e que a API de produtos está disponível em `/api/produtos`.
   - O backend deve estar conectado a um banco MySQL e expor endpoints REST para CRUD de produtos.

2. **Frontend:**
   - Basta abrir o arquivo `index.html` em seu navegador.
   - O frontend irá consumir a API do backend automaticamente.

## Endpoints Esperados pelo Frontend

- `GET    /api/produtos` — Lista todos os produtos
- `POST   /api/produtos` — Adiciona um novo produto
- `PUT    /api/produtos/{id}` — Atualiza um produto existente
- `DELETE /api/produtos/{id}` — Remove um produto

## Estrutura Esperada do Produto (JSON)

```json
{
  "id": 1,
  "description": "Nome do Produto",
  "quantity": 10,
  "price": 99.90
}
```

## Observações

- O frontend não possui dependências de build, apenas abra o arquivo HTML.
- Para funcionamento completo, é necessário o backend Java rodando e acessível.
- Ajuste a URL da API no JavaScript caso o backend esteja em outro endereço.

## Autor

- Desenvolvido por Abdiel de Athayde
