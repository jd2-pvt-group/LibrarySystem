package com.pvt.jd2.project.common.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 16:09
 */
public interface Address {

    void setId(Long id);

    Long getId();

    void setCountry(String country);

    String getCountry();

    void setCity(String city);

    String getCity();

    void setStreet(String street);

    String getStreet();

    void setApartment(Integer apartment);

    Integer getApartment();

}
