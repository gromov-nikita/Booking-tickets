package com.gromov.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "point", schema = "booking_tickets", catalog = "")
public class PointEntity {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "tripID", referencedColumnName = "id")
    private TripEntity trip;
    @ManyToOne
    @JoinColumn(name = "cityFromID", referencedColumnName = "id")
    private CityEntity cityFrom;
    @ManyToOne
    @JoinColumn(name = "cityToID", referencedColumnName = "id")
    private CityEntity cityTo;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public CityEntity getCityFrom() {
        return cityFrom;
    }
    public void setCityFrom(CityEntity cityFrom) {
        this.cityFrom = cityFrom;
    }
    public CityEntity getCityTo() {
        return cityTo;
    }
    public void setCityTo(CityEntity cityTo) {
        this.cityTo = cityTo;
    }
    public TripEntity getTrip() {
        return trip;
    }
    public void setTrip(TripEntity trip) {
        this.trip = trip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointEntity that = (PointEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        return result;
    }
}
