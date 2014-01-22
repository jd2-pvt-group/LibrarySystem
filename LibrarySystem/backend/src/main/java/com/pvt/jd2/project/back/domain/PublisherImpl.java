package com.pvt.jd2.project.back.domain;

import com.pvt.jd2.project.common.domain.Address;
import com.pvt.jd2.project.common.domain.Publisher;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 17:27
 */
public class PublisherImpl implements Publisher {

    private Integer id;
    private String name;
    private Address address;

    public PublisherImpl(){
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Address getAddress() {
        return address;
    }
}
