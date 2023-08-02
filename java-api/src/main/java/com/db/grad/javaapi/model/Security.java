package com.db.grad.javaapi.model;
import java.util.Date; // Importing this to use for dates related to secuirities
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security")
public class Security {

    //#region privateFields

    // The type of security can be : CORP, GOVN, or SOVN
    private String securityType;
    // Date that the security will mature
    private Date securityMaturityDate;
    // Book on which this security currently sits
    private String securityBookName;
    // The security's status can be : active or inactive
    private String securityStatus;
    // The entity that is currently holding the security
    private String securityHolder;
    // The entity that issued the security
    private String securityIssuer;
    // ISIN number of security
    @Id
    private String securityIsin;
    // Face value of the security in millions
    private double securityFaceValue;
    // CUSIP number of security
    private String securityCusip;
    // Double that describes the percentage to be paid in interest by the issuer of the security
    private double securityCouponPercent;
    // Currency that the security was issued in
    private String securityCurrency;

    //#endregion
    //#region gettersSetters
    @Column(name = "type", nullable = false)
    public String getSecurityType() {
        return securityType;
    }
    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    @Column(name = "bond_maturity_date", nullable = false)
    public Date getSecurityMaturityDate() {
        return securityMaturityDate;
    }
    public void setSecurityMaturityDate(Date securityMaturityDate) {
        this.securityMaturityDate = securityMaturityDate;
    }

    @Column(name = "book_name", nullable = false)
    public String getSecurityBookName() {
        return securityBookName;
    }
    public void setSecurityBookName(String securityBookName) {
        this.securityBookName = securityBookName;
    }

    @Column(name = "status", nullable = false)
    public String getSecurityStatus() {
        return securityStatus;
    }
    public void setSecurityStatus(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    @Column(name = "bond_holder", nullable = false)
    public String getSecurityHolder() {
        return securityHolder;
    }
    public void setSecurityHolder(String securityHolder) {
        this.securityHolder = securityHolder;
    }

    @Column(name = "issuer_name", nullable = false)
    public String getSecurityIssuer() {
        return securityIssuer;
    }
    public void setSecurityIssuer(String securityIssuer) {
        this.securityIssuer = securityIssuer;
    }

    @Id
    @Column(name = "isin", nullable = false)
    public String getSecurityIsin() {
        return securityIsin;
    }
    public void setSecurityIsin(String securityIsin) {
        this.securityIsin = securityIsin;
    }

    @Column(name = "face_value_mn", nullable = false)
    public double getSecurityFaceValue() {
        return securityFaceValue;
    }
    public void setSecurityFaceValue(double securityFaceValue) {
        this.securityFaceValue = securityFaceValue;
    }

    @Column(name = "cusip", nullable = true)
    public String getSecurityCusip() {
        return securityCusip;
    }
    public void setSecurityCusip(String securityCusip) {
        this.securityCusip = securityCusip;
    }

    @Column(name = "coupon_percent", nullable = false)
    public double getSecurityCouponPercent() {
        return securityCouponPercent;
    }
    public void setSecurityCouponPercent(double securityCouponPercent) {
        this.securityCouponPercent = securityCouponPercent;
    }

    @Column(name = "trade_currency", nullable = false)
    public String getSecurityCurrency() {
        return securityCurrency;
    }
    public void setSecurityCurrency(String securityCurrency) {
        this.securityCurrency = securityCurrency;
    }
    //#endregion
    // //#region constructor
    // public Security(String securityType, Date securityMaturityDate, String securityBookName, String securityStatus,
    //         String securityHolder, String securityIssuer, String securityIsin, double securityFaceValue,
    //         String securityCusip, double securityCouponPercent, String securityCurrency) {
    //     this.securityType = securityType;
    //     this.securityMaturityDate = securityMaturityDate;
    //     this.securityBookName = securityBookName;
    //     this.securityStatus = securityStatus;
    //     this.securityHolder = securityHolder;
    //     this.securityIssuer = securityIssuer;
    //     this.securityIsin = securityIsin;
    //     this.securityFaceValue = securityFaceValue;
    //     this.securityCusip = securityCusip;
    //     this.securityCouponPercent = securityCouponPercent;
    //     this.securityCurrency = securityCurrency;
    // }   
    // //#endregion 
    
}
