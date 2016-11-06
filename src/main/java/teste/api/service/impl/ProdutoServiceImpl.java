package teste.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.api.domain.Produto;
import teste.api.exception.TesteApiException;
import teste.api.repository.ProdutoRepository;
import teste.api.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository; 
    
    public ProdutoServiceImpl() {

    }
    
    @Override
    public Produto salvar(Produto produto) throws TesteApiException {
    		
		if (produto.getNome() == null || "".equals(produto.getNome())) {
			throw new TesteApiException("nome não pode ser null");
		}
		
		if (produto.getDescricao() == null || "".equals(produto.getDescricao())) {
			throw new TesteApiException("descrção não pode ser null");
		}
		
		if (produto.getValor() == null || "".equals(produto.getValor())) {
			throw new TesteApiException("descrção não pode ser null");
		}
		
		produto = this.produtoRepository.salvar(produto);
    		
    		
    	
        return produto;
    }

    @Override
    public Produto buscarPorId(Long id) {
        return this.produtoRepository.buscarPorId(id);
    }

    @Override
    public List<Produto> buscarTodos() {
        return this.produtoRepository.buscarTodos();
    }

	@Override
	public void deletar(Long id) {
		this.produtoRepository.deletar(id);
	}

}
