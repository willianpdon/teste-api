package teste.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teste.api.domain.Produto;
import teste.api.repository.ProdutoRepository;
import teste.api.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository; 
    
    public ProdutoServiceImpl() {

    }
    
    @Override
    public Produto salvar(Produto produto) {
        return this.produtoRepository.salvar(produto);
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
