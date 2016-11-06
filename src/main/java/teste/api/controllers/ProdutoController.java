package teste.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import teste.api.service.ProdutoService;
import teste.api.to.ProdutoTO;

@Api(value="Produto")
@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@ApiOperation(value="Consulta um produto no sistema", notes="Consulta síncrona.")
	@RequestMapping(value="/produto/{id}")
	public ProdutoTO getProduto(@PathVariable Long id) {
	    return new ProdutoTO(this.produtoService.buscarPorId(id));
	}

	@ApiOperation(value="Consulta todos produtos do sistema", notes="Consulta síncrona.")
	@RequestMapping(value="/produtos")
	public List<ProdutoTO> getProdutos() {
	    return new ProdutoTO().criaProdutos(this.produtoService.buscarTodos());
	}
	
	@ApiOperation(value="Cria um novo produto.", notes="Inserção síncrona.")
	@RequestMapping(value="produto/salvar", method = RequestMethod.POST, produces={"application/json"})
	public ProdutoTO salvarProduto(@RequestBody ProdutoTO produtoTO) {
	    this.produtoService.salvar(produtoTO.criaProduto());
	    return produtoTO;
	}

	@ApiOperation(value="Deleta um produto no sistema", notes="Exclusão síncrona.")
	@RequestMapping(value="/produto/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity detelarProduto(@PathVariable Long id) {
	    this.produtoService.deletar(id);
	    return ResponseEntity.status(HttpStatus.OK).body("Exclusão executada com sucesso! Id=" + id);
	}
}
