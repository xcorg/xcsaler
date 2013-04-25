package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohUserAddress entity.
 */

@Entity
public class PohUserAddress extends GenericModel {

    // Fields

    public Integer addressId;
    public String addressName;
    public Integer userId;
    public String consignee;
    public String email;
    public Short country;
    public Short province;
    public Short city;
    public Short district;
    public String address;
    public String zipcode;
    public String tel;
    public String mobile;
    public String signBuilding;
    public String bestTime;

}