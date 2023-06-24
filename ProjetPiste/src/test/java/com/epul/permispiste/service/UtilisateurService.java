package com.epul.permispiste.service;
import com.epul.permispiste.domains.UtilisateurEntity;
import com.epul.permispiste.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService implements IUtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<UtilisateurEntity> getAll() {
        List<UtilisateurEntity> utilisateurs = null;
        try {
            utilisateurs = utilisateurRepository.findAll();
        } catch (Exception e) {
            System.out.println(e);
        }
        return utilisateurs;
    }

    public List<UtilisateurEntity> getAllApprenant() {
        List<UtilisateurEntity> utilisateurs = null;
        try {
            utilisateurs = utilisateurRepository.findAllByRoleEquals("learner");
        } catch (Exception e) {
            System.out.println(e);
        }
        return utilisateurs;
    }

    public void delete(int id) {
        UtilisateurEntity utilisateur = utilisateurRepository.findByNumUtil(id);
        utilisateurRepository.delete(utilisateur);
    }

    @Override
    public UtilisateurEntity getUtilisateurById(int id) {
        return utilisateurRepository.findByNumUtil(id);
    }

    public void editUtilisateur(UtilisateurEntity utilisateurEntity) {
        UtilisateurEntity utilisateur = utilisateurRepository.findById(utilisateurEntity.getNumUtil()).get();
        utilisateur.setForename(utilisateurEntity.getForename());
        utilisateur.setRole(utilisateurEntity.getRole());
        utilisateur.setEmail(utilisateurEntity.getEmail());
        utilisateur.setSurname(utilisateurEntity.getSurname());
        utilisateur.setMotPasse(utilisateurEntity.getMotPasse());
        utilisateur.setSalt(utilisateurEntity.getSalt());
        utilisateur.setNomUtil(utilisateurEntity.getNomUtil());
        utilisateur.setInscriptionsByNumUtil(utilisateurEntity.getInscriptionsByNumUtil());
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public void addUtilisateur(UtilisateurEntity utilisateurEntity) {
        utilisateurRepository.save(utilisateurEntity);
    }

    public void editApprenant(UtilisateurEntity utiisateurEntity) {
        UtilisateurEntity utilisateur = utilisateurRepository.findByNumUtil(utiisateurEntity.getNumUtil());
        utilisateur.setForename(utiisateurEntity.getForename());
        utilisateur.setSurname(utiisateurEntity.getSurname());
        utilisateurRepository.save(utilisateur);

    }

    public UtilisateurEntity getUserByFkKey(int idUser) {
        return utilisateurRepository.findUtilisateurEntitiesByNumUtil(idUser);
    }
}
