package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Students {
    private StringProperty id;
    private StringProperty name;

    Students(String id,String name){
        this.id = new SimpleStringProperty(id);
        this.name=new SimpleStringProperty(name);
    }

    public String getId() {
        return idProperty().get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        idProperty().set(id);
    }

    public String getName() {
        return nameProperty().get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        nameProperty().set(name);
    }

}

