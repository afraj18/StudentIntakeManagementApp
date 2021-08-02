package sample;

public class AvailableFacultyModelTable {
    String fac,maxStu;

    public AvailableFacultyModelTable(String fac, String maxStu) {
        this.fac = fac;
        this.maxStu = maxStu;
    }

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public String getMaxStu() {
        return maxStu;
    }

    public void setMaxStu(String maxStu) {
        this.maxStu = maxStu;
    }
}
