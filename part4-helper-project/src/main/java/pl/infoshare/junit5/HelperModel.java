package pl.infoshare.junit5;

public class HelperModel {

    private final Integer id;
    private final String message;

    public HelperModel(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "HelperModel{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
