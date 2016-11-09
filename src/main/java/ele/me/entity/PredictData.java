package ele.me.entity;

import ele.me.csv.CsvData;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by dd on 16/11/7.
 */
@Entity
public class PredictData extends CsvData implements Serializable {
    @Id
    private String logId;

    private String userId;
    private Boolean isClick;
    private Boolean isBuy;

    public PredictData() {}

    public PredictData(CombineData data) {
        BeanUtils.copyProperties(data, this);
    }

    public PredictData(String logId, String userId, Boolean isClick, Boolean isBuy) {
        this.logId = logId;
        this.userId = userId;
        this.isClick = isClick;
        this.isBuy = isBuy;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
