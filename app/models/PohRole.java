package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohRole entity.
 */

@Entity
public class PohRole extends GenericModel {

    // Fields
    @Id
    public Short roleId;
    public String roleName;
    public String actionList;
    public String roleDescribe;

}