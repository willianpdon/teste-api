package teste.api.domain;

public enum TipoPagamento {

	TRANSFERENCIA_BANCARIA("Transferência bancária"), 
	PAGSEGURO("PagSeguro"),
	BOLETO("Boleto"),
	CARTAO_CREDITO("Cartão de crédito");
	
	private String descricao;

	private TipoPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}