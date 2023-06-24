package com.epul.permispiste.dto;

import java.util.Comparator;

public class ActionWEntityWDernierScoreComparator implements Comparator<ActionEntityWDernierScore> {
    @Override
    public int compare(ActionEntityWDernierScore o1, ActionEntityWDernierScore o2) {

        boolean attribut1 = o1.isEtat();
        boolean attribut2 = o2.isEtat();

        if (attribut1 && !attribut2) {
            return -1; // objet1 est true, objet2 est false => objet1 vient avant objet2
        } else if (!attribut1 && attribut2) {
            return 1; // objet1 est false, objet2 est true => objet1 vient après objet2
        } else {
            return 0; // Les deux attributs ont la même valeur booléenne
        }
    }
}
