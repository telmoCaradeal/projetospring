package com.curso.projetospring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.TargetEmbeddable;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


@Entity
@Table(name="pagamento")
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant instantePagamento;

    //Associação de classe
    @OneToOne
    @MapsId
    @JsonIgnore
    private Pedido pedido;

    public Pagamento() {}

    public Pagamento(Long id, Instant instantePagamento, Pedido pedido) {
        this.id = id;
        this.instantePagamento = instantePagamento;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getInstantePagamento() {
        return instantePagamento;
    }

    public void setInstantePagamento(Instant instantePagamento) {
        this.instantePagamento = instantePagamento;
    }

    public Pedido getPedido() {
        return pedido;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
