package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohCatRecommend entity.
 */

@Entity
public class PohCatRecommend extends GenericModel {

    // Fields
    @Id
    public Short catId;
    public Boolean recommendType;

}