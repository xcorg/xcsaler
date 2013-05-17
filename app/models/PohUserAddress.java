package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohUserAddress entity.
 */

@Entity
public class PohUserAddress extends GenericModel {

    // Fields
    @Id
    public Integer addressId;
    public String addressName;
    public Long userId;
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