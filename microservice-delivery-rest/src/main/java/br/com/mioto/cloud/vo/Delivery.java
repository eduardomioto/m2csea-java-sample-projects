package br.com.mioto.cloud.vo;

import java.util.Date;

/**
 * Created by mioto on 11/06/17.
 */
public class Delivery {

    private Fare fare;

    private Date deliveryDateScheduled;

    private Date deliveryDateExecuted;

    private String receivedBy;

    private String address;

    private String city;

    private String reference;

    public Date getDeliveryDateScheduled() {
        return deliveryDateScheduled;
    }

    public void setDeliveryDateScheduled(Date deliveryDateScheduled) {
        this.deliveryDateScheduled = deliveryDateScheduled;
    }

    public Date getDeliveryDateExecuted() {
        return deliveryDateExecuted;
    }

    public void setDeliveryDateExecuted(Date deliveryDateExecuted) {
        this.deliveryDateExecuted = deliveryDateExecuted;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }
}
