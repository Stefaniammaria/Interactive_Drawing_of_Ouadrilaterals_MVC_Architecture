package Model.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="rezultat")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Rezultat implements Serializable {

    @javax.persistence.Id
    @Column(unique = true, nullable = false)
    @GeneratedValue
    private int Id;
    @Column(name = "rezultat")
    private int rezultat;

    public Rezultat(int rezultat) {
        this.rezultat = rezultat;
    }

}
