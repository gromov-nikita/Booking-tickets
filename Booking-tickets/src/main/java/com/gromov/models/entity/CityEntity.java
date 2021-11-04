package com.gromov.models.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "city", schema = "booking_tickets", catalog = "")
public class CityEntity {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @ManyToOne
    @JoinColumn(name = "countryID",referencedColumnName = "id")
    private CountryEntity country;
    @OneToMany(mappedBy = "cityFrom", targetEntity = PointEntity.class)
    private Collection<PointEntity> citiesFrom;
    @OneToMany(mappedBy = "cityTo", targetEntity = PointEntity.class)
    private Collection<PointEntity> citiesTo;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public CountryEntity getCountry() {
        return country;
    }
    public void setCountry(CountryEntity country) {
        this.country = country;
    }
    public Collection<PointEntity> getCitiesFrom() {
        return citiesFrom;
    }
    public void setCitiesFrom(Collection<PointEntity> citiesFrom) {
        this.citiesFrom = citiesFrom;
    }
    public Collection<PointEntity> getCitiesTo() {
        return citiesTo;
    }
    public void setCitiesTo(Collection<PointEntity> citiesTo) {
        this.citiesTo = citiesTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityEntity that = (CityEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
