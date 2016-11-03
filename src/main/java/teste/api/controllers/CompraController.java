package teste.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import teste.api.domain.Compra;
import teste.api.repository.CompraRepository;

@Api(value="Compra")
@RestController
public class CompraController {

	@Autowired
	private CompraRepository compraRepository;
	
	@RequestMapping(value="/compra/{id}")
	public Compra getCompra(@PathVariable Long id) {
		return this.compraRepository.buscarPorId(id);
	}

	@RequestMapping(value="/compras")
	public List<Compra> getCompras() {
		return this.compraRepository.buscarTodos();
	}
	
	@RequestMapping(value="compra/salvar", method = RequestMethod.POST, produces={"application/json"})
	public Compra getCompra(@RequestBody Compra Compra) {
		return this.compraRepository.salvar(Compra);
	}

}
