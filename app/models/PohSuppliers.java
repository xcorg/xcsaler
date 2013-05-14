package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohSuppliers entity.
 */

@Entity
public class PohSuppliers extends GenericModel {

    // Fields
    @Id
    public Short suppliersId;
    public String suppliersName;
    public String suppliersDesc;
    public Boolean isCheck;

}