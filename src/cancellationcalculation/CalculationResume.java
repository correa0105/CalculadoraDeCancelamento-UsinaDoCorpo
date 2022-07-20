package cancellationcalculation;
import java.util.Date;

public class CalculationResume {

    private Date initialDate;
    private Date finalDate;
    private double monthPrice;
    private double planPrice;
    private double dayValue;
    private double valueUtilized;
    private double valueFine;
    private double valueReturned;
    private double medicalCertificate;
    private long diffDate;
    
    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }

    public long getDiffDate() {
        return diffDate;
    }

    public void setDiffDate(long diffDate) {
        this.diffDate = diffDate;
    }

    public double getMonthPrice() {
        return monthPrice;
    }

    public void setMonthPrice(double monthPrice) {
        this.monthPrice = monthPrice;
    }

    public double getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(double planPrice) {
        this.planPrice = planPrice;
    }

    public double getValueReturned() {
        return valueReturned;
    }

    public void setValueReturned(double valueReturned) {
        this.valueReturned = valueReturned;
    }

    public double getValueUtilized() {
        return valueUtilized;
    }

    public void setValueUtilized(double valueUtilized) {
        this.valueUtilized = valueUtilized;
    }

    public double getMedicalCertificate() {
        return medicalCertificate;
    }

    public void setMedicalCertificate(double medicalCertificate) {
        this.medicalCertificate = medicalCertificate;
    }
    
    public double getDayValue() {
        return dayValue;
    }

    public void setDayValue(double dayValue) {
        this.dayValue = dayValue;
    }

    public double getValueFine() {
        return valueFine;
    }

    public void setValueFine(double valueFine) {
        this.valueFine = valueFine;
    }

    public void subtrationDate(Date initialDate, Date finalDate, double medicalCertificate) {
        this.setInitialDate(initialDate);
        this.setFinalDate(finalDate);
        this.setMedicalCertificate(medicalCertificate);

        long dt = (this.getFinalDate().getTime() - this.getInitialDate().getTime()) + 3600000;

        this.setDiffDate((long) (((dt / 86400000L)+1)-this.getMedicalCertificate()));
    }

    public void dayValue(double monthPrice) {
        this.setMonthPrice(monthPrice);
        this.setDayValue(this.getMonthPrice() / 30);
    }
    
    public void valueUtilized() {
        this.setValueUtilized(this.getDayValue() * this.getDiffDate());
    }
    
    public void returnedFine(double planPrice, double valueFine) {
        this.setPlanPrice(planPrice);
        this.setValueFine(valueFine / 100);
        this.setValueFine((this.getPlanPrice() - this.getValueUtilized())* this.getValueFine());
    }
    
    public void returnedValue (double monthPrice, double planPrice) {
        this.setMonthPrice(monthPrice);
        this.setPlanPrice(planPrice);
        
        this.setValueReturned((this.getPlanPrice() - this.getValueUtilized()) - this.getValueFine());
    }    
}
