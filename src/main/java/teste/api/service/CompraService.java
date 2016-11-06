package teste.api.service;

import java.util.List;

import teste.api.domain.Compra;
import teste.api.exception.TesteApiException;

public interface CompraService {

	Compra salvar(Compra compra) throws TesteApiException;
	
	Compra buscarPorId(Long id);
	
	List<Compra> buscarTodos();
	
	void deletar(Long id) throws TesteApiException;
	
}