package com.epul.permispiste.domains;

import javax.persistence.*;

@Entity
@Table(name = "mission__objectif", schema = "projetpermis1", catalog = "")
public class MissionObjectifEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "fk_mission")
    private Integer fkMission;
    @Basic
    @Column(name = "fk_objectif")
    private Integer fkObjectif;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getFkMission() {
        return fkMission;
    }

    public void setFkMission(Integer fkMission) {
        this.fkMission = fkMission;
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

        MissionObjectifEntity that = (MissionObjectifEntity) o;

        if (id != that.id) return false;
        if (fkMission != null ? !fkMission.equals(that.fkMission) : that.fkMission != null) return false;
        if (fkObjectif != null ? !fkObjectif.equals(that.fkObjectif) : that.fkObjectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (fkMission != null ? fkMission.hashCode() : 0);
        result = 31 * result + (fkObjectif != null ? fkObjectif.hashCode() : 0);
        return result;
    }
}
