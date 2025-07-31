
package com.dio.farmaceutica;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PedidoHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private final ObjectMapper mapper = new ObjectMapper();
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        try {
            PedidoRequest pedido = mapper.readValue(input.getBody(), PedidoRequest.class);
            if (pedido == null || pedido.getPedidoId() == null) {
                return new APIGatewayProxyResponseEvent()
                        .withStatusCode(400)
                        .withBody("{\"status\":\"ERRO\",\"mensagem\":\"Pedido inválido.\"}");
            }

            context.getLogger().log("Processando pedido: " + pedido.getPedidoId());

            String msg = String.format("Pedido %s processado com sucesso para %s.",
                                    pedido.getPedidoId(), pedido.getCliente());

            PedidoResponse response = new PedidoResponse("SUCESSO", msg);
            String responseBody = mapper.writeValueAsString(response);

            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(200)
                    .withHeaders(Map.of("Content-Type", "application/json"))
                    .withBody(responseBody);

        } catch (Exception e) {
            context.getLogger().log("Erro ao processar o pedido: " + e.getMessage());
            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(500)
                    .withBody("{\"status\":\"ERRO\",\"mensagem\":\"Erro interno ao processar o pedido.\"}");
        }
    }
}
