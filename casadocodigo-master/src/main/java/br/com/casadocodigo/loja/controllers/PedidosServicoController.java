package br.com.casadocodigo.loja.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
public class PedidosServicoController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/pedidos")
	public ModelAndView pedidos() {
		ModelAndView modelAndView = new ModelAndView("pedidos");
		String uri = "https://book-payment.herokuapp.com/orders";
		List<Pedido> pedidos = new ArrayList<Pedido>(Arrays.asList(restTemplate.getForObject(uri, Pedido[].class)));
		modelAndView.addObject("pedidos", pedidos);
		return modelAndView;
	}

}
