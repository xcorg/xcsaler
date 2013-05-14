package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohKeywords entity.
 */

@Entity
public class PohKeywords extends GenericModel {

    // Fields
    @Id
    public Date date;
    public String searchengine;
    public String keyword;

    public Integer count;

}