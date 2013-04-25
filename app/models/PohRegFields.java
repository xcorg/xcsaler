package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohRegFields entity.
 */

@Entity
public class PohRegFields extends GenericModel {

    // Fields

    public Short id;
    public String regFieldName;
    public Short disOrder;
    public Boolean display;
    public Boolean type;
    public Boolean isNeed;

}