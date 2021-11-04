package com.gromov.models.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "trip", schema = "booking_tickets", catalog = "")
public class TripEntity {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;
    @OneToMany(mappedBy = "otrip")
    private Collection<OrderEntity> orders;
    @OneToMany(mappedBy = "trip")
    private Collection<PointEntity> points;
    @ManyToOne
    @JoinColumn(name = "transportID", referencedColumnName = "id")
    private TransportEntity transport;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }
    public Collection<OrderEntity> getOrders() {
        return orders;
    }
    public void setOrders(Collection<OrderEntity> orders) {
        this.orders = orders;
    }
    public Collection<PointEntity> getPoints() {
        return points;
    }
    public void setPoints(Collection<PointEntity> points) {
        this.points = points;
    }
    public TransportEntity getTransport() {
        return transport;
    }
    public void setTransport(TransportEntity transport) {
        this.transport = transport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripEntity that = (TripEntity) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuffer answer = new StringBuffer("Points: ");
        for(PointEntity p : points) {
            answer.append(p.getCityFrom().getName());
            answer.append(" - ");
        }
        answer.delete(answer.length()-2,answer.length());
        answer.append("\nDate: ");
        answer.append(date.toString());
        return String.valueOf(answer);
    }
}
