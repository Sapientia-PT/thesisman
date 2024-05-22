# Projeto de Referência de SpringBoot

## Autores
Guilherme Gouveia   - 58176

João Miguel         - 58195

Rafael Correia      - 58236

## Dependências

Este projeto vai usar Java17+ e Postgres, mas esses vão estar disponíveis dentro dos containers Docker. Só são necessários se quiser correr a aplicação nativamente. Será necessário o maven.

## Build steps

Deve correr os seguintes comando num terminal:
* `cd server`
* `docker compose up --build`

Este comando vai iniciar o container PostgreSQL.

Abrir outro terminal e, ainda na pasta server, correr:
* `mvn spring-boot:run`

Agora, com o PostgreSQL e o ThesismanApp a correr,
podemos correr o JavaFX, noutro terminal, através do jar presente
na raíz do projeto, da seguinte forma:

* `java -jar client.jar`

## Testar

Abrir http://localhost:8080 num browser e verificar que aparece uma página com os temas com alunos que se candidataram ao mesmo.

Pode ainda confirmar que consegue ver:
* http://localhost:8080/temas Lista de todos os temas
* http://localhost:8080/estatisticas Estatísticas relativas à taxa de sucesso dos alunos

