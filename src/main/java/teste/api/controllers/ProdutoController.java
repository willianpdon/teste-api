package teste.api.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import teste.api.domain.Produto;
import teste.api.repository.ProdutoRepository;
import teste.api.to.ProdutoTO;

@Api(value="Clientes API")
@RestController
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@ApiOperation(value="Consulta todos clientes do sistema", notes="Consulta síncrona.")
	@RequestMapping(value="/produto/{id}")
	public ProdutoTO getProduto(@PathVariable Long id) {
	
	    
	    //return this.produtoRepository.buscarPorId(id);
	    return new ProdutoTO();
	}

	@ApiOperation(value="Consulta um cliente no sistema", notes="Consulta síncrona.")
	@RequestMapping(value="/produtos")
	public List<ProdutoTO> getProdutos() {
		//return this.produtoRepository.buscarTodos();
	    
	    return Arrays.asList(new ProdutoTO());
	}
	
	@ApiOperation(value="Cria um novo cliente.", notes="Inserção síncrona.")
	@RequestMapping(value="produto/salvar", method = RequestMethod.POST, produces={"application/json"})
	public ProdutoTO criaProduto(@RequestBody ProdutoTO produto) {
	    this.produtoRepository.salvar(produto.criaProduto());
	    return produto;
	}

}
