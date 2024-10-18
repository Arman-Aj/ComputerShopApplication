package com.armanaj.computershop.service.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.PCIEVersion;
import com.armanaj.computershop.repository.products.productBaseInfo.PCIEVersionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCIEVersionService {

    private final PCIEVersionRepository pcieVersionRepository;

    public PCIEVersionService(PCIEVersionRepository pcieVersionRepository) {
        this.pcieVersionRepository = pcieVersionRepository;
    }

    public List<PCIEVersion> getAllPCIEVersions() {
        return pcieVersionRepository.findAll().stream().toList();
    }

    public PCIEVersion getPCIEVersionById(Integer id) {
        return pcieVersionRepository.findById(id).orElseThrow();
    }

    public PCIEVersion save(String name) {
        PCIEVersion pcieVersion = new PCIEVersion(name);
        return pcieVersionRepository.save(pcieVersion);
    }
}
