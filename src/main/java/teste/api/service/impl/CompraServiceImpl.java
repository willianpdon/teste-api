package teste.api.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.api.domain.Compra;
import teste.api.domain.Item;
import teste.api.domain.Produto;
import teste.api.repository.CompraRepository;
import teste.api.repository.ItemRepository;
import teste.api.repository.ProdutoRepository;
import teste.api.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository; 
    
    @Autowired
    private ItemRepository itemRepository; 
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Override
    public Compra salvar(Compra compra) {
    	
    	try {
			
    	compra.setData(new Date());
    	
    	List<Item> itens = new ArrayList<>();
    	
    	List<Item> itensCru = compra.getItens();
    	
    	compra.setItens(null);
    	compra = this.compraRepository.salvar(compra);
    	
    	BigDecimal valorTotal = new BigDecimal(0);
    	for (Item item : itensCru) {
    		Produto produto = produtoRepository.buscarPorId(item.getProduto().getId());
    		valorTotal = valorTotal.add(produto.getValor().multiply(new BigDecimal(item.getQuantidade())));
    		item.setCompra(compra);
			itens.add(this.itemRepository.salvar(item));
		}

    	compra.setValorTotal(valorTotal);
    	compra.setItens(itens);
    	
        compra = this.compraRepository.salvar(compra);
        
    	} catch (Exception e) {
			e.printStackTrace();
		}
		return compra;
    }

    @Override
    public Compra buscarPorId(Long id) {
        return this.compraRepository.buscarPorId(id);
    }

    @Override
    public List<Compra> buscarTodos() {
        return this.compraRepository.buscarTodos();
    }

	@Override
	public void deletar(Long id) {
		this.compraRepository.deletar(id);
	}

}
