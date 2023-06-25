package com.epul.permispiste.dto;

import com.epul.permispiste.domains.ActionMissionEntity;
import com.epul.permispiste.domains.InscriptionEntity;

import java.util.Collection;

public class MissionDTO {
    private int id;
    private String wording;

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


}

