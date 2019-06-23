package br.com.mioto.cloud.vo;

import java.util.Date;

/**
 * Created by mioto on 11/06/17.
 */
public class Billing {

    private Integer paymentType;
    private Date paymentDate;

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
