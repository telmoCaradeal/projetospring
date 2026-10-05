package com.curso.projetospring.entities;

import com.curso.projetospring.entities.ennums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant instante;


    @ManyToOne
    @JoinColumn(name="usuarioId")
    private Usuario usuarioCliente; //Associação de classe

    //Associação de classe
    private Integer status;

    @OneToMany(mappedBy = "id.pedido") //Associação de Um Pedido para Muitos Iten
    private Set<ItemPedido> itens = new HashSet<>();

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public  Pedido() {
    }

    public Pedido(Long id, Instant instante, StatusPedido status,Usuario usuarioCliente) {
        this.id = id;
        this.instante = instante;
        setStatus(status);
        this.usuarioCliente = usuarioCliente;
    }

    public StatusPedido getStatus() {

        return StatusPedido.valueOf(status);
    }

    public void setStatus(StatusPedido status) {
        if(status!=null){
            this.status = status.getCodigo();
        }

    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getInstante() {
        return instante;
    }

    public void setInstante(Instant instante) {
        this.instante = instante;
    }

    public Usuario getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(Usuario usuarioCliente) {

        this.usuarioCliente = usuarioCliente;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
