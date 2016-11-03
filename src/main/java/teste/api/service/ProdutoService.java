package teste.api.service;

import java.util.List;

import teste.api.domain.Produto;

public interface ProdutoService {

	Produto salvar(Produto produto);
	
	Produto buscarPorId(Long id);
	
	List<Produto> buscarTodos();
	
}