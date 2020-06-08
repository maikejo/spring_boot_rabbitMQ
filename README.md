# spring_boot_rabbitMQ
Projeto utilizando o RabbitMQ filas utilizando Spring , Camel e RabbitMQ
 - JAVA 11
 - Spring 2.3.0

# Enviar Dados do Cartão de Crédito via Arquivo XML
 - Criar pasta no diretorio: C:\cartao
 - Colocar arquivo (cartao_credito.xml - está na pasta resources do projeto) na pasta "cartao"
 
# Enviar Dados do Cartão de Crédito via REST
curl http://localhost:8080/cartao/enviarCartao?nomeResponsavel=teste&numero=2&bandeira=Visa&seguranca=123

# Recupera Dados da Fila
curl http://localhost:8080/cartao/receberDadosCartao

# Docker
docker build -t spring/spring-boot-rabbitmq .
docker run -p 8080:8080 spring/spring-boot-rabbitmq

# Docker RabbitMQ
docker run -d — hostname my-rabbit — name rabbit13 -p 8080:15672 -p 5672:5672 -p 25676:25676 rabbitmq:3-management

user:  guest
senha: guest