package com.epul.permispiste.dto;

public class ActionDTO {
    private int idAction;
    private String wording;
    private Integer scoreMin;

    public ActionDTO() {
    }

    public ActionDTO(int idAction, String wording, Integer scoreMin) {
        this.idAction = idAction;
        this.wording = wording;
        this.scoreMin = scoreMin;
    }

    public int getIdAction() {
        return idAction;
    }

    public void setIdAction(int idAction) {
        this.idAction = idAction;
    }

    public String getWording() {
        return wording;
    }

    public void setWording(String wording) {
        this.wording = wording;
    }

    public Integer getScoreMin() {
        return scoreMin;
    }

    public void setScoreMin(Integer scoreMin) {
        this.scoreMin = scoreMin;
    }
}
