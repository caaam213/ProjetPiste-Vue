package com.epul.permispiste.service;
import com.epul.permispiste.domains.ApprenantEntity;
import org.springframework.stereotype.Service;

@Service
public interface IApprenantService {
    void addApprenant(ApprenantEntity apprenantEntity);

    void editApprenant(ApprenantEntity apprenantEntity);

    void delete(int id);

    ApprenantEntity getApprenantById(int id);
}
