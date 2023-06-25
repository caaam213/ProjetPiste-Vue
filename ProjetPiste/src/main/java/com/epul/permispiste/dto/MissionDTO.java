package com.epul.permispiste.dto;

import com.epul.permispiste.domains.ActionMissionEntity;
import com.epul.permispiste.domains.InscriptionEntity;

import java.util.Collection;

public class MissionDTO {
    private int id;
    private String wording;
    private Collection<ActionMissionEntity> actionMissions;
    private Collection<InscriptionEntity> inscriptions;

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

    public Collection<ActionMissionEntity> getActionMissions() {
        return actionMissions;
    }

    public void setActionMissions(Collection<ActionMissionEntity> actionMissions) {
        this.actionMissions = actionMissions;
    }

    public Collection<InscriptionEntity> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Collection<InscriptionEntity> inscriptions) {
        this.inscriptions = inscriptions;
    }
}

