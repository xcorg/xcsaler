package models;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class PohAppConfig extends Model {
    
    public String title;
    
    @Column(name = "description", length = 500)
    public String description;
    
    @Column(name = "keywords", length = 500)
    public String keywords;

    public static PohAppConfig appConfig(){
        return PohAppConfig.find("").first();
    }
}
