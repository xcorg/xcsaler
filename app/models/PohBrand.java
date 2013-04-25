package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohBrand entity.
 */

@Entity
public class PohBrand extends GenericModel {

    // Fields

    public Short brandId;
    public String brandName;
    public String brandLogo;
    public String brandDesc;
    public String siteUrl;
    public Short sortOrder;
    public Boolean isShow;

}