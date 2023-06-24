package com.epul.permispiste.domains;

import javax.persistence.*;

@Entity
@Table(name = "apprenant", schema = "projetpermis1", catalog = "")
public class ApprenantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nom_apprenant")
    private String nomApprenant;
    @Basic
    @Column(name = "prenom_apprenant")
    private String prenomApprenant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomApprenant() {
        return nomApprenant;
    }

    public void setNomApprenant(String nomApprenant) {
        this.nomApprenant = nomApprenant;
    }

    public String getPrenomApprenant() {
        return prenomApprenant;
    }

    public void setPrenomApprenant(String prenomApprenant) {
        this.prenomApprenant = prenomApprenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprenantEntity that = (ApprenantEntity) o;

        if (id != that.id) return false;
        if (nomApprenant != null ? !nomApprenant.equals(that.nomApprenant) : that.nomApprenant != null) return false;
        if (prenomApprenant != null ? !prenomApprenant.equals(that.prenomApprenant) : that.prenomApprenant != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nomApprenant != null ? nomApprenant.hashCode() : 0);
        result = 31 * result + (prenomApprenant != null ? prenomApprenant.hashCode() : 0);
        return result;
    }
}
