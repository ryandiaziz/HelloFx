package id.dojo.hellofx.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Todo {
    private StringProperty activity;

    public Todo(String activity){
        this.activity = new SimpleStringProperty(activity);
    }

    public void setActivity(String activity) {
        this.activity.set(activity);
    }

    public StringProperty getActivity() {
        return activity;
    }
}
