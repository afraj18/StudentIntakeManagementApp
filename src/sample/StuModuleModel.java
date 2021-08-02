package sample;

public class StuModuleModel {
    String module,credit,degree,year;

    public StuModuleModel(String module, String credit, String degree, String year) {
        this.module = module;
        this.credit = credit;
        this.degree = degree;
        this.year = year;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
