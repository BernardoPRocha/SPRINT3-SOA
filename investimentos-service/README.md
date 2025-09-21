# 📊 Investimentos Service (Sprint 3)

Projeto da Sprint 3 - Arquitetura Orientada a Serviços e Web Services.

## 📌 Integrantes do Grupo
1. Bernardo Pinto Rocha - RM99209  
2. Gabriel Diegues - RM550788  
3. Luiza Cristina - RM99367  
4. Pedro Palladino - RM551180  
5. Renato Izumi - RM99242

   
## 🚀 Funcionalidades
- Cadastro e listagem de clientes.
- Validações de entrada.
- API REST com camadas (Controller, Service, Repository).
- Banco de dados em memória (H2).
- Documentação automática com Swagger.

## 🛠️ Tecnologias
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Swagger/OpenAPI

## ▶️ Como Executar
```bash
mvn spring-boot:run
```

Acesse:
- API: `http://localhost:8080/clientes`
- Swagger: `http://localhost:8080/swagger-ui.html`

## 📌 Exemplos
### Criar Cliente
```http
POST /clientes
Content-Type: application/json

{
  "nome": "Maria",
  "perfilInvestidor": "CONSERVADOR",
  "liquidez": 10000,
  "objetivo": "Reserva de emergência"
}
```

### Listar Clientes
```http
GET /clientes
```
