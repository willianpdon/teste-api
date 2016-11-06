package teste.api.to;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import teste.api.domain.Compra;
import teste.api.domain.TipoPagamento;

@ApiModel(value = "Compra")
public class CompraTO {

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	@ApiModelProperty(value = "Id do compra.", required=true)
	private Long id;
	
	@ApiModelProperty(value = "Data da compra.")
	private String data;
	
	@ApiModelProperty(value = "Valor total da compra.")
	private BigDecimal valorTotal;
	
	@ApiModelProperty(value = "tipo de pagamento da compra.")
	private TipoPagamento tipoPagamento;
	
	@ApiModelProperty(value = "Itens da compra.")
	private List<ItemTO> itens = new ArrayList<ItemTO>();

	public CompraTO() {
		
	}
	
	public CompraTO(Compra compra) {
		if (compra != null) {
			this.setId(compra.getId());
			this.setData(this.sdf.format(compra.getDataHora()));
			this.setValorTotal(compra.getValorTotal());
			this.setTipoPagamento(compra.getTipoPagamento());
			this.setItens(new ItemTO().criaItensTo(compra.getItens()));
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
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

	public List<ItemTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemTO> itens) {
		this.itens = itens;
	}

	public Compra criaCompra() throws ParseException {
		Compra compra = new Compra();
		compra.setId(this.getId());
		if (this.getData() !=null && !"".equals(this.getData())) {
			compra.setData(this.sdf.parse(this.getData()));
		}
		compra.setValorTotal(this.getValorTotal());
		compra.setTipoPagamento(this.getTipoPagamento());
		compra.setItens(new ItemTO().criaItens(this.getItens()));
		return compra;
	}

	public List<CompraTO> criaCompras(List<Compra> compras) {

		List<CompraTO> comprasTo = new ArrayList<>();
		
		if (compras != null && !compras.isEmpty()) {
		
			for (Compra compra : compras) {
				comprasTo.add(new CompraTO(compra));
			}
			
		}
		
		return comprasTo;
		
	}
	
}