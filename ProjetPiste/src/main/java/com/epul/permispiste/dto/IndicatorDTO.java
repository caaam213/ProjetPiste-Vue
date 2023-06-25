package com.epul.permispiste.dto;

public class IndicatorDTO {
    private int id;
    private String wording;
    private Integer valueIfCheck;
    private Integer valueIfUnCheck;

    public IndicatorDTO() {
    }

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

    public Integer getValueIfCheck() {
        return valueIfCheck;
    }

    public void setValueIfCheck(Integer valueIfCheck) {
        this.valueIfCheck = valueIfCheck;
    }

    public Integer getValueIfUnCheck() {
        return valueIfUnCheck;
    }

    public void setValueIfUnCheck(Integer valueIfUnCheck) {
        this.valueIfUnCheck = valueIfUnCheck;
    }
}
