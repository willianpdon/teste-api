package teste.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import teste.api.domain.Produto;
import teste.api.repository.ProdutoRepository;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@RequestMapping(value="/produto/{id}")
	public Produto getProduto(@PathVariable Long id) {
		return this.produtoRepository.buscarPorId(id);
	}

	@RequestMapping(value="/produtos")
	public List<Produto> getProdutos() {
		return this.produtoRepository.buscarTodos();
	}
	
	@RequestMapping(value="produto/salvar", method = RequestMethod.POST, produces={"application/json"})
	public Produto getProduto(@RequestBody Produto produto) {
		return this.produtoRepository.salvar(produto);
	}

}
