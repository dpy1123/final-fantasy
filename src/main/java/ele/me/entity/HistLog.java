package ele.me.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dd on 16/11/3.
 */
public class HistLog {

    private String logId;
    private String listId;
    private String restaurantId;
    private Integer index;
    private Boolean isClick;
    private Boolean isBuy;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getIsClick() {
        return isClick;
    }

    public void setIsClick(Boolean click) {
        isClick = click;
    }

    public Boolean getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(Boolean buy) {
        isBuy = buy;
    }
}
