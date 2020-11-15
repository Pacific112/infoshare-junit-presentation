package pl.infoshare.junit5;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DemoProcess {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer durationInSeconds;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }
}
