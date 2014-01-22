package com.pvt.jd2.project.common.domain;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 16:09
 */
public interface Address {

    void setId(Integer id);

    Integer getId();

    void setCountry(String country);

    String getCountry();

    void setCity(String city);

    String getCity();

    void setStreet(String street);

    String getStreet();

    void setApartment(String apartment);

    String getApartment();

}
