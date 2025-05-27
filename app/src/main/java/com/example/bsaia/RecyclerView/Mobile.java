package com.example.bsaia.RecyclerView;

//this is our model class
public class Mobile {

    private String mobileName,mobileCompany,mobilePrice;
    //alt+insert
    public Mobile(String mobileName, String mobileCompany, String mobilePrice) {
        this.mobileName = mobileName;
        this.mobileCompany = mobileCompany;
        this.mobilePrice = mobilePrice;
    }
    //alt+insert

    public Mobile() {

    }
    //alt+insert

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getMobilePrice() {
        return mobilePrice;
    }

    public void setMobilePrice(String mobilePrice) {
        this.mobilePrice = mobilePrice;
    }

    public String getMobileCompany() {
        return mobileCompany;
    }

    public void setMobileCompany(String mobileCompany) {
        this.mobileCompany = mobileCompany;
    }
}
