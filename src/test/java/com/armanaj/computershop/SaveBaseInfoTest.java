package com.armanaj.computershop;

import com.armanaj.computershop.model.ERole;
import com.armanaj.computershop.model.Role;
import com.armanaj.computershop.repository.RoleRepository;
import com.armanaj.computershop.service.products.productBaseInfo.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SaveBaseInfoTest {

    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CPUGenerationService cpuGenerationService;
    @Autowired
    private GPUGenerationService gpuGenerationService;
    @Autowired
    private MotherboardFormFactorService motherboardFormFactorService;
    @Autowired
    private PCIEVersionService pcieVersionService;
    @Autowired
    private PowerRatingService powerRatingService;
    @Autowired
    private PowerSupplyFormFactorService powerSupplyFormFactorService;
    @Autowired
    private SocketService socketService;
    @Autowired
    private StorageDriveTypeService storageDriveTypeService;
    @Autowired
    private RoleRepository roleRepository;


    @Test
    void saveRole() {
        Role roleUser = new Role();
        roleUser.setName(ERole.ROLE_USER);
        roleRepository.save(roleUser);
        Role roleAdmin = new Role();
        roleAdmin.setName(ERole.ROLE_ADMIN);
        roleRepository.save(roleAdmin);
    }

    @Test
    void saveBrand() {
        brandService.save("Nvidia");
        brandService.save("AMD");
        brandService.save("Intel");
        brandService.save("Asus");
        brandService.save("MSI");
        brandService.save("EVGA");
        brandService.save("Gigabyte");
        brandService.save("Aorus");
        brandService.save("GALAX");
        brandService.save("Colorful");
        brandService.save("Zotac");
        brandService.save("PNY");
        brandService.save("Asrock");
        brandService.save("Powercolor");
        brandService.save("Sapphire");
        brandService.save("XFX");
        brandService.save("Fractal Design");
        brandService.save("Phanteks");
        brandService.save("Lian Li");
        brandService.save("NZXT");
        brandService.save("Cooler Master");
        brandService.save("Corsair");
        brandService.save("be quiet!");
        brandService.save("TeamGroup");
        brandService.save("G.Skill");
        brandService.save("Samsung");
        brandService.save("Patriot");
        brandService.save("Crucial");
        brandService.save("Kingston");
        brandService.save("XPG");
        brandService.save("ThermalTake");
        brandService.save("SilverStone");
        brandService.save("Seasonic");
        brandService.save("Seagate");
        brandService.save("Western Digital");
        brandService.save("SK hynix");
        brandService.save("Sabrent");
    }

    @Test
    void saveCategory() {
        categoryService.save("Case");
        categoryService.save("CPU");
        categoryService.save("GPU");
        categoryService.save("Motherboard");
        categoryService.save("Power Supply");
        categoryService.save("Ram");
        categoryService.save("Storage Drive");
    }

    @Test
    void saveCPUGeneration() {
        cpuGenerationService.save("Intel 10th Gen");
        cpuGenerationService.save("Intel 11th Gen");
        cpuGenerationService.save("Intel 12th Gen");
        cpuGenerationService.save("Intel 13th Gen");
        cpuGenerationService.save("AMD Zen 2");
        cpuGenerationService.save("AMD Zen 3");
        cpuGenerationService.save("AMD Zen 4");
    }

    @Test
    void saveGPUGeneration() {
        gpuGenerationService.save("GeForce 20 Series");
        gpuGenerationService.save("GeForce 30 Series");
        gpuGenerationService.save("GeForce 40 Series");
        gpuGenerationService.save("Radeon RX 5000 series");
        gpuGenerationService.save("Radeon RX 6000 series");
        gpuGenerationService.save("Radeon RX 7000 series");
    }

    @Test
    void motherboardFormFactor() {
        motherboardFormFactorService.save("Mini-ITX");
        motherboardFormFactorService.save("Micro-ATX");
        motherboardFormFactorService.save("ATX");
        motherboardFormFactorService.save("E-ATX");
    }

    @Test
    void savePCIEVersion() {
        pcieVersionService.save("PCIe 3.0");
        pcieVersionService.save("PCIe 4.0");
        pcieVersionService.save("PCIe 5.0");
    }

    @Test
    void savePowerRating() {
        powerRatingService.save("80 Plus");
        powerRatingService.save("80 Plus Bronze");
        powerRatingService.save("80 Plus Silver");
        powerRatingService.save("80 Plus Gold");
        powerRatingService.save("80 Plus Platinum");
        powerRatingService.save("80 Plus Titanium");
    }

    @Test
    void savePowerSupplyFormFactor() {
        powerSupplyFormFactorService.save("ATX");
        powerSupplyFormFactorService.save("TFX");
        powerSupplyFormFactorService.save("SFX");
        powerSupplyFormFactorService.save("SFX-L");
    }

    @Test
    void saveSocket() {
        socketService.save("LGA1200");
        socketService.save("LGA1700");
        socketService.save("AM4");
        socketService.save("AM5");
    }

    @Test
    void saveStorageDriveType() {
        storageDriveTypeService.save("SATA HDD");
        storageDriveTypeService.save("mSata SSD");
        storageDriveTypeService.save("SATA SSD");
        storageDriveTypeService.save("NVME M.2 SSD");
        storageDriveTypeService.save("PCIe SSD");
    }
}
