package teste.api.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "COMPRA")
public class Compra implements Domain {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="compraSequence", sequenceName="COMPRA_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.AUTO, generator="compraSequence")
	@Column(name = "ID")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_HORA")
	private Date dataHora;
	
	@Column(name = "DESCRICAO", length = 1000)
	private String descricao;
	
	@Column(name = "PRECO_PRODUTO")
	private BigDecimal precoProduto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(BigDecimal precoProduto) {
		this.precoProduto = precoProduto;
	}

	
}