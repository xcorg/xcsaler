package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohEmailList entity.
 */

@Entity
public class PohEmailList extends GenericModel {

    // Fields

    public Integer id;
    public String email;
    public Boolean stat;
    public String hash;

}