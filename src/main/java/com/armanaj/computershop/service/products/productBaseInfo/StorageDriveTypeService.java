package com.armanaj.computershop.service.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.StorageDriveType;
import com.armanaj.computershop.repository.products.productBaseInfo.StorageDriveTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageDriveTypeService {

    private final StorageDriveTypeRepository storageDriveTypeRepository;

    public StorageDriveTypeService(StorageDriveTypeRepository storageDriveTypeRepository) {
        this.storageDriveTypeRepository = storageDriveTypeRepository;
    }

    public List<StorageDriveType> getAllStorageDriveTypes() {
        return storageDriveTypeRepository.findAll().stream().toList();
    }

    public StorageDriveType getStorageDriveTypeById(Integer id) {
        return storageDriveTypeRepository.findById(id).orElseThrow();
    }

    public StorageDriveType save(String name) {
        StorageDriveType storageDriveType = new StorageDriveType(name);
        return storageDriveTypeRepository.save(storageDriveType);
    }
}
