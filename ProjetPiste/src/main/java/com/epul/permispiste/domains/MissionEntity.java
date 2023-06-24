
package com.epul.permispiste.domains;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "mission", schema = "projetpermis1", catalog = "")
public class MissionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "wording")
    private String wording;
    @OneToMany(mappedBy = "missionByFkMission", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ActionMissionEntity> actionMissionsById;
    @OneToMany(mappedBy = "missionByFkMission", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<InscriptionEntity> inscriptionsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissionEntity that = (MissionEntity) o;

        if (id != that.id) return false;
        if (wording != null ? !wording.equals(that.wording) : that.wording != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wording != null ? wording.hashCode() : 0);
        return result;
    }

    public Collection<ActionMissionEntity> getActionMissionsById() {
        return actionMissionsById;
    }

    public void setActionMissionsById(Collection<ActionMissionEntity> actionMissionsById) {
        this.actionMissionsById = actionMissionsById;
    }

    public Collection<InscriptionEntity> getInscriptionsById() {
        return inscriptionsById;
    }

    public void setInscriptionsById(Collection<InscriptionEntity> inscriptionsById) {
        this.inscriptionsById = inscriptionsById;
    }
}

