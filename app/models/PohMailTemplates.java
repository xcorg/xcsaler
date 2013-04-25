package models;

import javax.persistence.Entity;

import play.db.jpa.GenericModel;

/**
 * PohMailTemplates entity.
 */

@Entity
public class PohMailTemplates extends GenericModel {

    // Fields
    public Boolean templateId;
    public String templateCode;
    public Boolean isHtml;
    public String templateSubject;
    public String templateContent;
    public Integer lastModify;
    public Integer lastSend;
    public String type;

}