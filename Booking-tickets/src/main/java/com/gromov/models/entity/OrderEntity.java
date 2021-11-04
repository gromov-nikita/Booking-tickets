package com.gromov.models.entity;

import com.gromov.models.enums.Status;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "order", schema = "booking_tickets", catalog = "")
public class OrderEntity {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "seat", nullable = false)
    private int seat;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Basic
    @Enumerated
    @Column(name = "status", nullable = false)
    private Status status;
    @OneToMany(mappedBy = "order")
    private Collection<CommentEntity> comments;
    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "tripID", referencedColumnName = "id")
    private TripEntity otrip;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    public TripEntity getOtrip() {
        return otrip;
    }
    public void setOtrip(TripEntity otrip) {
        this.otrip = otrip;
    }
    public Collection<CommentEntity> getCommentsById() {
        return comments;
    }
    public void setCommentsById(Collection<CommentEntity> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != that.id) return false;
        if (seat != that.seat) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + seat;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

}
