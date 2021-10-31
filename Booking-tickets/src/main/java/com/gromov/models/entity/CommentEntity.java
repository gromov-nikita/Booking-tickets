package com.gromov.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "comment", schema = "booking_tickets", catalog = "")
public class CommentEntity {
    private int id;
    private int orderId;
    private String text;
    private OrderEntity orderByOrderId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "orderID", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "text", nullable = false, length = -1)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (orderId != that.orderId) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + orderId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "orderID", referencedColumnName = "id", nullable = false)
    public OrderEntity getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(OrderEntity orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
