package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohAdminUser entity.
 */

@Entity
public class PohAdminUser extends GenericModel {

    // Fields
    @Id
    public Long userId;
    public String userName;
    public String email;
    public String password;
    public String ecSalt;
    public Integer addTime;
    public Integer lastLogin;
    public String lastIp;
    public String actionList;
    public String navList;
    public String langType;
    public Short agencyId;
    public Short suppliersId;
    public String todolist;
    public Short roleId;

}