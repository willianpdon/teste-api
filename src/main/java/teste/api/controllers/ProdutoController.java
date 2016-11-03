package teste.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import teste.api.domain.Compra;
import teste.api.repository.CompraRepository;

@RestController
@RequestMapping(value="/buscar")
public class ProdutoController {

	@Autowired
	private CompraRepository compraRepository;
	
	@RequestMapping(value="{id}")
	public Compra getProduto(@PathVariable Long id) {
		
		return this.compraRepository.buscarPorId(id);
	}
	
}
