package teste.api.to;

import java.math.BigDecimal;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import teste.api.domain.Produto;

@ApiModel(value = "Produto")
public class ProdutoTO  {

    @ApiModelProperty(value = "Id do produto.", required=true)
	private Long id;
	
    @ApiModelProperty(value = "Descrição do produto.")
	private String descricao;
	
	@ApiModelProperty(value = "Nome do produto.")
	private String nome;
	
	@ApiModelProperty(value = "Valor do produto.")
	private BigDecimal valor;
	
	public Produto criaProduto(){
	    Produto produto = new Produto();
	    produto.setId(this.getId());
	    produto.setDescricao(this.getDescricao());
	    produto.setNome(this.getNome());
	    produto.setValor(this.getValor());
	    return produto;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}