
package com.dio.farmaceutica;

public class PedidoRequest {
    private String pedidoId;
    private String cliente;
    private String produto;
    private int quantidade;

    public String getPedidoId() { return pedidoId; }
    public void setPedidoId(String pedidoId) { this.pedidoId = pedidoId; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getProduto() { return produto; }
    public void setProduto(String produto) { this.produto = produto; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
}
