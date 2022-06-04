package kz.iitu.itse1909r.nugmanova.Service;

import kz.iitu.itse1909r.nugmanova.Database.Donor;
import kz.iitu.itse1909r.nugmanova.Repository.DonorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class DonorService {
    DonorRepository repo = null;


    @Autowired
    public DonorService(DonorRepository donorRepository) {
        repo = donorRepository;
    }

    @Cacheable("donors")
    public List<Donor> getAllDonors() {
        return repo.findAll();
    }
}
