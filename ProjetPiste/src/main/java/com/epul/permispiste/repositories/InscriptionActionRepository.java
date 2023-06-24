package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.InscriptionActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionActionRepository extends JpaRepository<InscriptionActionEntity, Integer> {
    public List<InscriptionActionEntity> findAllByFkInscription(int id);
    public InscriptionActionEntity findByFkActionAndFkInscription(int idAction, int idInscription);
    public InscriptionActionEntity save(InscriptionActionEntity inscriptionActionEntity);
}

