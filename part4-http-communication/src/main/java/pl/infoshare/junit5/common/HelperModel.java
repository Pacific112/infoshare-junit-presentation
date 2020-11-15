package pl.infoshare.junit5.common;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HelperModel that = (HelperModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }

    @Override
    public String toString() {
        return "HelperModel{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
