package com.curso.projetospring.entities.ennums;

public enum StatusPedido {

    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    PREPARANDO_PEDIDO(3),
    DISPACHADO(4),
    CANCELAO(5);

    private int codigo;

    private StatusPedido(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusPedido valueOf(int codigo) {
        for (StatusPedido valor : StatusPedido.values()) {
            if (valor.getCodigo() == codigo) {
                return valor;
            }
        }
        throw new IllegalArgumentException("Status do Pedido Inválido");
    }
}
