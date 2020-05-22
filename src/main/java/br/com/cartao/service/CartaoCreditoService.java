package br.com.cartao.service;

import br.com.cartao.model.CartaoCredito;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CartaoCreditoService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${cartao.rabbitmq.exchange}")
    private String exchange;

    @Value("${cartao.rabbitmq.queue}")
    private String queue;

    @Value("${cartao.rabbitmq.routingkey}")
    private String routingkey;

    public void enviar(CartaoCredito cartaoCredito) {
        amqpTemplate.convertAndSend(exchange, routingkey, cartaoCredito);
        System.out.println("Mensagem enviada = " + cartaoCredito);

    }

    public CartaoCredito receber(){
        return (CartaoCredito) amqpTemplate.receiveAndConvert(queue);
    }
}
