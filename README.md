# 🛒 MyEcommerce Backend

API RESTful completa para sistema de e-commerce desenvolvida com Spring Boot, implementando autenticação OAuth2, autorização baseada em roles e operações CRUD para gerenciamento de produtos, categorias, pedidos e usuários.

## Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Funcionalidades](#funcionalidades)
- [Arquitetura](#arquitetura)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Como Executar](#como-executar)
- [Endpoints da API](#endpoints-da-api)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Segurança](#segurança)
- [Banco de Dados](#banco-de-dados)

## Sobre o Projeto

O **MyEcommerce Backend** é uma API REST robusta e escalável para gerenciamento de operações de e-commerce. O sistema oferece funcionalidades completas para administração de produtos, categorias, pedidos e usuários, com sistema de autenticação e autorização baseado em OAuth2 e Spring Security.

### Principais Características

- ✅ Autenticação e autorização com OAuth2 e JWT
- ✅ Sistema de roles (ADMIN e CLIENT)
- ✅ CRUD completo de produtos com paginação e busca
- ✅ Gerenciamento de categorias
- ✅ Sistema de pedidos com itens e pagamentos
- ✅ Validação de dados com Bean Validation
- ✅ Tratamento centralizado de exceções
- ✅ Banco de dados H2 para testes
- ✅ Configuração CORS para integração com frontend

## Tecnologias Utilizadas

### Core
- **Java 17** - Linguagem de programação
- **Spring Boot 3.2.5** - Framework principal
- **Maven** - Gerenciamento de dependências

### Spring Framework
- **Spring Data JPA** - Persistência de dados
- **Spring Web** - API REST
- **Spring Security** - Segurança e autenticação
- **Spring OAuth2 Authorization Server** - Servidor de autorização OAuth2
- **Spring OAuth2 Resource Server** - Servidor de recursos OAuth2

### Banco de Dados
- **H2 Database** - Banco de dados em memória para testes
- **Hibernate** - ORM (Object-Relational Mapping)

### Validação e Segurança
- **Jakarta Validation API 3.0.2** - Validação de dados
- **Hibernate Validator 8.0.0** - Implementação de validação
- **JWT (JSON Web Tokens)** - Tokens de autenticação

### Testes
- **Spring Boot Starter Test** - Framework de testes
- **Spring Security Test** - Testes de segurança

## Funcionalidades

### Autenticação e Autorização
- Sistema de autenticação OAuth2 com JWT
- Grant type customizado para autenticação por senha
- Autorização baseada em roles (ROLE_ADMIN, ROLE_CLIENT)
- Endpoint para obter informações do usuário autenticado

### Gerenciamento de Produtos
- Listagem de produtos com paginação
- Busca de produtos por nome
- Visualização detalhada de produto
- Criação de produtos (apenas ADMIN)
- Atualização de produtos (apenas ADMIN)
- Exclusão de produtos (apenas ADMIN)

### Gerenciamento de Categorias
- Listagem de todas as categorias
- Associação de produtos com categorias

### Gerenciamento de Pedidos
- Criação de pedidos (CLIENT)
- Visualização de pedidos (ADMIN e CLIENT)
- Sistema de itens de pedido
- Integração com pagamentos
- Status de pedidos (WAITING_PAYMENT, PAID, SHIPPED, DELIVERED, CANCELED)

### Gerenciamento de Usuários
- Perfil do usuário autenticado
- Sistema de roles e permissões
- Dados de cliente associados ao usuário

## Arquitetura

O projeto segue uma arquitetura em camadas bem definida:

```
┌─────────────────────────────────────┐
│         Controllers                 │  ← Camada de apresentação (REST API)
├─────────────────────────────────────┤
│         Services                    │  ← Camada de lógica de negócio
├─────────────────────────────────────┤
│         Repositories                │  ← Camada de acesso a dados
├─────────────────────────────────────┤
│         Entities                    │  ← Camada de modelo de dados
└─────────────────────────────────────┘
```

### Padrões Utilizados
- **DTO (Data Transfer Object)** - Transferência de dados entre camadas
- **Repository Pattern** - Abstração de acesso a dados
- **Service Layer** - Encapsulamento de lógica de negócio
- **Exception Handler** - Tratamento centralizado de exceções

## Pré-requisitos

Antes de começar, certifique-se de ter instalado em sua máquina:

- **Java JDK 17** ou superior
- **Maven 3.6+** (ou use o Maven Wrapper incluído no projeto)
- **Git** (para clonar o repositório)
- **IDE** (IntelliJ IDEA, Eclipse, VS Code, etc.) - opcional

### Verificar instalações

```bash
# Verificar versão do Java
java -version

# Verificar versão do Maven
mvn -version
```

## Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/MatheusFariasRS/myEcommerce-Backend.git
cd myEcommerce-Backend
```

### 2. Compile o projeto

```bash
# Usando Maven
mvn clean install

# Ou usando Maven Wrapper (Linux/Mac)
./mvnw clean install

# Ou usando Maven Wrapper (Windows)
mvnw.cmd clean install
```

## ⚙️ Configuração

### Variáveis de Ambiente

O projeto utiliza variáveis de ambiente para configurações sensíveis. Você pode defini-las no sistema ou criar um arquivo `.env`:

```properties
# OAuth2 Client Credentials
CLIENT_ID=myclientid
CLIENT_SECRET=myclientsecret

# JWT Configuration
JWT_DURATION=86400

# CORS Origins
CORS_ORIGINS=http://localhost:3000,http://localhost:5173
```

### Arquivo application.properties

O arquivo principal de configuração está em `src/main/resources/application.properties`:

```properties
spring.application.name=myecommerce
spring.profiles.active=test
spring.jpa.open-in-view=false

security.client-id=${CLIENT_ID:myclientid}
security.client-secret=${CLIENT_SECRET:myclientsecret}
security.jwt.duration=${JWT_DURATION:86400}

cors.origins=${CORS_ORIGINS:http://localhost:3000,http://localhost:5173}
```

### Perfil de Teste (application-test.properties)

Configurações para ambiente de teste com H2:

```properties
# H2 Database
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Como Executar

### Opção 1: Usando Maven

```bash
mvn spring-boot:run
```

### Opção 2: Usando Maven Wrapper

```bash
# Linux/Mac
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

### Opção 3: Executando o JAR

```bash
# Compilar o projeto
mvn clean package

# Executar o JAR gerado
java -jar target/myecommerce-0.0.1-SNAPSHOT.jar
```

### Opção 4: Pela IDE

Abra o projeto na sua IDE favorita e execute a classe principal:
```
src/main/java/com/ecommerce/myecommerce/MyecommerceApplication.java
```

### Verificar se está funcionando

Após iniciar a aplicação, acesse:
- **API Base URL**: http://localhost:8080
- **H2 Console**: http://localhost:8080/h2-console

## Endpoints da API

### Autenticação

#### Obter Token de Acesso
```http
POST /oauth2/token
Content-Type: application/x-www-form-urlencoded

grant_type=password
&username=maria@gmail.com
&password=123456
&client_id=myclientid
&client_secret=myclientsecret
```

**Resposta:**
```json
{
  "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
  "token_type": "Bearer",
  "expires_in": 86400
}
```

### Usuários

#### Obter Usuário Autenticado
```http
GET /users/me
Authorization: Bearer {token}
```

**Resposta:**
```json
{
  "id": 1,
  "name": "Maria Brown",
  "email": "maria@gmail.com",
  "phone": "988888888",
  "birthDate": "2001-07-25",
  "roles": ["ROLE_CLIENT"]
}
```

### Produtos

#### Listar Produtos (Paginado)
```http
GET /products?page=0&size=12&name=PC
```

**Resposta:**
```json
{
  "content": [
    {
      "id": 1,
      "name": "PC Gamer",
      "price": 1200.0,
      "imgUrl": "https://images.unsplash.com/photo-1626218174358-7769486c4b79?fm=jpg&q=60&w=3000&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8Z2FtaW5nJTIwcGN8ZW58MHx8MHx8fDA%3D"
    }
  ],
  "pageable": {...},
  "totalPages": 5,
  "totalElements": 50
}
```

#### Buscar Produto por ID
```http
GET /products/{id}
```

**Resposta:**
```json
{
  "id": 1,
  "name": "PC Gamer",
  "description": "Computador de alta performance...",
  "price": 1200.0,
  "imgUrl": "https://i.ytimg.com/vi/4AG3AAKsFhI/maxresdefault.jpg",
  "categories": [
    {
      "id": 3,
      "name": "Computadores"
    }
  ]
}
```

#### Criar Produto (ADMIN)
```http
POST /products
Authorization: Bearer {admin_token}
Content-Type: application/json

{
  "name": "Notebook Dell",
  "description": "Notebook profissional",
  "price": 3500.0,
  "imgUrl": "https://i.dell.com/is/image/DellContent/content/dam/ss2/product-images/dell-client-products/notebooks/dell-pro/pc16250/media-gallery/gray/hd-fhd/laptop-dell-pro-pc16250-gy-hd-fhd-gallery-1.psd?fmt=png-alpha&pscan=auto&scl=1&hei=320&wid=531&qlt=100,1&resMode=sharp2&size=531,320&chrss=full",
  "categories": [
    {"id": 3}
  ]
}
```

#### Atualizar Produto (ADMIN)
```http
PUT /products/{id}
Authorization: Bearer {admin_token}
Content-Type: application/json

{
  "name": "Notebook Dell Atualizado",
  "description": "Nova descrição",
  "price": 3200.0,
  "imgUrl": "https://i.dell.com/is/image/DellContent/content/dam/ss2/product-images/dell-client-products/notebooks/dell-plus/db16250/media-gallery/fpr/notebook-db16250nt-fpr-bl-gallery-2.psd?fmt=png-alpha&pscan=auto&scl=1&hei=804&wid=979&qlt=100,1&resMode=sharp2&size=979,804&chrss=full",
  "categories": [
    {"id": 3}
  ]
}
```

#### Deletar Produto (ADMIN)
```http
DELETE /products/{id}
Authorization: Bearer {admin_token}
```

### Categorias

#### Listar Todas as Categorias
```http
GET /categories
```

**Resposta:**
```json
[
  {
    "id": 1,
    "name": "Livros"
  },
  {
    "id": 2,
    "name": "Eletrônicos"
  },
  {
    "id": 3,
    "name": "Computadores"
  }
]
```

### Pedidos

#### Criar Pedido (CLIENT)
```http
POST /orders
Authorization: Bearer {client_token}
Content-Type: application/json

{
  "items": [
    {
      "productId": 1,
      "quantity": 2
    },
    {
      "productId": 3,
      "quantity": 1
    }
  ]
}
```

**Resposta:**
```json
{
  "id": 1,
  "moment": "2025-11-26T10:30:00Z",
  "status": "WAITING_PAYMENT",
  "client": {
    "id": 1,
    "name": "Maria Brown"
  },
  "payment": null,
  "items": [
    {
      "productId": 1,
      "name": "PC Gamer",
      "price": 1200.0,
      "quantity": 2,
      "subTotal": 2400.0
    }
  ],
  "total": 3650.0
}
```

#### Buscar Pedido por ID (ADMIN ou CLIENT)
```http
GET /orders/{id}
Authorization: Bearer {token}
```

## 📁 Estrutura do Projeto

```
myEcommerce-Backend/
│
├── src/
│   ├── main/
│   │   ├── java/com/ecommerce/myecommerce/
│   │   │   ├── config/                          # Configurações
│   │   │   │   ├── AuthorizationServerConfig.java
│   │   │   │   ├── ResourceServerConfig.java
│   │   │   │   └── customgrant/                 # Grant type customizado
│   │   │   │       ├── CustomPasswordAuthenticationConverter.java
│   │   │   │       ├── CustomPasswordAuthenticationProvider.java
│   │   │   │       ├── CustomPasswordAuthenticationToken.java
│   │   │   │       └── CustomUserAuthorities.java
│   │   │   │
│   │   │   ├── controllers/                     # Controladores REST
│   │   │   │   ├── CategoryController.java
│   │   │   │   ├── OrderController.java
│   │   │   │   ├── ProductController.java
│   │   │   │   ├── UserController.java
│   │   │   │   └── handlers/
│   │   │   │       └── ControllerExceptionHandler.java
│   │   │   │
│   │   │   ├── dto/                             # Data Transfer Objects
│   │   │   │   ├── CategoryDTO.java
│   │   │   │   ├── ClientDTO.java
│   │   │   │   ├── CustomError.java
│   │   │   │   ├── FieldMessage.java
│   │   │   │   ├── OrderDTO.java
│   │   │   │   ├── OrderItemDTO.java
│   │   │   │   ├── PaymentDTO.java
│   │   │   │   ├── ProductDTO.java
│   │   │   │   ├── ProductMinDTO.java
│   │   │   │   ├── UserDTO.java
│   │   │   │   └── ValidationError.java
│   │   │   │
│   │   │   ├── entities/                        # Entidades JPA
│   │   │   │   ├── Category.java
│   │   │   │   ├── Order.java
│   │   │   │   ├── OrderItem.java
│   │   │   │   ├── OrderItemPK.java
│   │   │   │   ├── OrderStatus.java
│   │   │   │   ├── Payment.java
│   │   │   │   ├── Product.java
│   │   │   │   ├── Role.java
│   │   │   │   └── User.java
│   │   │   │
│   │   │   ├── projection/                      # Projeções JPA
│   │   │   │   └── UserDetailsProjection.java
│   │   │   │
│   │   │   ├── repositories/                    # Repositórios JPA
│   │   │   │   ├── CategoryRepository.java
│   │   │   │   ├── OrderItemRepository.java
│   │   │   │   ├── OrderRepository.java
│   │   │   │   ├── ProductRepository.java
│   │   │   │   └── UserRepository.java
│   │   │   │
│   │   │   ├── services/                        # Serviços de negócio
│   │   │   │   ├── AuthService.java
│   │   │   │   ├── CategoryService.java
│   │   │   │   ├── OrderService.java
│   │   │   │   ├── ProductService.java
│   │   │   │   ├── UserService.java
│   │   │   │   └── exceptions/
│   │   │   │       ├── DatabaseException.java
│   │   │   │       ├── ForbiddenException.java
│   │   │   │       └── ResourceNotFoundException.java
│   │   │   │
│   │   │   └── MyecommerceApplication.java      # Classe principal
│   │   │
│   │   └── resources/
│   │       ├── application.properties            # Configurações principais
│   │       ├── application-test.properties       # Configurações de teste
│   │       ├── import.sql                        # Dados iniciais (seed)
│   │       └── META-INF/
│   │           └── additional-spring-configuration-metadata.json
│   │
│   └── test/
│       └── java/com/ecommerce/myecommerce/
│           └── MyecommerceApplicationTests.java
│
├── .gitignore
├── .gitattributes
├── mvnw                                          # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                                      # Maven Wrapper (Windows)
└── pom.xml                                       # Configuração Maven
```

### Descrição das Camadas

#### 📂 config/
Contém todas as configurações do Spring Security, OAuth2 e CORS. Inclui implementação customizada de grant type para autenticação.

#### 📂 controllers/
Camada de apresentação que expõe os endpoints REST. Cada controller é responsável por um recurso específico da API.

#### 📂 dto/
Objetos de transferência de dados que trafegam entre cliente e servidor, garantindo encapsulamento das entidades.

#### 📂 entities/
Entidades JPA que representam as tabelas do banco de dados. Contém as regras de mapeamento objeto-relacional.

#### 📂 repositories/
Interfaces que estendem JpaRepository, fornecendo métodos de acesso a dados com Spring Data JPA.

#### 📂 services/
Camada de lógica de negócio. Contém as regras de negócio e orquestra as operações entre controllers e repositories.

## Segurança

### Autenticação OAuth2

O projeto implementa um servidor de autorização OAuth2 completo com:

- **Grant Type**: Password (Resource Owner Password Credentials)
- **Token Type**: JWT (JSON Web Token)
- **Token Duration**: Configurável via variável de ambiente (padrão: 24 horas)

### Autorização Baseada em Roles

O sistema possui dois níveis de acesso:

#### ROLE_CLIENT
- Visualizar produtos e categorias
- Criar pedidos
- Visualizar próprios pedidos
- Acessar próprio perfil

#### ROLE_ADMIN
- Todas as permissões de CLIENT
- Criar, atualizar e deletar produtos
- Visualizar todos os pedidos
- Gerenciar usuários

### Endpoints Protegidos

```java
// Exemplo de proteção de endpoint
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@PostMapping
public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto)

@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
@GetMapping(value = "/{id}")
public ResponseEntity<OrderDTO> findById(@PathVariable Long id)
```

### CORS

Configuração de CORS permite requisições de origens específicas, configuráveis via variável de ambiente:

```properties
cors.origins=http://localhost:3000,http://localhost:5173
```

## Banco de Dados

### H2 Database (Ambiente de Teste)

O projeto utiliza H2, um banco de dados em memória, ideal para desenvolvimento e testes.

#### Acessar H2 Console

1. Inicie a aplicação
2. Acesse: http://localhost:8080/h2-console
3. Use as credenciais:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Username**: `sa`
   - **Password**: *(deixe em branco)*

### Modelo de Dados

```
┌─────────────┐       ┌──────────────┐       ┌─────────────┐
│   User      │       │    Order     │       │   Product   │
├─────────────┤       ├──────────────┤       ├─────────────┤
│ id          │───┐   │ id           │   ┌───│ id          │
│ name        │   │   │ moment       │   │   │ name        │
│ email       │   │   │ status       │   │   │ description │
│ password    │   │   │ client_id    │───┘   │ price       │
│ phone       │   │   │ payment_id   │       │ img_url     │
│ birth_date  │   │   └──────────────┘       └─────────────┘
└─────────────┘   │          │                      │
                  │          │                      │
┌─────────────┐   │   ┌──────────────┐       ┌─────────────┐
│   Role      │   │   │  OrderItem   │       │  Category   │
├─────────────┤   │   ├──────────────┤       ├─────────────┤
│ id          │   │   │ order_id     │       │ id          │
│ authority   │   │   │ product_id   │       │ name        │
└─────────────┘   │   │ quantity     │       └─────────────┘
       │          │   │ price        │              │
       │          │   └──────────────┘              │
       │          │                                 │
       └──────────┴─────────────────────────────────┘
              (Relacionamentos Many-to-Many)
```

### Dados Iniciais (Seed)

O arquivo `import.sql` contém dados iniciais para teste:

- **3 Categorias**: Livros, Eletrônicos, Computadores
- **25 Produtos**: Diversos produtos de exemplo
- **Usuários**: Admin e clientes de teste
- **Roles**: ROLE_ADMIN e ROLE_CLIENT

### Migração para Produção

Para ambiente de produção, recomenda-se:

1. **PostgreSQL** ou **MySQL** como banco de dados
2. Criar novo perfil em `application-prod.properties`
3. Configurar datasource apropriado
4. Usar Flyway ou Liquibase para migrations

Exemplo de configuração PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/myecommerce
spring.datasource.username=postgres
spring.datasource.password=sua_senha
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=validate
```

## Testes

### Executar Testes

```bash
# Executar todos os testes
mvn test

# Executar testes com relatório de cobertura
mvn test jacoco:report
```

### Estrutura de Testes

O projeto inclui:
- Testes unitários de serviços
- Testes de integração de controllers
- Testes de segurança

## Validações

O projeto utiliza Bean Validation para garantir integridade dos dados:

```java
// Exemplo de validações em DTOs
public class ProductDTO {
    @NotBlank(message = "Campo obrigatório")
    @Size(min = 3, max = 80, message = "Nome deve ter entre 3 e 80 caracteres")
    private String name;
    
    @NotNull(message = "Campo obrigatório")
    @Positive(message = "Preço deve ser positivo")
    private Double price;
    
    @Size(min = 10, message = "Descrição deve ter no mínimo 10 caracteres")
    private String description;
}
```

## Tratamento de Erros

### Exceções Customizadas

- **ResourceNotFoundException**: Recurso não encontrado (404)
- **DatabaseException**: Erro de integridade do banco (400)
- **ForbiddenException**: Acesso negado (403)

### Formato de Resposta de Erro

```json
{
  "timestamp": "2025-11-26T10:30:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Recurso não encontrado",
  "path": "/products/999"
}
```

### Erros de Validação

```json
{
  "timestamp": "2025-11-26T10:30:00Z",
  "status": 422,
  "error": "Unprocessable Entity",
  "message": "Dados inválidos",
  "errors": [
    {
      "fieldName": "name",
      "message": "Campo obrigatório"
    },
    {
      "fieldName": "price",
      "message": "Preço deve ser positivo"
    }
  ]
}
```


### Padrões de Código

- Siga as convenções de código Java
- Mantenha a cobertura de testes
- Documente novas funcionalidades
- Use commits semânticos



**Desenvolvido com ☕ e Java**
