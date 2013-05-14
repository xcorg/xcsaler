package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohNav entity.
 */

@Entity
public class PohNav extends GenericModel {

    // Fields
    @Id
    public Integer id;
    public String ctype;
    public Short cid;
    public String name;
    public Boolean ifshow;
    public Boolean vieworder;
    public Boolean opennew;
    public String url;
    public String type;

}