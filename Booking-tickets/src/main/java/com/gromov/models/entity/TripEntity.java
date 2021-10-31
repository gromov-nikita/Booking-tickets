package com.gromov.models.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "trip", schema = "booking_tickets", catalog = "")
public class TripEntity {
    private int id;
    private Timestamp date;
    private int transportId;
    private Collection<OrderEntity> ordersById;
    private Collection<PointEntity> pointsById;
    private TransportEntity transportByTransportId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "transportID", nullable = false)
    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripEntity that = (TripEntity) o;

        if (id != that.id) return false;
        if (transportId != that.transportId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + transportId;
        return result;
    }

    @OneToMany(mappedBy = "tripByTripId")
    public Collection<OrderEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrderEntity> ordersById) {
        this.ordersById = ordersById;
    }

    @OneToMany(mappedBy = "tripByTripId")
    public Collection<PointEntity> getPointsById() {
        return pointsById;
    }

    public void setPointsById(Collection<PointEntity> pointsById) {
        this.pointsById = pointsById;
    }

    @ManyToOne
    @JoinColumn(name = "transportID", referencedColumnName = "id", nullable = false)
    public TransportEntity getTransportByTransportId() {
        return transportByTransportId;
    }

    public void setTransportByTransportId(TransportEntity transportByTransportId) {
        this.transportByTransportId = transportByTransportId;
    }
}
