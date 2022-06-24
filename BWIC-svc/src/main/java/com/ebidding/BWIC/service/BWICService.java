package com.ebidding.BWIC.service;


import com.ebidding.BWIC.domain.BWIC;
import com.ebidding.BWIC.repository.BWICRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BWICService {
    @Autowired
    private BWICRepository bwicRepository;

    public BWIC getBWICByCusip(String cusip) {
        return this.bwicRepository.findByCusip(cusip).orElse(null);
    }

    public List<BWIC> findBWICActive(){return this.bwicRepository.findBWICActive();}
    public BWIC save(BWIC bwic) {
        return this.bwicRepository.saveAndFlush(bwic);
    }

    public void delete(BWIC bwic) {
        this.bwicRepository.delete(bwic);
    }
}
