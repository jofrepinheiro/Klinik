package model;

public class Pagamento {
	private int idPagamento;
	private float valorPagamento;
	private char tipoPagamento;
	
	public int getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	public float getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(float valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public char getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(char tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}	
}
