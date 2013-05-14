package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohGoodsArticle entity.
 */

@Entity
public class PohGoodsArticle extends GenericModel {

    // Fields
    @Id
    public Integer goodsId;
    public Integer articleId;
    public Short adminId;

}