# 🚀 Linketinder - Backend Microservices

Projeto desenvolvido como parte do desafio da trilha de Spring Framework (Acelera ZG). O objetivo foi refatorar o backend monolítico para uma arquitetura de microsserviços distribuídos.

## 👨‍💻 Autor
**Nome:** Levi Dantas
**Stack:** Java, Spring Boot, PostgreSQL, Docker.

---

## 🏗️ Arquitetura

O sistema foi dividido em dois microsserviços independentes, cada um com seu próprio banco de dados, comunicando-se via API REST.

### 1. MS-Nucleo (Porta 8080)
- Responsável pelo **Core Business**.
- Gerencia **Candidatos**, **Empresas** e **Vagas**.
- Implementa a **Lógica de Match** (Curtida mútua entre Candidato e Empresa).
- **Banco de Dados:** `linketinder_nucleo` (PostgreSQL).

### 2. MS-Competencias (Porta 8081)
- Responsável pelo catálogo de habilidades.
- Gerencia as competências vinculadas aos candidatos.
- **Banco de Dados:** `linketinder_competencias` (PostgreSQL).

### 3. Frontend (Web)
- Interface desenvolvida em **HTML5/JS (Vanilla)** para validar a integração com as APIs.
- Consome os microsserviços via `fetch API`.

---

## 🛠️ Tecnologias Utilizadas
- **Java 21** & **Spring Boot 3**
- **Spring Data JPA** (Persistência)
- **PostgreSQL** (Banco de Dados)
- **Docker & Docker Compose** (Containerização dos Bancos)
- **Lombok** (Redução de boilerplate)
- **Bootstrap 5** (Estilização do Frontend)

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 17 ou 21 instalado.
- Docker e Docker Compose instalados.
- Maven (ou usar o wrapper `./mvnw` incluso).

### Passo 1: Subir os Bancos de Dados
Na raiz do projeto (onde está o `docker-compose.yml`), execute:
docker-compose up -d

Isso iniciará dois containers PostgreSQL nas portas 5432 e 5433.

Passo 2: Executar os Microsserviços
Você pode rodar via IDE (IntelliJ/Eclipse) executando a classe Main de cada projeto, ou via terminal:

Terminal 1 (Núcleo):

Bash
cd ms-nucleo
./mvnw spring-boot:run
Terminal 2 (Competências):

Bash
cd ms-competencias
./mvnw spring-boot:run
Passo 3: Acessar o Frontend
Navegue até a pasta Linketinder-Front e abra o arquivo vagas.html ou cadastro.html diretamente no seu navegador.

🔥 Funcionalidades Implementadas (Match)
A lógica de Match segue o modelo de "Double Opt-in":

O Candidato curte a vaga.

A Empresa curte o candidato.

O sistema processa e retorna "IT'S A MATCH" quando ambos os lados demonstram interesse.

Endpoint: POST /interacoes/curtir

## 🚧 Roadmap e Evolução do Projeto

Este projeto foi entregue como um **MVP (Minimum Viable Product)** para conclusão da trilha de Spring Framework (K4-T1). O foco principal foi estabelecer a **arquitetura de microsserviços**, a comunicação entre aplicações e a persistência isolada de dados.

Como parte do meu ciclo de aprendizado contínuo na aceleração, as seguintes melhorias já estão mapeadas para as próximas sprints de refatoração:

- [ ] **Implementação do Padrão DTO (Data Transfer Object):** Para desacoplar as entidades de domínio da camada de apresentação e aumentar a segurança dos dados trafegados.
- [ ] **Documentação com Swagger/OpenAPI:** Para facilitar o consumo das APIs pelo Frontend e outros desenvolvedores.
- [ ] **Spring Security & JWT:** Implementação de autenticação e autorização robusta entre os microsserviços.
- [ ] **Testes Automatizados:** Aplicação de testes unitários e de integração (JUnit/Mockito) para garantir a estabilidade das regras de negócio (especialmente o Match).
- [ ] **Tratamento Global de Erros:** Refinamento do `ControllerAdvice` para padronizar as respostas de exceção.

---

<img width="686" height="410" alt="image" src="https://github.com/user-attachments/assets/66c80639-b79f-4789-844d-d8dc7093ed12" />
<img width="684" height="447" alt="image" src="https://github.com/user-attachments/assets/f6c07665-7c55-4c6c-9136-a83279e9fb01" />

