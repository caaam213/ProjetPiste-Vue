package com.epul.permispiste.domains;

import javax.persistence.*;


@Entity
@Table(name = "action__objectif", schema = "projetpermis1", catalog = "")
public class ActionObjectifEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fk_action", insertable = false, updatable = false)
    private Integer fkAction;
    @Basic
    @Column(name = "fk_objectif", insertable = false, updatable = false)
    private Integer fkObjectif;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFkAction() {
        return fkAction;
    }

    public void setFkAction(Integer fkAction) {
        this.fkAction = fkAction;
    }

    public Integer getFkObjectif() {
        return fkObjectif;
    }

    public void setFkObjectif(Integer fkObjectif) {
        this.fkObjectif = fkObjectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionObjectifEntity that = (ActionObjectifEntity) o;

        if (id != that.id) return false;
        if (fkAction != null ? !fkAction.equals(that.fkAction) : that.fkAction != null) return false;
        if (fkObjectif != null ? !fkObjectif.equals(that.fkObjectif) : that.fkObjectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fkAction != null ? fkAction.hashCode() : 0);
        result = 31 * result + (fkObjectif != null ? fkObjectif.hashCode() : 0);
        return result;
    }
}

