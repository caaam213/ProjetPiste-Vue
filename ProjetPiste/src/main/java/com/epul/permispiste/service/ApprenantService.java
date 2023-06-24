package com.epul.permispiste.service;
import com.epul.permispiste.domains.ApprenantEntity;
import com.epul.permispiste.repositories.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprenantService implements IApprenantService {

    @Autowired
    private ApprenantRepository apprenantRepository;

    public List<ApprenantEntity> getAll(){
        List<ApprenantEntity> apprenants=null;
        try {
            apprenants = apprenantRepository.findAll();
        }catch (Exception e) {
            System.out.println(e);
        }
        return apprenants;
    }

    public void delete(int id) {
        ApprenantEntity apprenant = apprenantRepository.findById(id).get();
        apprenantRepository.delete(apprenant);
    }

    @Override
    public ApprenantEntity getApprenantById(int id) {
        return apprenantRepository.findById(id).get();
    }

    public void editApprenant(ApprenantEntity missionEntity) {
        ApprenantEntity apprenant = apprenantRepository.findById(missionEntity.getId()).get();
        apprenant.setNomApprenant(missionEntity.getNomApprenant());
        apprenant.setPrenomApprenant(missionEntity.getPrenomApprenant());
        //apprenant.setActionCalendrierApprenantsById(missionEntity.getActionCalendrierApprenantsById());
        //apprenant.setApprenantJeuCalendriersById(missionEntity.getApprenantJeuCalendriersById());
        apprenantRepository.save(apprenant);
    }

    @Override
    public void addApprenant(ApprenantEntity apprenantEntity)  {
        apprenantRepository.save(apprenantEntity);
    }


}
