package com.epul.permispiste.dto;

import com.epul.permispiste.domains.ActionEntity;
import com.epul.permispiste.domains.IndicatorEntity;

import java.util.List;

public class IndicatorsActions {

    public ActionDTO action;
    public List<IndicatorDTO> indicators;

    public IndicatorsActions(ActionDTO action, List<IndicatorDTO> indicators) {
        this.action = action;
        this.indicators = indicators;
    }

    public ActionDTO getAction() {
        return action;
    }

    public void setAction(ActionDTO action) {
        this.action = action;
    }

    public List<IndicatorDTO> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<IndicatorDTO> indicators) {
        this.indicators = indicators;
    }
}
