package com.gromov.models.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "city", schema = "booking_tickets", catalog = "")
public class CityEntity {
    private int id;
    private String name;
    private int countryId;
    private CountryEntity countryByCountryId;
    private Collection<PointEntity> pointsById;
    private Collection<PointEntity> pointsById_0;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "countryID", nullable = false)
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (id != that.id) return false;
        if (countryId != that.countryId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + countryId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "countryID", referencedColumnName = "id", nullable = false)
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }

    @OneToMany(mappedBy = "cityByCityFromId")
    public Collection<PointEntity> getPointsById() {
        return pointsById;
    }

    public void setPointsById(Collection<PointEntity> pointsById) {
        this.pointsById = pointsById;
    }

    @OneToMany(mappedBy = "cityByCityToId")
    public Collection<PointEntity> getPointsById_0() {
        return pointsById_0;
    }

    public void setPointsById_0(Collection<PointEntity> pointsById_0) {
        this.pointsById_0 = pointsById_0;
    }
}
