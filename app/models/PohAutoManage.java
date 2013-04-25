package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohAutoManage entity.
 */

@Entity
public class PohAutoManage extends GenericModel {

    // Fields

    public Integer itemId;
    public String type;
    public Integer starttime;
    public Integer endtime;

}