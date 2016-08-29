package com.shc.ahttp.client.testpojo;

public class HttpBinPostRequest {

    private String referenceID;
    private String bodID;
    private String country;

    
    public HttpBinPostRequest() {
        super();
    }

    public HttpBinPostRequest(String referenceID, String bodID, String country) {
        super();
        this.referenceID = referenceID;
        this.bodID = bodID;
        this.country = country;
    }

    public String getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(String referenceID) {
        this.referenceID = referenceID;
    }

    public String getBodID() {
        return bodID;
    }

    public void setBodID(String bodID) {
        this.bodID = bodID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "HttpBinPostRequest [referenceID=" + referenceID + ", bodID="
                + bodID + ", country=" + country + "]";
    }

}
