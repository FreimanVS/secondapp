package com.freimanvs.secondapp.guessnumber.entities;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "guesser", schema = "guessnumber",
        uniqueConstraints={
                @UniqueConstraint(columnNames={"name"})
        })
public class Guesser implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotBlank
    @Length(min = 2, max = 100)
    @Column(name="name", unique = true)
    private String name;

    @Max(3)
    @Column(name="count")
    private Byte count = 1;

    public Guesser() {
    }

    public Guesser(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getCount() {
        return count;
    }

    public void setCount(Byte count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guesser guesser = (Guesser) o;
        return Objects.equals(id, guesser.id) &&
                Objects.equals(name, guesser.name) &&
                Objects.equals(count, guesser.count);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, count);
    }
}
