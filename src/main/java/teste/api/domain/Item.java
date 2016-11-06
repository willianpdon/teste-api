package teste.api.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item implements Domain {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="itemSequence", sequenceName="ITEM_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="itemSequence")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "QUANTIDADE")
	private Integer quantidade;

	@JoinColumn(name = "PRODUTO_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_ITEM_PRODUTO"))	
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Produto produto;
	
	@JoinColumn(name = "COMPRA_ID", referencedColumnName = "ID", foreignKey = @ForeignKey(name = "FK_ITEM_COMPRA"))	
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
    private Compra compra;

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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [id=");
		builder.append(id);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", produto=");
		builder.append(produto);
		builder.append(", compra=");
		builder.append(compra);
		builder.append("]");
		return builder.toString();
	}
	
}