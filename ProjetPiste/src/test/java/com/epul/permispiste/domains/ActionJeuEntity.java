package com.epul.permispiste.domains;

import javax.persistence.*;


@Entity
@Table(name = "action__jeu", schema = "projetpermis1", catalog = "")
public class ActionJeuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fk_action")
    private int fkAction;
    @Basic
    @Column(name = "fk_jeu")
    private int fkJeu;
    @ManyToOne
    @JoinColumn(name = "fk_action", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private ActionEntity actionByFkAction;
    @ManyToOne
    @JoinColumn(name = "fk_jeu", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private JeuEntity jeuByFkJeu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkAction() {
        return fkAction;
    }

    public void setFkAction(int fkAction) {
        this.fkAction = fkAction;
    }

    public int getFkJeu() {
        return fkJeu;
    }

    public void setFkJeu(int fkJeu) {
        this.fkJeu = fkJeu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActionJeuEntity that = (ActionJeuEntity) o;

        if (id != that.id) return false;
        if (fkAction != that.fkAction) return false;
        if (fkJeu != that.fkJeu) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fkAction;
        result = 31 * result + fkJeu;
        return result;
    }

    public ActionEntity getActionByFkAction() {
        return actionByFkAction;
    }

    public void setActionByFkAction(ActionEntity actionByFkAction) {
        this.actionByFkAction = actionByFkAction;
    }

    public JeuEntity getJeuByFkJeu() {
        return jeuByFkJeu;
    }

    public void setJeuByFkJeu(JeuEntity jeuByFkJeu) {
        this.jeuByFkJeu = jeuByFkJeu;
    }
}

