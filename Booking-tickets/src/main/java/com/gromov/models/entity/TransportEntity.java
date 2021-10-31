package com.gromov.models.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "transport", schema = "booking_tickets", catalog = "")
public class TransportEntity {
    private int id;
    private String number;
    private int amountOfSeats;
    private Collection<TripEntity> tripsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = false, length = 45)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "amountOfSeats", nullable = false)
    public int getAmountOfSeats() {
        return amountOfSeats;
    }

    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransportEntity that = (TransportEntity) o;

        if (id != that.id) return false;
        if (amountOfSeats != that.amountOfSeats) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + amountOfSeats;
        return result;
    }

    @OneToMany(mappedBy = "transportByTransportId")
    public Collection<TripEntity> getTripsById() {
        return tripsById;
    }

    public void setTripsById(Collection<TripEntity> tripsById) {
        this.tripsById = tripsById;
    }
}
