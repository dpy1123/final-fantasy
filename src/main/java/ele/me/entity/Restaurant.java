package ele.me.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by dd on 16/11/3.
 */
public class Restaurant {

    private String restaurantId;
    private String primaryCategory;
    private String foodNameList;
    private String categoryList;
    private Float x;
    private Float y;
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
    private Float radius;
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

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
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

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
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

    public Boolean getIsTimeEnsure() {
        return isTimeEnsure;
    }

    public void setIsTimeEnsure(Boolean timeEnsure) {
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
}
