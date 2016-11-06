package teste.api.to;

import java.util.ArrayList;
import java.util.List;

import teste.api.domain.Item;

public class ItemTO {

	private Long id;
	
	private Integer quantidade;

	private ProdutoTO produtoTO;

	public ItemTO() {
		
	}
	
	public ItemTO(Item item) {
		this.setId(item.getId());
		this.setQuantidade(item.getQuantidade());
		this.setProdutoTO(new ProdutoTO(item.getProduto()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public ProdutoTO getProdutoTO() {
		return produtoTO;
	}

	public void setProdutoTO(ProdutoTO produtoTO) {
		this.produtoTO = produtoTO;
	}
	
	public Item criaItem() {
		Item item = new Item();
		item.setId(this.getId());
		item.setQuantidade(this.getQuantidade());
		item.setProduto(this.getProdutoTO().criaProduto());

		return item;
	}
	
	public List<ItemTO> criaItensTo(List<Item> itens) {

		List<ItemTO> itensTo = new ArrayList<>();
		
		if (itens != null && !itens.isEmpty()) {
		
			for (Item item : itens) {
				itensTo.add(new ItemTO(item));
			}
			
		}
		
		return itensTo;
		
	}

	public List<Item> criaItens(List<ItemTO> itensTo) {

		List<Item> itens = new ArrayList<>();
		
		if (itensTo != null && !itensTo.isEmpty()) {
		
			for (ItemTO itemTO : itensTo) {
				itens.add(itemTO.criaItem());
			}
			
		}
		
		return itens;
		
	}
}