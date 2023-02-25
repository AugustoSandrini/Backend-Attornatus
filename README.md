# API para gerenciar pessoas
O projeto foi desenvolvido como uma Avaliação Técnica.

## Banco de Dados H2
Para acessar o banco use `localhost:8080/h2`.

Configurações do banco e porta do Tomcat em: `/src/main/resources/application.properties.`

## Como Rodar o Projeto
O sistema de back-end foi desenvolvido com a tecnologia Spring Boot, para compilar e executar o sistema é necessário ter instalado o JDK da versão 17 do Java e o Maven. Acesse a pasta **./backend-attornatus** pelo terminal, execute o comando `mvn clean package` para baixar as dependências e gerar o arquivo **.war**, aguarde o processo de compilação e em seguida execute o comando `java -jar target/backend-attornatus-0.0.1-SNAPSHOT.jar` (Caso não tenha o arquivo .jar com esse nome é só executar o unico .jar dentro da pasta!). Depois que o sistema iniciar ele estará disponivel no endereço http://localhost:8080.

## Rotas
- `GET` -Listar pessoas -> `localhost:8080/pessoas`
- `GET` -Listar pessoa por Id -> `localhost:8080/pessoas/{id}`
- `GET` -Listar endereços da Pessoa -> `localhost:8080/pessoas/{id}/enderecos`
- `GET` -Listar endereço principal da pessoa -> `localhost:8080/pessoas/{id}/endereco-principal`
- `POST` -Adicionar um endereço para a pessoa -> `localhost:8080/pessoas/add-endereco/{id}`
- `POST` -Adicionar uma pessoa -> `localhost:8080/pessoas`
- `PUT`  -Editar uma pessoa -> `localhost:8080/pessoas/{id}`
- `DELETE` - Excluir uma pessoa -> `localhost:8080/pessoas/{id}`

## Perguntas:
- Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

Acredito que na implementação de uma nova funcionalidade deve-se levar em consideração vários critérios como a atenção ao requisitos que foram passados, para entender bem o que foi solicitado, testes da nova implementação para garantir que o que foi solicitado vai ser entregue, uma boa escrita de código para que manutenção desse código seja feita da forma mais simples possível, esses são alguns critérios que eu considero importante.

- Em qual etapa da implementação você considera a qualidade de software?

A qualidade de software deve ser levada em consideração desde o inicio da implementação, pois assim desde o planejamento dessa nova implementação ja é possível diminuir os riscos e bugs que ela pode causar, visando um resultado mais perto do esperado.
