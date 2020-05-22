# spring_boot_rabbitMQ
Projeto utilizando o RabbitMQ filas utilizando Spring , Camel e RabbitMQ

# Enviar Dados do Cartão de Crédito via REST
curl http://localhost:8080/cartao/enviarCartao?nomeResponsavel=teste&numero=2&bandeira=Visa&seguranca=123

# Recupera Dados da Fila
curl http://localhost:8080/cartao/receberDadosCartao
