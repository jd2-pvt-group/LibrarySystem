package com.pvt.jd2.project.front.comparators;

import com.pvt.jd2.project.common.domain.Role;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 02.02.14
 * Time: 5:22
 */
public class RoleDataComparator implements Comparator<Role> {

    @Override
    public boolean compare(Role o1, Role o2) {
        if ((o1 == null)||(o2 == null)){
            return false;

        }
        return o1.getName().equals(o2.getName()) && o1.getDescription().equals(o2.getDescription());
    }

}
