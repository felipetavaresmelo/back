# X Project

## Preparando ambiente de desenvolvimento

---

### Pre-requisitos:

 - Docker instalado.
 - Docker Compose instalado.

---
### Docker Compose
Executar o comando abaixo a partir da pasta *./app/docker/local/*, se necessário utilizar super usuário.

    docker-compose up -d

Ou levantar os serviços através do plugin: https://plugins.jetbrains.com/plugin/7724-docker

---
#### [Mongo Express](https://github.com/mongo-express/mongo-express)
- Abrir interface web: http://localhost:9081

#### [pgAdmin (PostgreSQL)](https://www.pgadmin.org)
- Abrir interface web: http://localhost:5050/
- User: admin@admin.com
- Senha: root

Configurações iniciais:
Após login no pgAdmin, seguir os passos abaixo:

- Criar base de dados manualmente:
  - Abrir o pgAdmin
  - Abrir a aba SQL e executar o comando abaixo:
    ```sql
    create database xprojectdb;
    ```
- Abrir Servers > Create > Server
  - General:
    - Name: xprojectdb
  - Connection:
    - Host name/address: 127.0.0.1
    - Port: 5432
    - Maintenance database: xprojectdb
    - Username: postgres
    - Password: postgres

#### [Redis Commander](https://www.npmjs.com/package/redis-commander)
- Abrir interface web: http://localhost:8081

---

## Subir a aplicação

 app > src > main > java > Application.java > Run 'Application main()'

---

## Swagger UI

[Swagger UI da Aplicação](http://localhost:8080/swagger-ui/index.html)

