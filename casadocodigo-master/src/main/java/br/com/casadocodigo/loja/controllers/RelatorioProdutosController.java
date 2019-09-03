package br.com.casadocodigo.loja.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.loja.models.Relatorio;

@RestController()
@RequestMapping("/relatorio-produtos")
public class RelatorioProdutosController {

	@Autowired
	private Relatorio relatorio;

	@RequestMapping(method = RequestMethod.GET)
	public Relatorio gerarRelatorio(@RequestParam(value = "data", required = false) String dataLancamento)
			throws ParseException {
		if (dataLancamento != null) {
			SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
			data.parseObject(dataLancamento);
			Calendar calendar = data.getCalendar();
			relatorio.setProdutos(calendar);
			relatorio.setQuantidade();
		} else {
			relatorio.setProdutos();
			relatorio.setQuantidade();
		}
		return relatorio;
	}

}
