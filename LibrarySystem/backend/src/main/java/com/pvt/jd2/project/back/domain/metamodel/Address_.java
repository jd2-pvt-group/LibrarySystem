package com.pvt.jd2.project.back.domain.metamodel;

import com.pvt.jd2.project.common.domain.Address;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 22.01.14
 * Time: 19:42
 */
@StaticMetamodel(Address.class)
public class Address_ {

    public static volatile SingularAttribute<Address, Long> id;
    public static volatile SingularAttribute<Address, String> country;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, Integer> apartment;


}
