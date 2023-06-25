package com.epul.permispiste.classesjson;
public class JeuCreationRequest {
    private String libelleJeu;

    private int idJeu;
    private int idApprenant;
    private String[] actionsCheckbox;

    private String[] indicatorsCheckbox;

    public String getLibelleJeu() {
        return libelleJeu;
    }

    public void setLibelleJeu(String libelleJeu) {
        this.libelleJeu = libelleJeu;
    }

    public int getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
    }

    public String[] getActionsCheckbox() {
        return actionsCheckbox;
    }

    public void setActionsCheckbox(String[] actionsCheckbox) {
        this.actionsCheckbox = actionsCheckbox;
    }

    public int getIdJeu() {
        return idJeu;
    }

    public void setIdJeu(int idJeu) {
        this.idJeu = idJeu;
    }

    public String[] getIndicatorsCheckbox() {
        return indicatorsCheckbox;
    }

    public void setIndicatorsCheckbox(String[] indicatorsCheckbox) {
        this.indicatorsCheckbox = indicatorsCheckbox;
    }
}