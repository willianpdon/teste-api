package teste.api.repository;

import java.util.List;

import teste.api.domain.Compra;

public interface CompraRepository {

	Compra salvar(Compra compra);
	
	Compra buscarPorId(Long id);
	
	List<Compra> buscarTodos();
	
}