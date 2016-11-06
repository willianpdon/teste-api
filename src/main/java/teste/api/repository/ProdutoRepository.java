package teste.api.repository;

import java.util.List;

import teste.api.domain.Produto;

public interface ProdutoRepository {

	Produto salvar(Produto produto);
	
	Produto buscarPorId(Long id);
	
	List<Produto> buscarTodos();
	
	void deletar(Long id);
	
	
}