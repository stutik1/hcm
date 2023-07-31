package com.stuti.hcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiService {

    private final ApiRepository apiRepository;

    public ApiService(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public ApiDetails saveApiDetails(ApiDetails apiDetails){
        return apiRepository.save(apiDetails);
    }

    public ApiDetails findAllApiDetails(){
        return apiRepository.findAll();
    }
}
