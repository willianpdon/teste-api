package teste.api.repository;

import java.util.List;

import teste.api.domain.Item;

public interface ItemRepository {

	Item salvar(Item item);
	
	Item buscarPorId(Long id);
	
	List<Item> buscarTodos();
	
	void deletar(Long id);
	
	
}