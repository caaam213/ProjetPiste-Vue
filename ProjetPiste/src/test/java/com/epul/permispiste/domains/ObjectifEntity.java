package com.epul.permispiste.domains;

import javax.persistence.*;

@Entity
@Table(name = "objectif", schema = "projetpermis1", catalog = "")
public class ObjectifEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "lib_objectif")
    private String libObjectif;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibObjectif() {
        return libObjectif;
    }

    public void setLibObjectif(String libObjectif) {
        this.libObjectif = libObjectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectifEntity that = (ObjectifEntity) o;

        if (id != that.id) return false;
        if (libObjectif != null ? !libObjectif.equals(that.libObjectif) : that.libObjectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libObjectif != null ? libObjectif.hashCode() : 0);
        return result;
    }
}
