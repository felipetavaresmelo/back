# X Project

## Preparando ambiente de desenvolvimento

---

### IDE

---

[Intellij](https://www.jetbrains.com/pt-br/idea/download/)

#### Plugins:

Instalados:

- [GitToolBox](https://plugins.jetbrains.com/plugin/7499-gittoolbox)
- [SonarLint](https://plugins.jetbrains.com/plugin/7973-sonarlint)
- [Docker](https://plugins.jetbrains.com/plugin/7724-docker)
- [JPA Buddy](https://plugins.jetbrains.com/plugin/15075-jpa-buddy)
- [Rainbow Brackets Lite](https://plugins.jetbrains.com/plugin/20710-rainbow-brackets-lite)
- [Go To Implementation](https://plugins.jetbrains.com/plugin/15359-go-to-implementation)
- [MapStruct Support](https://plugins.jetbrains.com/plugin/10036-mapstruct-support)
- [POJO to JSON](https://plugins.jetbrains.com/plugin/12066-pojo-to-json)
- [Json2Pojo](https://plugins.jetbrains.com/plugin/8533-json2pojo)
- [.ignore](https://plugins.jetbrains.com/plugin/7495--ignore)

Nativos:
- [Settings Sync](https://plugins.jetbrains.com/plugin/20868-settings-sync)
- [Lombok](https://plugins.jetbrains.com/plugin/6317-lombok)
- [GitHub](https://plugins.jetbrains.com/plugin/13115-github)
- [Git](https://plugins.jetbrains.com/plugin/13173-git)
- [EditorConfig](https://plugins.jetbrains.com/plugin/7294-editorconfig)
- [Markdown](https://plugins.jetbrains.com/plugin/7793-markdown)
- [YAML](https://plugins.jetbrains.com/plugin/13126-yaml)


#### StyleGuide

https://google.github.io/styleguide/javaguide.html

Configuração para aplicar de StyleGuide automaticamente:
[google-java-format](https://github.com/google/google-java-format)


### Pre-requisitos:

---

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
#### [H2](https://h2database.com/html/main.html)

- Abrir interface web: http://localhost:8080/h2-console
  - Database: jdbc:h2:mem:testdb

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

---

## Fluxo de desenvolvimento

### Git Flow

Instalar o gitflow:

```shell
apt-get install git-flow
```

Iniciar o fluxo no repositório local:

```shell
git flow init
```

Instalar a extenssão do intellij que facilita o fluxo de trabalho do gitflow: https://plugins.jetbrains.com/plugin/18320-git-flow-integration-plus