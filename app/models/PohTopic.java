package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohTopic entity.
 */

@Entity
public class PohTopic extends GenericModel {

    // Fields
    @Id
    public Integer topicId;
    public String title;
    public String intro;
    public Integer startTime;
    public Integer endTime;
    public String data;
    public String template;
    public String css;
    public String topicImg;
    public String titlePic;
    public String baseStyle;
    public String htmls;
    public String keywords;
    public String description;

}