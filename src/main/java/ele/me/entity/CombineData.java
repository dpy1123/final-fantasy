package ele.me.entity;

import ele.me.csv.CsvData;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by dd on 16/11/3.
 */
@Entity
public class CombineData extends CsvData implements Serializable {
    @Id
    private String logId;

    //曝光信息
    private Boolean isSelect;
    private Integer dayNo;
    private String date;//[new]
    private Integer minutes;
    private String hoursInDay;//[new]
    private String elemeDeviceId;
    private Boolean isNew;
    private Float distance;//[combine]由用户和餐厅的x y算出
    private String userId;
    private String networkType;
    private String platform;
    private String brand;
    private String model;
    private String networkOperator;
    private String resolution;
    private String channel;

    //餐厅信息
    private String primaryCategory;
    private String foodNameList;
    private String categoryList;
    private Float agentFee;
    private Boolean isPremium;
    private String addressType;
    private Float goodRatingRate;
    private String openMonthNum;
    private Boolean hasImage;
    private Boolean hasFoodImg;
    private Integer minDeliverAmount;
    private Integer timeEnsureSpent;
    private Boolean isTimeEnsure;
    private Boolean isKa;
    private Boolean isTimeEnsureDiscount;
    private Boolean isElemeDeliver;
    private Float radius; //餐厅的配送半径
    private Boolean canDeliver; //[new] 是否可以配送(是否在配送半径内)
    private String buFlag;
    private String brandName;
    private Float serviceRating;
    private Boolean invoice;
    private Boolean onlinePayment;
    private Integer publicDegree;
    private Integer foodNum;
    private Integer foodImageNum;
    private Boolean isPromotionInfo;
    private Boolean isBookable;

    //结果
    @Column(name = "rst_index")
    private Integer index;//餐厅在列表中的排列位置
    private Boolean isClick;
    private Boolean isBuy;

    public CombineData() {}

    public CombineData(HistLog log, HistEnv env, Restaurant rst) {
        BeanUtils.copyProperties(log, this);
        BeanUtils.copyProperties(env, this);
        BeanUtils.copyProperties(rst, this);

        //特殊处理
        this.setDistance(calcDistance(env.getX(), env.getY(), rst.getX(), rst.getY()));
        this.setCanDeliver(this.getRadius()>=this.getDistance());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, this.getDayNo());
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        this.setDate(dateFm.format(calendar.getTime()));

        this.hoursInDay = String.valueOf(Math.round(this.getMinutes()/60.0));
    }

    private Float calcDistance(Float srcX, Float srcY, Float destX, Float destY) {
        return Float.valueOf((float) Math.sqrt(Math.pow(destX - srcX, 2) + Math.pow(destY - srcY, 2)));
    }


    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public Boolean getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Boolean select) {
        isSelect = select;
    }

    public Integer getDayNo() {
        return dayNo;
    }

    public void setDayNo(Integer dayNo) {
        this.dayNo = dayNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public String getHoursInDay() {
        return hoursInDay;
    }

    public void setHoursInDay(String hoursInDay) {
        this.hoursInDay = hoursInDay;
    }

    public String getElemeDeviceId() {
        return elemeDeviceId;
    }

    public void setElemeDeviceId(String elemeDeviceId) {
        this.elemeDeviceId = elemeDeviceId;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean aNew) {
        isNew = aNew;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNetworkOperator() {
        return networkOperator;
    }

    public void setNetworkOperator(String networkOperator) {
        this.networkOperator = networkOperator;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getPrimaryCategory() {
        return primaryCategory;
    }

    public void setPrimaryCategory(String primaryCategory) {
        this.primaryCategory = primaryCategory;
    }

    public String getFoodNameList() {
        return foodNameList;
    }

    public void setFoodNameList(String foodNameList) {
        this.foodNameList = foodNameList;
    }

    public String getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(String categoryList) {
        this.categoryList = categoryList;
    }

    public Float getAgentFee() {
        return agentFee;
    }

    public void setAgentFee(Float agentFee) {
        this.agentFee = agentFee;
    }

    public Boolean getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(Boolean premium) {
        isPremium = premium;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Float getGoodRatingRate() {
        return goodRatingRate;
    }

    public void setGoodRatingRate(Float goodRatingRate) {
        this.goodRatingRate = goodRatingRate;
    }

    public String getOpenMonthNum() {
        return openMonthNum;
    }

    public void setOpenMonthNum(String openMonthNum) {
        this.openMonthNum = openMonthNum;
    }

    public Boolean getHasImage() {
        return hasImage;
    }

    public void setHasImage(Boolean hasImage) {
        this.hasImage = hasImage;
    }

    public Boolean getHasFoodImg() {
        return hasFoodImg;
    }

    public void setHasFoodImg(Boolean hasFoodImg) {
        this.hasFoodImg = hasFoodImg;
    }

    public Integer getMinDeliverAmount() {
        return minDeliverAmount;
    }

    public void setMinDeliverAmount(Integer minDeliverAmount) {
        this.minDeliverAmount = minDeliverAmount;
    }

    public Integer getTimeEnsureSpent() {
        return timeEnsureSpent;
    }

    public void setTimeEnsureSpent(Integer timeEnsureSpent) {
        this.timeEnsureSpent = timeEnsureSpent;
    }

    public Boolean getTimeEnsure() {
        return isTimeEnsure;
    }

    public void setTimeEnsure(Boolean timeEnsure) {
        isTimeEnsure = timeEnsure;
    }

    public Boolean getIsKa() {
        return isKa;
    }

    public void setIsKa(Boolean ka) {
        isKa = ka;
    }

    public Boolean getIsTimeEnsureDiscount() {
        return isTimeEnsureDiscount;
    }

    public void setIsTimeEnsureDiscount(Boolean timeEnsureDiscount) {
        isTimeEnsureDiscount = timeEnsureDiscount;
    }

    public Boolean getIsElemeDeliver() {
        return isElemeDeliver;
    }

    public void setIsElemeDeliver(Boolean elemeDeliver) {
        isElemeDeliver = elemeDeliver;
    }

    public Float getRadius() {
        return radius;
    }

    public void setRadius(Float radius) {
        this.radius = radius;
    }

    public Boolean getCanDeliver() {
        return canDeliver;
    }

    public void setCanDeliver(Boolean canDeliver) {
        this.canDeliver = canDeliver;
    }

    public String getBuFlag() {
        return buFlag;
    }

    public void setBuFlag(String buFlag) {
        this.buFlag = buFlag;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Float getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(Float serviceRating) {
        this.serviceRating = serviceRating;
    }

    public Boolean getInvoice() {
        return invoice;
    }

    public void setInvoice(Boolean invoice) {
        this.invoice = invoice;
    }

    public Boolean getOnlinePayment() {
        return onlinePayment;
    }

    public void setOnlinePayment(Boolean onlinePayment) {
        this.onlinePayment = onlinePayment;
    }

    public Integer getPublicDegree() {
        return publicDegree;
    }

    public void setPublicDegree(Integer publicDegree) {
        this.publicDegree = publicDegree;
    }

    public Integer getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    public Integer getFoodImageNum() {
        return foodImageNum;
    }

    public void setFoodImageNum(Integer foodImageNum) {
        this.foodImageNum = foodImageNum;
    }

    public Boolean getIsPromotionInfo() {
        return isPromotionInfo;
    }

    public void setIsPromotionInfo(Boolean promotionInfo) {
        isPromotionInfo = promotionInfo;
    }

    public Boolean getIsBookable() {
        return isBookable;
    }

    public void setIsBookable(Boolean bookable) {
        isBookable = bookable;
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
