package com.gromov.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "point", schema = "booking_tickets", catalog = "")
public class PointEntity {
    private int id;
    private int tripId;
    private int cityFromId;
    private int cityToId;
    private TripEntity tripByTripId;
    private CityEntity cityByCityFromId;
    private CityEntity cityByCityToId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tripID", nullable = false)
    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    @Basic
    @Column(name = "cityFromID", nullable = false)
    public int getCityFromId() {
        return cityFromId;
    }

    public void setCityFromId(int cityFromId) {
        this.cityFromId = cityFromId;
    }

    @Basic
    @Column(name = "cityToID", nullable = false)
    public int getCityToId() {
        return cityToId;
    }

    public void setCityToId(int cityToId) {
        this.cityToId = cityToId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointEntity that = (PointEntity) o;

        if (id != that.id) return false;
        if (tripId != that.tripId) return false;
        if (cityFromId != that.cityFromId) return false;
        if (cityToId != that.cityToId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + tripId;
        result = 31 * result + cityFromId;
        result = 31 * result + cityToId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "tripID", referencedColumnName = "id", nullable = false)
    public TripEntity getTripByTripId() {
        return tripByTripId;
    }

    public void setTripByTripId(TripEntity tripByTripId) {
        this.tripByTripId = tripByTripId;
    }

    @ManyToOne
    @JoinColumn(name = "cityFromID", referencedColumnName = "id", nullable = false)
    public CityEntity getCityByCityFromId() {
        return cityByCityFromId;
    }

    public void setCityByCityFromId(CityEntity cityByCityFromId) {
        this.cityByCityFromId = cityByCityFromId;
    }

    @ManyToOne
    @JoinColumn(name = "cityToID", referencedColumnName = "id", nullable = false)
    public CityEntity getCityByCityToId() {
        return cityByCityToId;
    }

    public void setCityByCityToId(CityEntity cityByCityToId) {
        this.cityByCityToId = cityByCityToId;
    }
}
