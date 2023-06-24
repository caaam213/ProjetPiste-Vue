
package com.epul.permispiste.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "action", schema = "projetpermis1", catalog = "")
public class ActionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fk_action", insertable = false, updatable = false)
    private Integer fkAction;
    @Basic
    @Column(name = "wording")
    private String wording;
    @Basic
    @Column(name = "score_minimum")
    private Integer scoreMinimum;

    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id")
    private ActionEntity actionByFkAction;
    @OneToMany(mappedBy = "actionByFkAction", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ActionEntity> actionsById;
    @OneToMany(mappedBy = "actionByFkAction", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ActionJeuEntity> actionJeusById;
    @OneToMany(mappedBy = "actionByFkAction", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ActionMissionEntity> actionMissionsById;
    @OneToMany(mappedBy = "actionByFkAction", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<IndicatorEntity> indicatorsById;
    @OneToMany(mappedBy = "actionByFkAction", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<InscriptionActionEntity> inscriptionActionsById;

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

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public Integer getScoreMinimum() {
        return scoreMinimum;
    }

    public void setScoreMinimum(Integer scoreMinimum) {
        this.scoreMinimum = scoreMinimum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionEntity that = (ActionEntity) o;

        if (id != that.id) return false;
        if (fkAction != null ? !fkAction.equals(that.fkAction) : that.fkAction != null) return false;
        if (wording != null ? !wording.equals(that.wording) : that.wording != null) return false;
        if (scoreMinimum != null ? !scoreMinimum.equals(that.scoreMinimum) : that.scoreMinimum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fkAction != null ? fkAction.hashCode() : 0);
        result = 31 * result + (wording != null ? wording.hashCode() : 0);
        result = 31 * result + (scoreMinimum != null ? scoreMinimum.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    public ActionEntity getActionByFkAction() {
        return actionByFkAction;
    }

    public void setActionByFkAction(ActionEntity actionByFkAction) {
        this.actionByFkAction = actionByFkAction;
    }

    public Collection<ActionEntity> getActionsById() {
        return actionsById;
    }

    public void setActionsById(Collection<ActionEntity> actionsById) {
        this.actionsById = actionsById;
    }

    public Collection<ActionJeuEntity> getActionJeusById() {
        return actionJeusById;
    }

    public void setActionJeusById(Collection<ActionJeuEntity> actionJeusById) {
        this.actionJeusById = actionJeusById;
    }

    public Collection<ActionMissionEntity> getActionMissionsById() {
        return actionMissionsById;
    }

    public void setActionMissionsById(Collection<ActionMissionEntity> actionMissionsById) {
        this.actionMissionsById = actionMissionsById;
    }

    public Collection<IndicatorEntity> getIndicatorsById() {
        return indicatorsById;
    }

    public void setIndicatorsById(Collection<IndicatorEntity> indicatorsById) {
        this.indicatorsById = indicatorsById;
    }

    public Collection<InscriptionActionEntity> getInscriptionActionsById() {
        return inscriptionActionsById;
    }

    public void setInscriptionActionsById(Collection<InscriptionActionEntity> inscriptionActionsById) {
        this.inscriptionActionsById = inscriptionActionsById;
    }
}

