package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohGoodsArticle entity.
 */

@Entity
public class PohGoodsArticle extends GenericModel {

    // Fields

    public Integer goodsId;
    public Integer articleId;
    public Short adminId;

}