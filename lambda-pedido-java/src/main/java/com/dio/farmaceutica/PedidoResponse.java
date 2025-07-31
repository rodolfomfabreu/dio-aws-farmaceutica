
package com.dio.farmaceutica;

public class PedidoResponse {
    private String status;
    private String mensagem;

    public PedidoResponse(String status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}
