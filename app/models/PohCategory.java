package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

/**
 * PohCategory entity.
 */

@Entity
public class PohCategory extends Model {

    // Fields
    // @Id
    // public Long catId;
    @Required
    @Column(nullable = false)
    public String name;
    public String keywords;
    public String info;
    
    @Required
    @Column(nullable = false)
    public Long parentId;
    public String sortOrder;
    public String templateFile;
    public String measureUnit;
    public String showInNav;
    public String style;
    public String isShow; // 1：显示
    public Short grade;
    public String filterAttr;

    // @Transient
    // private static Map<String, Object> topId = new HashMap<String, Object>();

    public static List<PohCategory> topclass() {
        List<PohCategory> topClassList = PohCategory.find("parentId=0 and isShow=1 order by id").fetch();
        return topClassList;
    }

    public static List<PohCategory> syclass() {
        List<PohCategory> syClassList = PohCategory.find("parentId>0 and isShow=1").fetch();
        return syClassList;
    }

    public static Map<Object, Object> allClass() {
        List<PohCategory> allClassList = PohCategory.find("isShow=1 order by parentId").fetch();

        Map<Object, Object> allMap = new HashMap<Object, Object>();
        List<Object> topIdList = new ArrayList<Object>();
        for (PohCategory category : allClassList) {

            Long parentId = category.parentId;
            // String pid = parentId.toString();
            if (parentId == 0) {
                topIdList.add(category.id);
            } else {
                if (allMap.containsKey(parentId)) {
                    // ((List<PohCategory>) ((Map<String, Object>) allMap.get(parentId)).get("children")).add(category);
                    ((List<PohCategory>) allMap.get(parentId)).add(category);
                } else {
                    List<PohCategory> tempList = new ArrayList<PohCategory>();
                    tempList.add(category);
                    // Map<String, Object> tempMap = new HashMap<String, Object>();
                    // tempMap.put("name", value);

                    allMap.put(parentId, tempList);
                }
            }
        }

        allMap.put("top", topIdList);

        return allMap;
    }
}