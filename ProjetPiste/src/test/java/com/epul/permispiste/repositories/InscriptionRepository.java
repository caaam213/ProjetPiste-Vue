package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Integer> {
     List<InscriptionEntity> findAllByFkUser(int id);
     InscriptionEntity save(InscriptionEntity inscriptionEntity);
     InscriptionEntity findInscriptionEntityById(Integer id);


}
