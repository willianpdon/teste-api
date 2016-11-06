package teste.api.service;

import java.util.List;

import teste.api.domain.Compra;

public interface CompraService {

	Compra salvar(Compra compra);
	
	Compra buscarPorId(Long id);
	
	List<Compra> buscarTodos();
	
	void deletar(Long id);
	
}