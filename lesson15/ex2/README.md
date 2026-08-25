# Lesson 15 - Ex2 - Login internacionalizado (PT/EN)

Mesmo login com MySQL da lesson 14, agora internacionalizado. O idioma
(Português ou English) e escolhido no menu da tela de login, antes da
autenticacao, e segue para a tela do aluno.

Os textos ficam nos arquivos `Ex2_pt_BR.properties` e `Ex2_en_US.properties`,
carregados via `ResourceBundle.getBundle("Ex2", locale)`. A data do ultimo
acesso e o separador decimal da nota tambem acompanham o idioma escolhido.

## Requisitos

- Docker
- JDK 17 ou superior

## Como executar

```
./lesson15/ex2/run.sh
```

O script baixa o driver JDBC em `lib/` na primeira vez, sobe o MySQL, compila e abre a tela.
