package com.epul.permispiste.dto;

public class ActionMissionDTO {
    private int fkAction;
    private int fkMission;

    public ActionMissionDTO() {
    }

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
}
