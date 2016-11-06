package teste.api.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@Column(name = "DATA")
	private Date data;
	
	@Column(name = "VALOR_TOTAL")
	private BigDecimal valorTotal;

	@Column(name = "TIPO_PAGAMENTO")
	@Enumerated(EnumType.STRING)
	private TipoPagamento tipoPagamento;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "compra", cascade=CascadeType.PERSIST)
	private List<Item> itens = new ArrayList<Item>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataHora() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Date getData() {
		return data;
	}
	
}