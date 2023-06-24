package com.epul.permispiste.domains;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class ActionMissionEntityPK implements Serializable {
    @Column(name = "fk_action")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fkAction;
    @Column(name = "fk_mission")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fkMission;

    public int getFkAction() {
        return fkAction;
    }

    public void setFkAction(int fkAction) {
        this.fkAction = fkAction;
    }

    public int getFkMission() {
        return fkMission;
    }

    public void setFkMission(int fkMission) {
        this.fkMission = fkMission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionMissionEntityPK that = (ActionMissionEntityPK) o;

        if (fkAction != that.fkAction) return false;
        if (fkMission != that.fkMission) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fkAction;
        result = 31 * result + fkMission;
        return result;
    }
}
