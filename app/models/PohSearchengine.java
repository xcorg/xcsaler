package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohSearchengine entity.
 */

@Entity
public class PohSearchengine extends GenericModel {

    // Fields
    @Id
    public Date date;
    public String searchengine;
    public Integer count;

}