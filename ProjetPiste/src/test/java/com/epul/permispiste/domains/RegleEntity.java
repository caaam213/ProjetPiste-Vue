package com.epul.permispiste.domains;

import javax.persistence.*;

@Entity
@Table(name = "regle", schema = "projetpermis1", catalog = "")
public class RegleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "lib_regle")
    private String libRegle;
    @Basic
    @Column(name = "score_min")
    private Integer scoreMin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibRegle() {
        return libRegle;
    }

    public void setLibRegle(String libRegle) {
        this.libRegle = libRegle;
    }

    public Integer getScoreMin() {
        return scoreMin;
    }

    public void setScoreMin(Integer scoreMin) {
        this.scoreMin = scoreMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegleEntity that = (RegleEntity) o;

        if (id != that.id) return false;
        if (libRegle != null ? !libRegle.equals(that.libRegle) : that.libRegle != null) return false;
        if (scoreMin != null ? !scoreMin.equals(that.scoreMin) : that.scoreMin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libRegle != null ? libRegle.hashCode() : 0);
        result = 31 * result + (scoreMin != null ? scoreMin.hashCode() : 0);
        return result;
    }
}
