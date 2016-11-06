package teste.api.controllers;

import java.text.ParseException;
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

import teste.api.service.CompraService;
import teste.api.to.CompraTO;

@Api(value="Compra")
@RestController
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@ApiOperation(value="Consulta um compra no sistema", notes="Consulta síncrona.")
	@RequestMapping(value="/compra/{id}")
	public CompraTO getCompra(@PathVariable Long id) {
	    return new CompraTO(this.compraService.buscarPorId(id));
	}

	@ApiOperation(value="Consulta todos compras do sistema", notes="Consulta síncrona.")
	@RequestMapping(value="/compras")
	public List<CompraTO> getCompras() {
	    return new CompraTO().criaCompras(this.compraService.buscarTodos());
	}
	
	@ApiOperation(value="Cria um novo compra.", notes="Inserção síncrona.")
	@RequestMapping(value="/compra/salvar", method = RequestMethod.POST, produces={"application/json"})
	public CompraTO salvarCompra(@RequestBody CompraTO compraTO) throws ParseException {
	    return new CompraTO(this.compraService.salvar(compraTO.criaCompra()));
	}

	@ApiOperation(value="Deleta um compra no sistema", notes="Exclusão síncrona.")
	@RequestMapping(value="/compra/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity detelarCompra(@PathVariable Long id) {
	    this.compraService.deletar(id);
	    return ResponseEntity.status(HttpStatus.OK).body("Exclusão executada com sucesso! Id=" + id);
	}

}
