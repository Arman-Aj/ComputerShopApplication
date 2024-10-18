package com.armanaj.computershop.service.products;

import com.armanaj.computershop.exception.BuildProductNotFoundException;
import com.armanaj.computershop.model.products.StorageDrive;
import com.armanaj.computershop.payload.response.ProductResponse;
import com.armanaj.computershop.repository.products.StorageDriveRepository;
import com.armanaj.computershop.service.products.productBaseInfo.BrandService;
import com.armanaj.computershop.service.products.productBaseInfo.CategoryService;
import com.armanaj.computershop.service.products.productBaseInfo.PCIEVersionService;
import com.armanaj.computershop.service.products.productBaseInfo.StorageDriveTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StorageDriveService {

    private final StorageDriveRepository storageDriveRepository;

    private final BrandService brandService;

    private final CategoryService categoryService;

    private final PCIEVersionService pcieVersionService;

    private final StorageDriveTypeService storageDriveTypeService;

    public StorageDriveService(StorageDriveRepository storageDriveRepository, BrandService brandService, CategoryService categoryService, PCIEVersionService pcieVersionService, StorageDriveTypeService storageDriveTypeService) {
        this.storageDriveRepository = storageDriveRepository;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.pcieVersionService = pcieVersionService;
        this.storageDriveTypeService = storageDriveTypeService;
    }

    public ProductResponse<StorageDrive> getAllStorageDrives(int pageNumber, String searchText) {
        Page<StorageDrive> page = Objects.equals(searchText, "") ? findAllStorageDrives(pageNumber) : findStorageDrivesBySearch(pageNumber, searchText);
        return new ProductResponse<>(page.getNumber(), page.getTotalPages(), page.getContent());
    }

    public List<StorageDrive> findStorageDrivesForBuilder(Double price, Integer capacity, Integer storageDriveType) throws BuildProductNotFoundException {
        List<StorageDrive> storageDriveList = storageDriveRepository.findStorageDrivesByPriceLessThanEqualAndCapacityGreaterThanEqualAndStorageDriveTypeIdEquals(price, capacity, storageDriveType, Sort.by(Sort.Direction.DESC, "price"));
        if (storageDriveList.size() == 0) {
            storageDriveList = storageDriveRepository.findStorageDrivesByPriceGreaterThanAndCapacityGreaterThanEqualAndStorageDriveTypeIdEquals(price, capacity, storageDriveType, Sort.by(Sort.Direction.ASC, "price"));
        }
        if (storageDriveList.size() == 0) {
            throw new BuildProductNotFoundException();
        }
        return storageDriveList;
    }

    public StorageDrive save(String name, Integer brand, String model, Double price, String imageUrl, Integer category,
                             Integer warrantyYears, Integer capacity, Integer storageDriveType, Integer pcieVersion) {
        StorageDrive storageDrive = new StorageDrive(name, brandService.getBrandById(brand), model, price, imageUrl,
                categoryService.getCategoryById(category), warrantyYears, capacity, storageDriveTypeService.getStorageDriveTypeById(storageDriveType),
                pcieVersionService.getPCIEVersionById(pcieVersion));
        return storageDriveRepository.save(storageDrive);
    }

    private Page<StorageDrive> findAllStorageDrives(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return storageDriveRepository.findAll(pageable);
    }

    private Page<StorageDrive> findStorageDrivesBySearch(int pageNumber, String searchText) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return storageDriveRepository
                .findStorageDrivesByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining(searchText, searchText, searchText, pageable);
    }
}
