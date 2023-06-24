package com.epul.permispiste.repositories;

import com.epul.permispiste.domains.IndicatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndicateurRepository extends JpaRepository<IndicatorEntity, Integer> {

    public List<IndicatorEntity> findAllByFkAction(int idAction);
}
