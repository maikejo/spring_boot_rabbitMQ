package br.com.cartao.controller;

import br.com.cartao.model.CartaoCredito;
import br.com.cartao.service.CartaoCreditoService;
import org.apache.camel.Consume;
import org.apache.camel.language.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cartao/")
public class CartaoCreditoController {

    @Autowired
    CartaoCreditoService cartaoCreditoService;


    /**
     * Metodo responsavel por verificar na pasta CARTAO se existe arquivo, se for enviado o arquivo
     * envia os dados de cartao de credito para fila - cartao.fila
     */
    @Consume(uri = "file://C:\\cartao")
    public void existeArquivoEnviaFila(String msg,
                                       @XPath("/cartao/nomeResponsavel/text()") String nomeResponsavel,
                                       @XPath("/cartao/numero/text()") Long numero,
                                       @XPath("/cartao/bandeira/text()") String bandeira,
                                       @XPath("/cartao/seguranca/text()") Integer seguranca) {

        if ("Master".toUpperCase().equals(bandeira.toUpperCase())) {
            CartaoCredito cartaoCredito = new CartaoCredito();
            cartaoCredito.setNomeResponsavel(nomeResponsavel);
            cartaoCredito.setNumero(numero);
            cartaoCredito.setBandeira(bandeira);
            cartaoCredito.setSeguranca(seguranca);
            cartaoCreditoService.enviar(cartaoCredito);
        }
    }

    /**
     * Metodo enviar dados do cartao de credito via REST
     * envia os dados de cartao de credito para fila - cartao.fila
     */
    @RequestMapping(value = "/enviarCartao", method = RequestMethod.GET)
    public void criarCartaoCreditoFila(@RequestParam String nomeResponsavel,
                                     @RequestParam Long numero,
                                     @RequestParam String bandeira,
                                     @RequestParam Integer seguranca) {

        CartaoCredito cartaoCredito = new CartaoCredito();
        cartaoCredito.setNomeResponsavel(nomeResponsavel);
        cartaoCredito.setNumero(numero);
        cartaoCredito.setBandeira(bandeira);
        cartaoCredito.setSeguranca(seguranca);
        cartaoCreditoService.enviar(cartaoCredito);
    }

    /**
     * Metodo recebe dados do cartao de credito via REST
     * recupera dados da fila - cartao.fila
     */
    @RequestMapping(value = "/receberDadosCartao", method = RequestMethod.GET)
    public CartaoCredito receberCartaoCreditoFila() {
        return cartaoCreditoService.receber();
    }
}
