# Projeto de Referência de SpringBoot

## Autores
Guilherme Gouveia   - 58176

João Miguel         - 58195

Rafael Correia      - 58236

## Dependências

Este projeto vai usar Java17+ e Postgres, mas esses vão estar disponíveis dentro dos containers Docker. Só são necessários se quiser correr a aplicação nativamente.


### Windows

Instalar [Docker Desktop](https://docs.docker.com/desktop/install/windows-install/) e [Python 3](https://www.python.org/ftp/python/3.11.2/python-3.11.2-amd64.exe)

### Ubuntu

```
sudo apt-get install python3 python3-pip
```

Seguir [esta página](https://docs.docker.com/engine/install/ubuntu/) e os quatro passos listados [aqui](https://docs.docker.com/engine/install/linux-postinstall/#manage-docker-as-a-non-root-user).

### Fedora

```
sudo dnf python3 python3-pip
```

Seguir [esta página](https://docs.docker.com/engine/install/fedora/) e os quatro passos listados [aqui](https://docs.docker.com/engine/install/linux-postinstall/#manage-docker-as-a-non-root-user).


## Primeiro passo

Deve correr os comandos listados no ficheiro `setup.sh`.

## Segundo passo

Deve correr `run.sh`.

Este comando vai iniciar dois containers:

* Um com a aplicação que existe nesta pasta.
* Uma instância de um container com Postgres

## Terceiro passo

Abrir http://localhost:8080 num browser e verificar que aparece uma página com os temas com alunos que se candidataram ao mesmo.

Pode ainda confirmar que consegue ver:
* http://localhost:8080/alunos Lista de todos os alunos
* http://localhost:8080/aprovados Número de Alunos aprovados (média > 10)
* http://localhost:8080/reprovados Número de Alunos reprovados (média < 10)

# FAQ

## Preciso de `sudo` para correr o `run.sh`
Tenta correr `sudo usermod -aG docker $USER` seguido de um log-out na máquina.
Ou tentar [desta forma](https://www.digitalocean.com/community/questions/how-to-fix-docker-got-permission-denied-while-trying-to-connect-to-the-docker-daemon-socket)

## O Docker não instala em ubuntu.

Tentar [desta forma](https://askubuntu.com/a/1411717).

## O `run.sh` não está a correr no meu macos m1.

Tentar correr `docker ps`. Se não funcionar, [tentar isto](https://stackoverflow.com/a/68202428/28516).
Confirmar também que está instalado o Docker Desktop (`brew install --cask docker`) e não apenas a command-line tool (`brew install docker`). A aplicação Docker deve também estar a correr (icon na menubar).

## Estou em windows e o `bash setup.sh` não funciona

Correr numa bash (tanto a Git Bash, MSys2 bash ou WSL em linux) e não na Powershell, nem no CMD.exe.

## `docker compose` não funciona

`docker compose` é o comando da última versão de docker. `docker-compose` é a versão antiga. Devem atualizar o docker.
