package com.armanaj.computershop.service.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.PowerRating;
import com.armanaj.computershop.repository.products.productBaseInfo.PowerRatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerRatingService {

    private final PowerRatingRepository powerRatingRepository;

    public PowerRatingService(PowerRatingRepository powerRatingRepository) {
        this.powerRatingRepository = powerRatingRepository;
    }

    public List<PowerRating> getAllPowerRatings() {
        return powerRatingRepository.findAll().stream().toList();
    }

    public PowerRating getPowerRatingById(Integer id) {
        return powerRatingRepository.findById(id).orElseThrow();
    }

    public PowerRating save(String name) {
        PowerRating powerRating = new PowerRating(name);
        return powerRatingRepository.save(powerRating);
    }
}
