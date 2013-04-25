package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohCatRecommend entity.
 */

@Entity
public class PohCatRecommend extends GenericModel {

    // Fields

    public Short catId;
    public Boolean recommendType;

}