package hiber.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*@OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;*/
    @Column
    private String model;
    @Column
    private int series;

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

    /*public void setUser(User user) {
        this.user = user;
    }*/

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    /*public User getUser() {
        return user;
    }*/

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

}
