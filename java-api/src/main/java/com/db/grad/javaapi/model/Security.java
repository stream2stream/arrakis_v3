package com.db.grad.javaapi.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name="Security")
public class Security {
    @Id
    private int ID;
    private String Isin;
    private String Cusip;
    private Date Maturity_date;
    private String Issuer;
    private float coupon;
    private String Type;
    private float Face_Value;
    private String Currency;
    private String Status;
    @Id
    @Column(name= "security_id", nullable = false)
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    @Column(name="isin", nullable = true)
    public String getIsin() {
        return Isin;
    }

    public void setIsin(String isin) {
        Isin = isin;
    }
    @Column(name="cusip", nullable = true)
    public String getCusip() {
        return Cusip;
    }

    public void setCusip(String cusip) {
        Cusip = cusip;
    }

    @Column(name="maturity_date", nullable = false)
    public Date getMaturity_date() {
        return Maturity_date;
    }

    public void setMaturity_date(Date maturity_date) {
        Maturity_date = maturity_date;
    }
    @Column(name="issuer_name", nullable = false)
    public String getIssuer(){
        return Issuer;
    }
    public void setIssuer(String Issuer){
        this.Issuer=Issuer;
    }

    @Column(name="coupon", nullable = true)
    public float getCoupon() {
        return coupon;
    }

    public void setCoupon(float coupon) {
        this.coupon = coupon;
    }

    @Column(name="type", nullable = false)
    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
    @Column(name="facevalue", nullable = false)
    public float getFace_Value() {
        return Face_Value;
    }

    public void setFace_Value(float face_Value) {
        Face_Value = face_Value;
    }

    @Column(name="bondcurrency")
    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    @Column(name="status", nullable = false)
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Security{" +
                "ID=" + ID +
                ", Isin='" + Isin + '\'' +
                ", Cusip='" + Cusip + '\'' +
                ", Maturity_date=" + Maturity_date +
                ", coupon=" + coupon +
                ", Type='" + Type + '\'' +
                ", Face_Value=" + Face_Value +
                ", Currency='" + Currency + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
