package com.blakoo;

public class CouponCategory {

    private String mStoreName;

    private String mCouponShortDescription;

    private String mPromoCode;

    private String mRating;

    private String mGotoStore;

    public CouponCategory(String storeName, String couponShortDescription, String promoCode, String rating, String gotoStore) {
        mStoreName = storeName;
        mCouponShortDescription = couponShortDescription;
        mPromoCode = promoCode;
        mRating = rating;
        mGotoStore = gotoStore;
    }

    //** Get the details of the coupon code*/
    public String getStoreName() { return mStoreName; }

    public String getCouponShortDescription() { return mCouponShortDescription; }

    public String getPromoCode() { return mPromoCode; }

    public String getRating() { return mRating; }

    public String getDescription() { return mGotoStore; }

}
