package com.epul.permispiste.service;
import com.epul.permispiste.domains.UtilisateurEntity;
import org.springframework.stereotype.Service;

@Service
public interface IUtilisateurService {
    void addUtilisateur(UtilisateurEntity utilisateurEntity);

    void editUtilisateur(UtilisateurEntity utilisateurEntity);

    void delete(int id);

    UtilisateurEntity getUtilisateurById(int id);
}
