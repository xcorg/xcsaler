package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.jpa.GenericModel;

/**
 * PohEmailSendlist entity.
 */

@Entity
public class PohEmailSendlist extends GenericModel {

    // Fields
    @Id
    public Integer id;
    public String email;
    public Integer templateId;
    public String emailContent;
    public Boolean error;
    public Short pri;
    public Integer lastSend;

}