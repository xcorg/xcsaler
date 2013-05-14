package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohGoodsGallery entity.
 */

@Entity
public class PohGoodsGallery extends GenericModel {

    // Fields
    @Id
    public Integer imgId;
    public Integer goodsId;
    public String imgUrl;
    public String imgDesc;
    public String thumbUrl;
    public String imgOriginal;

}