package com.blakoo;

public class CouponHomepage {

    //** Init. for Fragment in homepage 3 Tab.

    //** Resource for logostore */
    private String mLogostore;

    //** Resource for coupontitle */
    private String mCoupontitle;

    /**
     *
     * @param logostore return the store logo.
     * @param coupontitle return the title of the coupon code.
     */
    public CouponHomepage(String logostore, String coupontitle){
        mLogostore = logostore;
        mCoupontitle = coupontitle;
    }

    //** Get Logo for the store */
    public String getLogostore() {
        return mLogostore;
    }

    //** Get title for the coupon code */
    public String getCoupontitle() {
        return mCoupontitle;
    }

}
