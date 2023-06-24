package com.epul.permispiste.dto;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.IndicatorEntity;

import java.util.List;

public class IndicatorsActions {

    public ActionEntity action;
    public List<IndicatorEntity> indicators;

    public IndicatorsActions(ActionEntity action, List<IndicatorEntity> indicators) {
        this.action = action;
        this.indicators = indicators;
    }

    public ActionEntity getAction() {
        return action;
    }

    public void setAction(ActionEntity action) {
        this.action = action;
    }

    public List<IndicatorEntity> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<IndicatorEntity> indicators) {
        this.indicators = indicators;
    }
}
