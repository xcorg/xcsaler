package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohAutoManage entity.
 */

@Entity
public class PohAutoManage extends GenericModel {

    // Fields
    @Id
    public Integer itemId;
    public String type;
    public Integer starttime;
    public Integer endtime;

}