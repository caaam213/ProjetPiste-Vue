package com.epul.permispiste.domains;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "jeu", schema = "projetpermis1", catalog = "")
public class JeuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "libellejeu")
    private String libellejeu;
    @OneToMany(mappedBy = "jeuByFkJeu")
    private Collection<ActionJeuEntity> actionJeusById;
    @OneToMany(mappedBy = "jeuByFkJeu")
    private Collection<UtilisateurJeuEntity> utilisateurJeusById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibellejeu() {
        return libellejeu;
    }

    public void setLibellejeu(String libellejeu) {
        this.libellejeu = libellejeu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JeuEntity jeuEntity = (JeuEntity) o;

        if (id != jeuEntity.id) return false;
        return libellejeu != null ? libellejeu.equals(jeuEntity.libellejeu) : jeuEntity.libellejeu == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (libellejeu != null ? libellejeu.hashCode() : 0);
        return result;
    }

    public Collection<ActionJeuEntity> getActionJeusById() {
        return actionJeusById;
    }

    public void setActionJeusById(Collection<ActionJeuEntity> actionJeusById) {
        this.actionJeusById = actionJeusById;
    }

    public Collection<UtilisateurJeuEntity> getUtilisateurJeusById() {
        return utilisateurJeusById;
    }

    public void setUtilisateurJeusById(Collection<UtilisateurJeuEntity> utilisateurJeusById) {
        this.utilisateurJeusById = utilisateurJeusById;
    }



}


