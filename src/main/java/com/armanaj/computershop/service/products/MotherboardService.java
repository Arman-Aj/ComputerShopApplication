package com.armanaj.computershop.service.products;

import com.armanaj.computershop.exception.BuildProductNotFoundException;
import com.armanaj.computershop.model.products.Motherboard;
import com.armanaj.computershop.payload.response.ProductResponse;
import com.armanaj.computershop.repository.products.MotherboardRepository;
import com.armanaj.computershop.service.products.productBaseInfo.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MotherboardService {

    private final MotherboardRepository motherboardRepository;

    private final BrandService brandService;

    private final CategoryService categoryService;

    private final SocketService socketService;

    private final MotherboardFormFactorService motherBoardFormFactorService;

    private final PCIEVersionService pcieVersionService;

    public MotherboardService(MotherboardRepository motherboardRepository, BrandService brandService, CategoryService categoryService, SocketService socketService, MotherboardFormFactorService motherBoardFormFactorService, PCIEVersionService pcieVersionService) {
        this.motherboardRepository = motherboardRepository;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.socketService = socketService;
        this.motherBoardFormFactorService = motherBoardFormFactorService;
        this.pcieVersionService = pcieVersionService;
    }

    public ProductResponse<Motherboard> getAllMotherboards(int pageNumber, String searchText) {
        Page<Motherboard> page = Objects.equals(searchText, "") ? findAllMotherboards(pageNumber) : findMotherboardsBySearch(pageNumber, searchText);
        return new ProductResponse<>(page.getNumber(), page.getTotalPages(), page.getContent());
    }

    public List<Motherboard> findMotherboardsForBuilder(Double price, Integer socket, Integer formFactor ) throws BuildProductNotFoundException {
        List<Motherboard> motherboardList = motherboardRepository.findMotherboardsByPriceLessThanEqualAndSocketIdEqualsAndFormFactorIdLessThanEqual(price, socket, formFactor, Sort.by(Sort.Direction.DESC, "price"));
        if (motherboardList.size() == 0) {
            motherboardList = motherboardRepository.findMotherboardsByPriceGreaterThanAndSocketIdEqualsAndFormFactorIdLessThanEqual(price, socket, formFactor, Sort.by(Sort.Direction.ASC, "price"));
        }
        if (motherboardList.size() == 0) {
            throw new BuildProductNotFoundException();
        }
        return motherboardList;
    }

    public Motherboard save(String name, Integer brand, String model, Double price, String imageUrl, Integer category,
                            Integer warrantyYears, Integer socket, Integer formFactor, Integer PCIEVersion) {
        Motherboard motherboard = new Motherboard(name, brandService.getBrandById(brand), model, price, imageUrl, categoryService.getCategoryById(category),
                warrantyYears, socketService.getSocketById(socket), motherBoardFormFactorService.getMotherboardFormFactorById(formFactor),
                pcieVersionService.getPCIEVersionById(PCIEVersion));
        return motherboardRepository.save(motherboard);
    }

    private Page<Motherboard> findAllMotherboards(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return motherboardRepository.findAll(pageable);
    }

    private Page<Motherboard> findMotherboardsBySearch(int pageNumber, String searchText) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return motherboardRepository
                .findMotherboardsByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining(searchText, searchText, searchText, pageable);
    }
}
