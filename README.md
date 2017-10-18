# ftchatdatabase

## Tutorial para deploy de novas features:

#### Informações úteis:
* Trello (Scrum): [https://trello.com/b/660bPp1i/projeto-ftchat](https://trello.com/b/660bPp1i/projeto-ftchat)
* Repositório do git: [https://github.com/kaueel/ftchatdatabase](https://github.com/kaueel/ftchatdatabase)

### Passo a passo:
- Entre no site do Trello
- Veja uma tarefa na seção `Sprint Ativa` e arraste para `Em Progresso`
- Veja no próprio card se existem detalhes e, qualquer dúvida, pergunte para alguém do projeto
- Antes de começar a desenvolver, tenha clareza do problema e como vai soluciona-lo
- Quando for começar a desenvolver o código, crie uma branch
  - Para criar uma branch, digite no terminal (dentro do diretório do projeto): `git checkout -b nome-da-tarefa`
- Volte para a branch master: `git checkout master` e pegue o projeto dela para se certificar de estar na última versão: `git pull origin HEAD` depois volte novamente para a sua branch `git checkout nome-da-tarefa`
- Desenvolva a tarefa testando localmente sempre que necessário
- Quando concluída e testada com sucesso, tens de subir as alteraçes e criar um pull request (um pedido que mostra o seu interesse em juntar a sua branch com a master)
  - Para subir as alterações da sua tarefa, execute: `git status`, verifique os arquivos que você alterou
  - execute `git add caminho/para/o/arquivo/alterado` para cada arquivo alterado **que você alterou** (arquivos iram aparecer lá, mas que não são interessantes a tarefa, por favor não submetelos ao github)
  - execute `git commit -m "diga o que você fez" (geralmente fica igual ao nome da branch, mas aqui você escreve no infinitivo, por exemplo: "criando novo botão", "arrumando o bug tal")
  - execute `git status`, os arquivos da sua tarefa devem estar na cor verde agora, se algum não estiver, volte ao sub-passo anterior
  - execute `git checkout master` para voltar a master e `git pull` para pegar os últimos arquivos da master caso alguém tenha alterado algo
  - execute `git checkout nome-da-tarefa` para voltar a sua branch
  - execute `git merge master` para juntar a **master na sua branch, não a sua branch na master ainda**
  - execute `git push origin HEAD` para subir a sua branch para o GitHub
  - Navegue para o repositório, deve aparecer um aviso da sua nova branch, senão houve, vá em branchs e encontre a sua
  - Clique no botão verde (Criar pull request)
  - Coloque como code reviewer todos os outros integrantes do time
  - Crie o pull request
  - Não clique em merge e em nada do tipo, senão você ira juntar a sua branch na master sem o review dos outros
- Arraste sua tarefa no trello, de `Em Progresso` para `Review`
- **Se você acha que a sua tarefa bloqueia alguma outra de funcionar, avise quem pegou a outra tarefa**
