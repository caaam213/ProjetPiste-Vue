package com.epul.permispiste.service;
import com.epul.permispiste.domains.UtilisateurEntity;
import com.epul.permispiste.repositories.UtilisateurRepository;
import com.epul.permispiste.utilitaires.MonMotPassHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationService implements IAuthentificationService {

    private UtilisateurRepository unUtilisateurRepostory;

    @Autowired
    public AuthentificationService(UtilisateurRepository UtilisateurRepostory) {
        this.unUtilisateurRepostory = UtilisateurRepostory;
    }

    @Override
    public UtilisateurEntity authentification(UtilisateurEntity unUti) throws Exception {
        UtilisateurEntity unUtilisateur = null;
        String message;
        String login = unUti.getNomUtil();
        String pwd = unUti.getMotPasse();
        unUtilisateur = unUtilisateurRepostory.getFirstByNomUtil(login);
        if (unUtilisateur != null) {
            try {
                // on récupère le sel
                String sel = unUtilisateur.getSalt();
                // on récupère le mot de passe
                String mdp = unUtilisateur.getMotPasse();
                // on génère le mot de passe avec les données de connexion
                byte[] salt = MonMotPassHash.transformeEnBytes(sel);
                char[] pwd_char = MonMotPassHash.converttoCharArray(pwd);
                byte[] monpwdCo = MonMotPassHash.generatePasswordHash(pwd_char, salt);
                // on récupère le mot de passe enregistré
                byte[] mdp_byte = MonMotPassHash.transformeEnBytes(mdp);
                if (!MonMotPassHash.verifyPassword(monpwdCo, mdp_byte)) {
                    message = "mot de passe erroné";
                    return null;
                }
            }catch (Exception e) {
                throw e;
            }
        }
        return unUtilisateur;
    }
}
