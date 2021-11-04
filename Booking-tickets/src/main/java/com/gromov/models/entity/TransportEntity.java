package com.gromov.models.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "transport", schema = "booking_tickets", catalog = "")
public class TransportEntity {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "number", nullable = false, length = 45)
    private String number;
    @Basic
    @Column(name = "amountOfSeats", nullable = false)
    private int amountOfSeats;
    @OneToMany(mappedBy = "transport")
    private Collection<TripEntity> trips;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public int getAmountOfSeats() {
        return amountOfSeats;
    }
    public void setAmountOfSeats(int amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }
    public Collection<TripEntity> getTrips() {
        return trips;
    }
    public void setTrips(Collection<TripEntity> trips) {
        this.trips = trips;
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
}
