package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohArticle entity.
 */

@Entity
public class PohArticle extends GenericModel {

    // Fields

    public Integer articleId;
    public Short catId;
    public String title;
    public String content;
    public String author;
    public String authorEmail;
    public String keywords;
    public Boolean articleType;
    public Boolean isOpen;
    public Integer addTime;
    public String fileUrl;
    public Boolean openType;
    public String link;
    public String description;

}