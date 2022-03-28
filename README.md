# iTranswarp

Full-featured CMS including blog, wiki, discussion, etc. Cloud native application that powered by SpringBoot.

![Github Workflow](https://github.com/michaelliao/warpdb/actions/workflows/maven.yml/badge.svg)

[![Docker Pulls](https://img.shields.io/docker/pulls/michaelliao/itranswarp?color=%2334D058&style=plastic)](https://hub.docker.com/repository/docker/michaelliao/itranswarp)

* Based on SpringBoot 2.x
* OAuth2 integration (weibo, QQ, facebook, etc.)
* SEO support
* REST API
* Customized CSS with UIkit2

### Environment

- JDK 11
- MySQL 5.7
- Redis 5/6

### Build

```
$ mvn -DskipTests=true clean package
```

Or check [build.sh](build.sh).

### Initialize database

DDL and test data are generated by [SchemaBuilder.java](src/main/java/com/itranswarp/SchemaBuilder.java).

Create schema:

```
$ mysql -u root -p < release/ddl.sql
```

NOTE: re-run this SQL file will remove all existing data.

Import test data:

```
$ mysql -u root -p it < release/init.sql
```

### Run

```
java -jar itranswarp.jar
```

### Configuration

All configurations are passed by environments:

```
$ PROFILES=production TIME_ZONE=Asia/Shanghai DOMAIN=example.com \
  DB_HOST=localhost DB_PASSWORD=changeit \
  REDIS_HOST=localhost \
  java -jar itranswarp.jar
```

Please check [application.yml](src/main/resources/application.yml) for environment variables.

### Deploy

iTranswarp is deployed by Ansible. Scripts is ready for Ubuntu Server 18.04 or CentOS 7/8.

Deploy script:

```
$ ansible/deploy.py --profile <env>
```

The deploy script will do following:

- install open jdk 11 headless;
- install nginx;
- install supervisor;
- deploy jar;
- deploy static resources;
- generate nginx configuration;
- generate supervisor configuration;
- update symbol link;
- reload supervisor;
- reload nginx.

### Docker

Support [.env.example](docker/.env.example) use local ip for test. 
```
$ cd docker
$ cp .env.example .env
$ vim .env
$ docker-compose up -d
```
test:
https://www.local.itranswarp.com/

