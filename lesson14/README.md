# Lesson 14 - Login com MySQL

Tela de login que valida usuario e senha na tabela `users` do MySQL.

## Requisitos

- Docker
- JDK 17 ou superior

## Como executar

```
./lesson14/run.sh
```

O script baixa o driver JDBC em `lib/` na primeira vez, sobe o MySQL, compila e abre a tela.

## Usuarios do seeder

| Username  | Password      |
|-----------|---------------|
| aluno     | aluno123      |
| professor | professor123  |
| admin     | admin123      |

## Parar o banco

```
docker compose -f lesson14/docker-compose.yml down
```

Use `down -v` para apagar os dados e rodar `schema.sql` e `seeder.sql` de novo.
