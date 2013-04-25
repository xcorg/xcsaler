package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohSuppliers entity.
 */

@Entity
public class PohSuppliers extends GenericModel {

    // Fields

    public Short suppliersId;
    public String suppliersName;
    public String suppliersDesc;
    public Boolean isCheck;

}