# Backend-Attornatus
O projeto foi desenvolvido como uma Avaliação de Entrevista para a empresa Attornatus.

## Banco de Dados H2
Configurações do banco e porta do Tomcat em: 
/src/main/resources/application.properties.

## Como Rodar o Projeto
O sistema de back-end foi desenvolvido com a tecnologia Spring Boot, para compilar e executar o sistema é necessário ter instalado o JDK da versão 17 do Java e o Maven. Acesse a pasta **./backend-attornatus** pelo terminal, execute o comando `mvn clean package` para baixar as dependências e gerar o arquivo **.war**, aguarde o processo de compilação e em seguida execute o comando `java -jar target/backend-attornatus-0.0.1-SNAPSHOT.jar` (Caso não tenha o arquivo .war com esse nome é só executar o unico .war dentro da pasta!). Depois que o sistema iniciar ele estará disponivel no endereço http://localhost:8080.

## Rotas
- `GET` -Listar pessoas -> `localhost:8080/pessoas`
- `GET` -Listar pessoa por Id -> `localhost:8080/pessoas/{id}`
- `GET` -Listar endereços da Pessoa -> `localhost:8080/pessoas/{id}/enderecos`
- `GET` -Listar endereço principal da pessoa -> `localhost:8080/pessoas/{id}/endereco-principal`
- `POST` -Adicionar um endereço para a pessoa -> `localhost:8080/pessoas/add-endereco/{id}`
- `POST` -Adicionar uma pessoa -> `localhost:8080/pessoas`
- `PUT`  -Editar uma pessoa -> `localhost:8080/pessoas/{id}`
- `DELETE` - Excluir uma pessoa -> `localhost:8080/pessoas/{id}`