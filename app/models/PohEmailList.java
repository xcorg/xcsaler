package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohEmailList entity.
 */

@Entity
public class PohEmailList extends GenericModel {

    // Fields
    @Id
    public Integer id;
    public String email;
    public Boolean stat;
    public String hash;

}