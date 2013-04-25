package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohSearchengine entity.
 */

@Entity
public class PohSearchengine extends GenericModel {

    // Fields

    public Date date;
    public String searchengine;
    public Integer count;

}