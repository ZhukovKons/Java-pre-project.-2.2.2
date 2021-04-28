package web.model;


public class Car {
    long id;
    String model;
    String serial;

    public Car() {
    }

    public Car(long id, String model, String serial) {
        this.id = id;
        this.model = model;
        this.serial = serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
