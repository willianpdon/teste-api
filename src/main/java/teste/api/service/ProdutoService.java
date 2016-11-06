package teste.api.service;

import java.util.List;

import teste.api.domain.Produto;
import teste.api.exception.TesteApiException;

public interface ProdutoService {

	Produto salvar(Produto produto) throws TesteApiException;
	
	Produto buscarPorId(Long id);
	
	List<Produto> buscarTodos();
	
	void deletar(Long id);
	
}