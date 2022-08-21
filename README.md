# X Project

## Preparando ambiente de desenvolvimento

---

### Pre-requisitos:

 - Docker instalado.
```sh
sudo apt update && sudo apt upgrade -y
sudo apt install apt-transport-https ca-certificates curl software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
sudo apt update
apt-cache policy docker-ce
sudo systemctl status docker
```

 - Docker Compose instalado.
```sh
sudo curl -L "https://github.com/docker/compose/releases/download/1.27.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
docker-compose --version
```

[Fonte](https://www.bmc.com/blogs/mongodb-docker-container/)

---
### Docker Compose
Executar o comando abaixo a partir da pasta *./app/docker/local/*, se necessário utilizar super usuário.

```shell
docker-compose up -d
```
Ou levantar os serviços através do plugin: https://plugins.jetbrains.com/plugin/7724-docker

Caso tenha algum problema e tenha que alterar o composer, se não estiver surtindo efeito executar o comando abaixo:

```shell
docker-compose up --build --force-recreate --renew-anon-volumes
```

---
#### [Mongo Express](https://github.com/mongo-express/mongo-express)
- Abrir interface web: http://localhost:8081

#### [pgAdmin (PostgreSQL)](https://www.pgadmin.org)
- Abrir interface web: http://localhost:5050/
- User: admin@admin.com
- Senha: root

Configurações iniciais:
Após login no pgAdmin, seguir os passos abaixo:

- Criar base de dados manualmente:
  - Abrir o pgAdmin
  - Quick links > Add New Server >Register - Server  
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
- Abrir interface web: http://localhost:9091

---

## Subir a aplicação

 app > src > main > java > Application.java > Run 'Application main()'

---

## Swagger UI

[Swagger UI da Aplicação](http://localhost:8080/swagger-ui/index.html)

