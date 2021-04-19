package ee.bcs.valiit.dto;

public class Employee {

    private String nimi;
    private String elukoht;
    private int aasta;

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getElukoht() {
        return elukoht;
    }

    public void setElukoht(String elukoht) {
        this.elukoht = elukoht;
    }

    public int getAasta() {
        return aasta;
    }

    public void setAasta(int aasta) {
        this.aasta = aasta;
    }
}
