package com.epul.permispiste.domains;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "utilisateur__jeu", schema = "projetpermis1", catalog = "")
public class UtilisateurJeuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fk_utilisateur", insertable = false, updatable = false)
    private Integer fkUtilisateur;
    @Basic
    @Column(name = "fk_jeu", insertable = false, updatable = false)
    private int fkJeu;
    @Basic
    @Column(name = "calendrier")
    private Date calendrier;
    @ManyToOne
    @JoinColumn(name = "fk_utilisateur", referencedColumnName = "num_util", nullable = false)
    private UtilisateurEntity utilisateurByFkUtilisateur;
    @ManyToOne
    @JoinColumn(name = "fk_jeu", referencedColumnName = "id", nullable = false)
    private JeuEntity jeuByFkJeu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFkUtilisateur() {
        return fkUtilisateur;
    }

    public void setFkUtilisateur(Integer fkUtilisateur) {
        this.fkUtilisateur = fkUtilisateur;
    }

    public int getFkJeu() {
        return fkJeu;
    }

    public void setFkJeu(int fkJeu) {
        this.fkJeu = fkJeu;
    }

    public Date getCalendrier() {
        return calendrier;
    }

    public void setCalendrier(Date calendrier) {
        this.calendrier = calendrier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UtilisateurJeuEntity that = (UtilisateurJeuEntity) o;

        if (id != that.id) return false;
        if (fkJeu != that.fkJeu) return false;
        if (fkUtilisateur != null ? !fkUtilisateur.equals(that.fkUtilisateur) : that.fkUtilisateur != null)
            return false;
        if (calendrier != null ? !calendrier.equals(that.calendrier) : that.calendrier != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fkUtilisateur != null ? fkUtilisateur.hashCode() : 0);
        result = 31 * result + fkJeu;
        result = 31 * result + (calendrier != null ? calendrier.hashCode() : 0);
        return result;
    }

    public UtilisateurEntity getUtilisateurByFkUtilisateur() {
        return utilisateurByFkUtilisateur;
    }

    public void setUtilisateurByFkUtilisateur(UtilisateurEntity utilisateurByFkUtilisateur) {
        this.utilisateurByFkUtilisateur = utilisateurByFkUtilisateur;
    }

    public JeuEntity getJeuByFkJeu() {
        return jeuByFkJeu;
    }

    public void setJeuByFkJeu(JeuEntity jeuByFkJeu) {
        this.jeuByFkJeu = jeuByFkJeu;
    }
}
