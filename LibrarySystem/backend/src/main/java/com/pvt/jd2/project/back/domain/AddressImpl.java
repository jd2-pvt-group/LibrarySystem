package com.pvt.jd2.project.back.domain;

import com.pvt.jd2.project.common.domain.Address;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:11
 */
public class AddressImpl implements Serializable, Address {

    private Long id;
    private String country;
    private String city;
    private String street;
    private Integer apartment;

    public AddressImpl(){
    }

    @Override
    public void setId(Long integer) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    @Override
    public Integer getApartment() {
        return apartment;
    }
}
