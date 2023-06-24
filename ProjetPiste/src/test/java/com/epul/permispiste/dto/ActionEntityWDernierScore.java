package com.epul.permispiste.dto;

public class ActionEntityWDernierScore {
    // Données extraites de la table action
    private int idAction;
    private String libelleAction;

    private String precedenteAction;

    private int scoreMinimum;

    // Données extraites de la table inscription_action
    private int fk_inscription;
    private int score;

    // Etat de l'action = true si nous pouvons la faire, false sinon
    private boolean etat;

    public ActionEntityWDernierScore(int idAction, String libelleAction,String precedenteAction,  int scoreMinimum, int fk_inscription, int score, boolean etat) {
        this.idAction = idAction;
        this.libelleAction = libelleAction;
        this.precedenteAction = precedenteAction;
        this.scoreMinimum = scoreMinimum;
        this.fk_inscription = fk_inscription;
        this.score = score;
        this.etat = etat;
    }

    public int getIdAction() {
        return idAction;
    }

    public String getLibelleAction() {
        return libelleAction;
    }

    public int getScoreMinimum() {
        return scoreMinimum;
    }

    public int getFk_inscription() {
        return fk_inscription;
    }

    public int getScore() {
        return score;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getPrecedenteAction() {
        return precedenteAction;
    }

    public void setPrecedenteAction(String precedenteAction) {
        this.precedenteAction = precedenteAction;
    }
}

