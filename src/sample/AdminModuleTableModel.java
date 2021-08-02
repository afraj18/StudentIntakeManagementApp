package sample;

import javafx.beans.property.SimpleStringProperty;

public class AdminModuleTableModel {
    SimpleStringProperty id,moduleName,deg,fac,year;

    public AdminModuleTableModel(String id, String moduleName,
                                 String deg, String fac,String year) {
        this.id = new SimpleStringProperty(id);
        this.moduleName =new SimpleStringProperty( moduleName);
        this.deg = new SimpleStringProperty(deg);
        this.fac = new SimpleStringProperty(fac);
        this.year = new SimpleStringProperty(year);
    }

    public String getYear() {
        return year.get();
    }

    public SimpleStringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    public String getId() {
        return idProperty().get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getModuleName() {
        return moduleName.get();
    }

    public SimpleStringProperty moduleNameProperty() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName.set(moduleName);
    }

    public String getDeg() {
        return deg.get();
    }

    public SimpleStringProperty degProperty() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg.set(deg);
    }

    public String getFac() {
        return fac.get();
    }

    public SimpleStringProperty facProperty() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac.set(fac);
    }
}
