package sample;

public class degreeModelTable {
    String deg,year,fac;

    public degreeModelTable(String deg, String fac, String year) {
        this.deg = deg;
        this.year = year;
        this.fac = fac;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }
}
