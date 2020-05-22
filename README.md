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
