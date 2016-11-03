package teste.api.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Domain {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="produtoSequence", sequenceName="PRODUTO_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="produtoSequence")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DESCRICAO", length = 1000)
	private String descricao;
	
	@Column(name = "NOME", length = 1000)
	private String nome;
	
	@Column(name = "VALOR")
	private BigDecimal valor;
	
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	
}