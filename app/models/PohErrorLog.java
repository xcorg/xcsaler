package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohErrorLog entity.
 */

@Entity
public class PohErrorLog extends GenericModel {

    // Fields
    @Id
    public Integer id;
    public String info;
    public String file;
    public Integer time;

}