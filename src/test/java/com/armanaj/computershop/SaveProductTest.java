package com.armanaj.computershop;

import com.armanaj.computershop.service.products.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SaveProductTest {

    // Brands
    Integer br_nvidia = 1;
    Integer br_amd = 2;
    Integer br_intel = 3;
    Integer br_asus = 4;
    Integer br_msi = 5;
    Integer br_evga = 6;
    Integer br_gigabyte = 7;
    Integer br_aorus = 8;
    Integer br_galax = 9;
    Integer br_colorful = 10;
    Integer br_zotac = 11;
    Integer br_pny = 12;
    Integer br_asrock = 13;
    Integer br_powercolor = 14;
    Integer br_sapphire = 15;
    Integer br_xfx = 16;
    Integer br_fractaldesign = 17;
    Integer br_phanteks = 18;
    Integer br_lianli = 19;
    Integer br_nzxt = 20;
    Integer br_coolermaster = 21;
    Integer br_corsair = 22;
    Integer br_bequiet = 23;
    Integer br_teamgroup = 24;
    Integer br_gskill = 25;
    Integer br_samsung = 26;
    Integer br_patriot = 27;
    Integer br_crucial = 28;
    Integer br_kingston = 29;
    Integer br_xpg = 30;
    Integer br_thermaltake = 31;
    Integer br_silverstone = 32;
    Integer br_seasonic = 33;
    Integer br_seagate = 34;
    Integer br_westerndigital = 35;
    Integer br_skhynix = 36;
    Integer br_sabrent = 37;

    // Categories
    Integer cat_case = 1;
    Integer cat_cpu = 2;
    Integer cat_gpu = 3;
    Integer cat_motherboard = 4;
    Integer cat_powersupply = 5;
    Integer cat_ram = 6;
    Integer cat_storagedrive = 7;

    // CPU Generation
    Integer cp_10 = 1;
    Integer cp_11 = 2;
    Integer cp_12 = 3;
    Integer cp_13 = 4;
    Integer cp_z2 = 5;
    Integer cp_z3 = 6;
    Integer cp_z4 = 7;

    // GPU Generation
    Integer gp_gf20 = 1;
    Integer gp_gf30 = 2;
    Integer gp_gf40 = 3;
    Integer gp_rd5000 = 4;
    Integer gp_rd6000 = 5;
    Integer gp_rd7000 = 6;

    // Motherboard Form Factor
    Integer mff_itx = 1;
    Integer mff_matx = 2;
    Integer mff_atx = 3;
    Integer mff_eatx = 4;

    // PCIE Version
    Integer pcv_3 = 1;
    Integer pcv_4 = 2;
    Integer pcv_5 = 3;

    // Power Rating
    Integer pwr_base = 1;
    Integer pwr_bronze = 2;
    Integer pwr_silver = 3;
    Integer pwr_gold = 4;
    Integer pwr_plat = 5;
    Integer pwr_titan = 6;

    //Power Supply Form Factor
    Integer psff_atx = 1;
    Integer psff_tfx = 2;
    Integer psff_sfx = 3;
    Integer psff_sfxl = 4;

    //Socket
    Integer sc_lga1200 = 1;
    Integer sc_lga1700 = 2;
    Integer sc_am4 = 3;
    Integer sc_am5 = 4;

    //Storage Drive Type
    Integer sdt_hdd = 1;
    Integer sdt_msatassd = 2;
    Integer sdt_satassd = 3;
    Integer sdt_m2ssd = 4;
    Integer sdt_pciessd = 5;

    // Content URL
    String url_case = "http://localhost:8090/content/case.webp";
    String url_cpu = "http://localhost:8090/content/cpu.webp";
    String url_gpu = "http://localhost:8090/content/gpu.webp";
    String url_motherboard = "http://localhost:8090/content/motherboard.webp";
    String url_powerSupply = "http://localhost:8090/content/power-supply.webp";
    String url_ram = "http://localhost:8090/content/ram.webp";
    String url_storageDrive = "http://localhost:8090/content/storage-drive.webp";

    @Autowired
    private CaseService caseService;
    @Autowired
    private CPUService cpuService;
    @Autowired
    private GPUService gpuService;
    @Autowired
    private MotherboardService motherboardService;
    @Autowired
    private PowerSupplyService powerSupplyService;
    @Autowired
    private RamService ramService;
    @Autowired
    private StorageDriveService storageDriveService;

    @Test
    void saveCase() {
        caseService.save("Fractal Design Meshify 2 Compact", br_fractaldesign, "Meshify 2 Compact", 119.9, url_case, cat_case, 2, mff_atx, 7);
        caseService.save("Phanteks Eclipse G360A", br_phanteks, "Eclipse G360A", 99.9, url_case, cat_case, 2, mff_eatx, 3);
        caseService.save("Lian Li PC-O11 Air Mini", br_lianli, "PC-O11 Air Mini", 99.9, url_case, cat_case, 2, mff_atx, 9);
        caseService.save("NZXT H7 Flow", br_nzxt, "H7 Flow", 129.9, url_case, cat_case, 2, mff_eatx, 2);
        caseService.save("Cooler Master HAF 700 Evo", br_coolermaster, "HAF 700 Evo", 499.9, url_case, cat_case, 2, mff_eatx, 5);
        caseService.save("Fractal Design Meshify 2", br_fractaldesign, "Meshify 2", 149.9, url_case, cat_case, 2, mff_eatx, 8);
        caseService.save("Lian Li Q58", br_lianli, "Q58", 169.9, url_case, cat_case, 2, mff_itx, 3);
        caseService.save("Phanteks Evolv Shift 2", br_phanteks, "Evolv Shift 2", 109.9, url_case, cat_case, 2, mff_itx, 2);
        caseService.save("Corsair Obsidian Series 4000X RGB", br_corsair, "Obsidian Series 4000X RGB", 124.9, url_case, cat_case, 2, mff_atx, 6);
        caseService.save("Fractal Design Define 7", br_fractaldesign, "Define 7", 259.9, url_case, cat_case, 2, mff_atx, 9);
        caseService.save("Phanteks Enthoo Pro II", br_phanteks, "Enthoo Pro II", 189.9, url_case, cat_case, 2, mff_eatx, 13);
        caseService.save("Cooler Master Cosmos C700M", br_coolermaster, "Cosmos C700M", 599.9, url_case, cat_case, 2, mff_atx, 9);
    }


    @Test
    void saveCPU() {
        cpuService.save("Intel Core i9-13900KF", br_intel, "Core i9-13900KF", 564.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_lga1700, 24, 8, 3.0, 5.8, 250, cp_13);
        cpuService.save("Intel Core i7-13700KF", br_intel, "Core i7-13700KF", 384.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_lga1700, 16, 8, 3.4, 5.4, 250, cp_13);
        cpuService.save("Intel Core i5-13600KF", br_intel, "Core i5-13600KF", 294.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_lga1700, 14, 6, 3.5, 5.1, 180, cp_13);
        cpuService.save("Intel Core i9-12900KF", br_intel, "Core i9-12900KF", 449.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_lga1700, 16, 8, 3.2, 5.2, 250, cp_12);
        cpuService.save("Intel Core i9-12900F", br_intel, "Core i9-12900F", 429.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_lga1700, 16, 8, 2.4, 5.1, 200, cp_12);
        cpuService.save("Intel Core i7-12700KF", br_intel, "Core i7-12700KF", 349.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_lga1700, 12, 8, 3.6, 5.0, 190, cp_12);
        cpuService.save("Intel Core i7-12700F", br_intel, "Core i7-12700F", 329.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_lga1700, 12, 8, 2.1, 4.9, 180, cp_12);
        cpuService.save("Intel Core i5-12600KF", br_intel, "Core i5-12600KF", 229.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_lga1700, 10, 6, 3.7, 4.9, 150, cp_12);
        cpuService.save("Intel Core i5-12600", br_intel, "Core i5-12600", 199.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_lga1700, 6, 6, 3.3, 4.8, 120, cp_12);
        cpuService.save("Intel Core i3-12300", br_intel, "Core i3-12300", 69.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_lga1700, 4, 4, 3.5, 4.4, 90, cp_12);
        cpuService.save("Intel Core i9-11900KF", br_intel, "Core i9-11900KF", 319.9, url_cpu, cat_cpu, 2, "x64", pcv_4, sc_lga1200, 8, 8, 3.5, 5.2, 125, cp_11);
        cpuService.save("Intel Core i9-11900F", br_intel, "Core i9-11900F", 300.9, url_cpu, cat_cpu, 2, "x64", pcv_4, sc_lga1200, 8, 8, 2.5, 5.1, 65, cp_11);
        cpuService.save("AMD Ryzen 9 7950X", br_amd, "Ryzen 9 7950X", 699.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_am5, 16, 16, 4.5, 5.7, 170, cp_z4);
        cpuService.save("AMD Ryzen 9 7900X", br_amd, "Ryzen 9 7900X", 549.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_am5, 12, 12, 4.7, 5.6, 170, cp_z4);
        cpuService.save("AMD Ryzen 7 7700X", br_amd, "Ryzen 7 7700X", 399.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_am5, 8, 8, 4.5, 5.4, 105, cp_z4);
        cpuService.save("AMD Ryzen 5 7600X", br_amd, "Ryzen 5 7600X", 299.9, url_cpu, cat_cpu, 2, "x64", pcv_5, sc_am5, 6, 6, 4.7, 5.3, 105, cp_z4);
        cpuService.save("AMD Ryzen 9 5950X", br_amd, "Ryzen 9 5950X", 499.9, url_cpu, cat_cpu, 2, "x64", pcv_4, sc_am4, 16, 16, 3.4, 4.9, 105, cp_z3);
        cpuService.save("AMD Ryzen 9 5900X", br_amd, "Ryzen 9 5900X", 339.9, url_cpu, cat_cpu, 2, "x64", pcv_4, sc_am4, 12, 12, 3.7, 4.8, 105, cp_z3);
        cpuService.save("AMD Ryzen 7 5800X3D", br_amd, "Ryzen 7 5800X3D", 344.9, url_cpu, cat_cpu, 2, "x64", pcv_4, sc_am4, 8, 8, 3.4, 4.5, 105, cp_z3);
        cpuService.save("AMD Ryzen 7 5700X", br_amd, "Ryzen 7 5700X", 209.9, url_cpu, cat_cpu, 2, "x64", pcv_4, sc_am4, 8, 8, 3.4, 4.6, 65, cp_z3);
        cpuService.save("AMD Ryzen 5 5600X", br_amd, "Ryzen 5 5600X", 179.9, url_cpu, cat_cpu, 2, "x64", pcv_4, sc_am4, 6, 6, 3.7, 4.6, 65, cp_z3);
        cpuService.save("AMD Ryzen 5 5600", br_amd, "Ryzen 5 5600", 149.9, url_cpu, cat_cpu, 2, "x64", pcv_4, sc_am4, 6, 6, 3.5, 4.4, 65, cp_z3);
        cpuService.save("AMD Ryzen 5 5500", br_amd, "Ryzen 5 5500", 109.9, url_cpu, cat_cpu, 2, "x64", pcv_4, sc_am4, 6, 6, 3.6, 4.2, 65, cp_z3);
    }

    @Test
    void saveGPU() {
        gpuService.save("Nvidia GeForce RTX 4090 Founders Edition", br_nvidia, "RTX 4090 Founders Edition", 1599.9, url_gpu, cat_gpu, 2, 24, 450, 12, gp_gf40, br_nvidia);
        gpuService.save("Nvidia GeForce RTX 4080 Founders Edition", br_nvidia, "RTX 4080 Founders Edition", 1199.9, url_gpu, cat_gpu, 2, 16, 320, 12, gp_gf40, br_nvidia);
        gpuService.save("MSI GeForce RTX 4090 Suprim X", br_msi, "RTX 4090 Suprim X", 1749.9, url_gpu, cat_gpu, 2, 24, 530, 12, gp_gf40, br_nvidia);
        gpuService.save("Colorful GeForce RTX 4090 Vulcan OC-V", br_colorful, "RTX 4090 Vulcan OC-V", 1749.9, url_gpu, cat_gpu, 2, 24, 480, 12, gp_gf40, br_nvidia);
        gpuService.save("Gigabyte GeForce RTX 4090 Gaming OC", br_gigabyte, "RTX 4090 Gaming OC", 1699.9, url_gpu, cat_gpu, 2, 24, 600, 12, gp_gf40, br_nvidia);
        gpuService.save("ASUS GeForce RTX 4090 STRIX OC", br_asus, "RTX 4090 STRIX OC", 1999.9, url_gpu, cat_gpu, 2, 24, 600, 12, gp_gf40, br_nvidia);
        gpuService.save("Gigabyte GeForce RTX 4090 Aorus Master", br_aorus, "RTX 4090 Aorus Master", 2099.9, url_gpu, cat_gpu, 2, 24, 600, 12, gp_gf40, br_nvidia);
        gpuService.save("Zotac GeForce RTX 4090 Amp Extreme Airo", br_zotac, "RTX 4090 Amp Extreme Airo", 1699.9, url_gpu, cat_gpu, 2, 24, 600, 12, gp_gf40, br_nvidia);
        gpuService.save("MSI GeForce RTX 4090 Gaming X Trio", br_zotac, "RTX 4090 Gaming X Trio", 1749.9, url_gpu, cat_gpu, 2, 24, 600, 12, gp_gf40, br_nvidia);
        gpuService.save("Gigabyte GeForce RTX 4080 Aorus Master", br_aorus, "RTX 4080 Aorus Master", 1499.9, url_gpu, cat_gpu, 2, 16, 400, 12, gp_gf40, br_nvidia);
        gpuService.save("ASUS GeForce RTX 4080 ROG Strix OC", br_asus, "RTX 4080 ROG Strix OC", 1599.9, url_gpu, cat_gpu, 2, 16, 400, 12, gp_gf40, br_nvidia);
        gpuService.save("MSI GeForce RTX 4080 SUPRIM X", br_msi, "RTX 4080 SUPRIM X", 1399.9, url_gpu, cat_gpu, 2, 16, 350, 12, gp_gf40, br_nvidia);
        gpuService.save("MSI GeForce RTX 4080 Gaming X Trio", br_msi, "RTX 4080 Gaming X Trio", 1349.9, url_gpu, cat_gpu, 2, 16, 350, 12, gp_gf40, br_nvidia);
        gpuService.save("ASUS GeForce RTX 4080 TUF Gaming", br_asus, "RTX 4080 TUF Gaming", 1299.9, url_gpu, cat_gpu, 2, 16, 320, 12, gp_gf40, br_nvidia);
        gpuService.save("ZOTAC GeForce RTX 4080 AMP Extreme AIRO", br_zotac, "RTX 4080 AMP Extreme AIRO", 1399.9, url_gpu, cat_gpu, 2, 16, 350, 12, gp_gf40, br_nvidia);
        gpuService.save("ZOTAC GeForce RTX 4080 Trinity", br_zotac, "RTX 4080 Trinity", 1199.9, url_gpu, cat_gpu, 2, 16, 320, 12, gp_gf40, br_nvidia);
        gpuService.save("Nvidia GeForce RTX 3090Ti Founders Edition", br_nvidia, "RTX 3090 Ti Founders Edition", 1899.9, url_gpu, cat_gpu, 2, 24, 450, 12, gp_gf30, br_nvidia);
        gpuService.save("Asus GeForce RTX 3090 Ti ROG Strix OC Edition", br_asus, "RTX 3090 Ti ROG Strix OC Edition", 2199.9, url_gpu, cat_gpu, 2, 24, 550, 12, gp_gf30, br_nvidia);
        gpuService.save("EVGA GeForce RTX 3090 Ti FTW3 Gaming", br_evga, "RTX 3090 Ti FTW3 Gaming", 2149.9, url_gpu, cat_gpu, 2, 24, 550, 12, gp_gf30, br_nvidia);
        gpuService.save("Nvidia GeForce RTX 3080 Founders Edition", br_nvidia, "RTX 3080 Founders Edition", 699.9, url_gpu, cat_gpu, 2, 10, 320, 12, gp_gf30, br_nvidia);
        gpuService.save("ZOTAC GeForce RTX 3080 Trinity", br_zotac, "RTX 3080 Trinity", 699.9, url_gpu, cat_gpu, 2, 10, 320, 12, gp_gf30, br_nvidia);
        gpuService.save("ASUS RTX 3080 ROG Strix OC", br_asus, "RTX 3080 ROG Strix OC", 899.9, url_gpu, cat_gpu, 2, 10, 360, 12, gp_gf30, br_nvidia);
        gpuService.save("MSI RTX 3080 Gaming X Trio", br_msi, "RTX 3080 Gaming X Trio", 759.9, url_gpu, cat_gpu, 2, 10, 350, 12, gp_gf30, br_nvidia);
        gpuService.save("EVGA RTX 3080 FTW3 ULTRA", br_evga, "RTX 3080 FTW3 ULTRA", 809.9, url_gpu, cat_gpu, 2, 10, 360, 12, gp_gf30, br_nvidia);
        gpuService.save("Gigabyte RTX 3080 Eagle OC", br_gigabyte, "RTX 3080 Eagle OC", 699.9, url_gpu, cat_gpu, 2, 10, 350, 12, gp_gf30, br_nvidia);
        gpuService.save("Nvidia GeForce RTX 3070 Founders Edition", br_nvidia, "RTX 3070 Founders Edition", 499.9, url_gpu, cat_gpu, 2, 8, 220, 12, gp_gf30, br_nvidia);
        gpuService.save("MSI RTX 3070 GAMING X TRIO", br_msi, "RTX 3070 GAMING X TRIO", 559.9, url_gpu, cat_gpu, 2, 8, 245, 12, gp_gf30, br_nvidia);
        gpuService.save("ASUS RTX 3070 TUF GAMING", br_asus, "RTX 3070 TUF GAMING", 549.9, url_gpu, cat_gpu, 2, 8, 245, 12, gp_gf30, br_nvidia);
        gpuService.save("GIGABYTE RTX 3070 GAMING OC 8G", br_gigabyte, "RTX 3070 GAMING OC 8G", 569.9, url_gpu, cat_gpu, 2, 8, 275, 12, gp_gf30, br_nvidia);
        gpuService.save("Nvidia GeForce RTX 3060 Founders Edition", br_nvidia, "RTX 3060 Founders Edition", 329.9, url_gpu, cat_gpu, 2, 12, 170, 12, gp_gf30, br_nvidia);
        gpuService.save("ZOTAC GeForce RTX 3060 AMP White Edition", br_zotac, "RTX 3060 AMP White Edition", 379.9, url_gpu, cat_gpu, 2, 12, 200, 12, gp_gf30, br_nvidia);
        gpuService.save("EVGA GeForce RTX 3060 XC", br_evga, "RTX 3060 XC", 389.9, url_gpu, cat_gpu, 2, 12, 220, 12, gp_gf30, br_nvidia);
        gpuService.save("MSI GeForce RTX 3060 Gaming X Trio", br_msi, "RTX 3060 Gaming X Trio", 389.9, url_gpu, cat_gpu, 2, 12, 220, 12, gp_gf30, br_nvidia);
        gpuService.save("Gigabyte GeForce RTX 3060 Gaming OC", br_gigabyte, "RTX 3060 Gaming OC", 389.9, url_gpu, cat_gpu, 2, 12, 220, 12, gp_gf30, br_nvidia);
        gpuService.save("Nvidia GeForce RTX 3050 Founders Edition", br_nvidia, "RTX 3050 Founders Edition", 249.9, url_gpu, cat_gpu, 2, 8, 130, 12, gp_gf30, br_nvidia);
        gpuService.save("Gigabyte GeForce RTX 3050 Gaming OC", br_gigabyte, "RTX 3050 Gaming OC", 379.9, url_gpu, cat_gpu, 2, 8, 180, 12, gp_gf30, br_nvidia);
        gpuService.save("ASUS GeForce RTX 3050 STRIX OC", br_asus, "RTX 3050 STRIX OC", 489.9, url_gpu, cat_gpu, 2, 8, 180, 12, gp_gf30, br_nvidia);
        gpuService.save("AMD Radeon RX 7900 XTX", br_amd, "RX 7900 XTX", 999.9, url_gpu, cat_gpu, 2, 24, 355, 12, gp_rd7000, br_amd);
        gpuService.save("ASRock RX 7900 XTX Aqua", br_asrock, "RX 7900 XTX Aqua", 1449.9, url_gpu, cat_gpu, 2, 24, 400, 12, gp_rd7000, br_amd);
        gpuService.save("ASRock RX 7900 XTX", br_asrock, "RX 7900 XTX", 999.9, url_gpu, cat_gpu, 2, 24, 360, 12, gp_rd7000, br_amd);
        gpuService.save("ASUS RX 7900 XTX", br_asus, "RX 7900 XTX", 999.9, url_gpu, cat_gpu, 2, 24, 360, 12, gp_rd7000, br_amd);
        gpuService.save("Gigabyte RX 7900 XTX Gaming", br_gigabyte, "RX 7900 XTX Gaming", 999.9, url_gpu, cat_gpu, 2, 24, 360, 12, gp_rd7000, br_amd);
        gpuService.save("PowerColor RX 7900 XTX Red Devil", br_powercolor, "RX 7900 XTX Red Devil", 1099.9, url_gpu, cat_gpu, 2, 24, 380, 12, gp_rd7000, br_amd);
        gpuService.save("AMD Radeon RX 7900 XT", br_amd, "RX 7900 XT", 899.9, url_gpu, cat_gpu, 2, 20, 300, 12, gp_rd7000, br_amd);
        gpuService.save("XFX RX 7900 XT", br_xfx, "RX 7900 XT", 899.9, url_gpu, cat_gpu, 2, 20, 300, 12, gp_rd7000, br_amd);
        gpuService.save("XFX RX 7900 XT Speedster MERC310 Black", br_xfx, "RX 7900 XT Speedster MERC310 Black", 949.9, url_gpu, cat_gpu, 2, 20, 350, 12, gp_rd7000, br_amd);
        gpuService.save("XFX RX 7900 XT Speedster MERC310 Ultra", br_xfx, "RX 7900 XT Speedster MERC310 Ultra", 979.9, url_gpu, cat_gpu, 2, 20, 360, 12, gp_rd7000, br_amd);
        gpuService.save("PowerColor RX 7900 XT Hellhound", br_powercolor, "RX 7900 XT Hellhound", 899.9, url_gpu, cat_gpu, 2, 20, 350, 12, gp_rd7000, br_amd);
        gpuService.save("ASRock RX 7900 XT Taichi", br_asrock, "RX 7900 XT Taichi", 999.9, url_gpu, cat_gpu, 2, 20, 360, 12, gp_rd7000, br_amd);
        gpuService.save("ASRock RX 7900 XT Phantom Gaming", br_asrock, "RX 7900 XT Phantom Gaming", 949.9, url_gpu, cat_gpu, 2, 20, 350, 12, gp_rd7000, br_amd);
        gpuService.save("AMD Radeon RX 6950 XT", br_amd, "RX 6950 XT", 899.9, url_gpu, cat_gpu, 2, 16, 335, 12, gp_rd6000, br_amd);
        gpuService.save("AMD Radeon RX 6900 XT", br_amd, "RX 6900 XT", 799.9, url_gpu, cat_gpu, 2, 16, 300, 12, gp_rd6000, br_amd);
        gpuService.save("AMD Radeon RX 6800 XT", br_amd, "RX 6800 XT", 599.9, url_gpu, cat_gpu, 2, 16, 300, 12, gp_rd6000, br_amd);
        gpuService.save("AMD Radeon RX 6800", br_amd, "RX 6800", 509.9, url_gpu, cat_gpu, 2, 16, 250, 12, gp_rd6000, br_amd);
        gpuService.save("AMD Radeon RX 6750 XT", br_amd, "RX 6750 XT", 499.9, url_gpu, cat_gpu, 2, 12, 250, 12, gp_rd6000, br_amd);
        gpuService.save("AMD Radeon RX 6700 XT", br_amd, "RX 6700 XT", 399.9, url_gpu, cat_gpu, 2, 12, 230, 12, gp_rd6000, br_amd);
        gpuService.save("AMD Radeon RX 6650 XT", br_amd, "RX 6650 XT", 249.9, url_gpu, cat_gpu, 2, 8, 180, 12, gp_rd6000, br_amd);
        gpuService.save("AMD Radeon RX 6600 XT", br_amd, "RX 6600 XT", 199.9, url_gpu, cat_gpu, 2, 8, 160, 12, gp_rd6000, br_amd);
    }

    @Test
    void saveMotherboard() {
        motherboardService.save("Gigabyte Z690 Aorus Pro", br_aorus, "Z690 Aorus Pro", 329.9, url_motherboard, cat_motherboard, 2, sc_lga1700, mff_atx, pcv_5);
        motherboardService.save("ASRock Z690 Taichi", br_asrock, "Z690 Taichi", 589.9, url_motherboard, cat_motherboard, 2, sc_lga1700, mff_atx, pcv_5);
        motherboardService.save("MSI MAG B660M Mortar WIFI DDR4", br_msi, "B660M Mortar", 179.9, url_motherboard, cat_motherboard, 2, sc_lga1700, mff_matx, pcv_4);
        motherboardService.save("MSI MAG B660 Tomahawk WIFI DDR4", br_msi, "B660 Tomahawk", 189.9, url_motherboard, cat_motherboard, 2, sc_lga1700, mff_atx, pcv_4);
        motherboardService.save("ASUS Z590-Plus TUF Gaming WIFI", br_asus, "Z590-Plus TUF Gaming", 159.9, url_motherboard, cat_motherboard, 2, sc_lga1200, mff_atx, pcv_4);
        motherboardService.save("Gigabyte Z590 Aorus Tachyon", br_gigabyte, "Z590 Aorus Tachyon", 299.9, url_motherboard, cat_motherboard, 2, sc_lga1200, mff_eatx, pcv_4);
        motherboardService.save("ASUS ROG Crosshair VIII Dark Hero", br_asus, "ROG Crosshair VIII", 399.9, url_motherboard, cat_motherboard, 2, sc_am4, mff_eatx, pcv_4);
        motherboardService.save("MSI MPG X570 Gaming Pro Carbon WiFi", br_msi, "X570 Gaming Pro Carbon", 249.9, url_motherboard, cat_motherboard, 2, sc_am4, mff_atx, pcv_4);
        motherboardService.save("ASUS B550-E ROG Strix Gaming", br_asus, "B550-E ROG Strix Gaming", 249.9, url_motherboard, cat_motherboard, 2, sc_am4, mff_atx, pcv_4);
        motherboardService.save("MSI MAG B550M Mortar", br_msi, "B550M Mortar", 199.9, url_motherboard, cat_motherboard, 2, sc_am4, mff_matx, pcv_4);
        motherboardService.save("ASRock A520M ITX/ac", br_asrock, "A520M ITX/ac", 99.9, url_motherboard, cat_motherboard, 2, sc_am4, mff_itx, pcv_4);
        motherboardService.save("ASUS Z790 ROG Maximus HERO", br_asus, "Z790 ROG Maximus HERO", 749.9, url_motherboard, cat_motherboard, 2, sc_lga1700, mff_atx, pcv_5);
        motherboardService.save("Gigabyte Z790 AORUS ELITE AX", br_gigabyte, "Gigabyte Z790 AORUS ELITE AX", 249.9, url_motherboard, cat_motherboard, 2, sc_lga1700, mff_atx, pcv_5);
        motherboardService.save("MSI PRO Z790-A WiFi", br_msi, "Z790-A WiFi", 289.9, url_motherboard, cat_motherboard, 2, sc_lga1700, mff_atx, pcv_5);
        motherboardService.save("ASUS Z790-I ROG STRIX Gaming WiFi", br_asus, "Z790-I ROG STRIX Gaming", 459.9, url_motherboard, cat_motherboard, 2, sc_lga1700, mff_itx, pcv_5);
        motherboardService.save("ASRock X670E Taichi", br_asrock, "X670E Taichi", 524.9, url_motherboard, cat_motherboard, 2, sc_am5, mff_eatx, pcv_5);
        motherboardService.save("ASUS X670E ROG Crosshair Gene", br_asus, "X670E ROG Crosshair Gene", 599.9, url_motherboard, cat_motherboard, 2, sc_am5, mff_matx, pcv_5);
        motherboardService.save("ASUS X670E-I ROG Strix Gaming WiFi", br_asus, "X670E-I ROG Strix Gaming", 459.9, url_motherboard, cat_motherboard, 2, sc_am5, mff_itx, pcv_5);
    }

    @Test
    void savePowerSupply() {
        powerSupplyService.save("Corsair CX450", br_corsair, "CX450", 59.9, url_powerSupply, cat_powersupply, 2, 450, pwr_bronze, psff_atx);
        powerSupplyService.save("Corsair CX550F RGB", br_corsair, "CX550F RGB", 89.9, url_powerSupply, cat_powersupply, 2, 550, pwr_bronze, psff_atx);
        powerSupplyService.save("Corsair RM550x", br_corsair, "RM550x", 89.9, url_powerSupply, cat_powersupply, 2, 550, pwr_gold, psff_atx);
        powerSupplyService.save("XPG Core Reactor 650W", br_xpg, "Core Reactor 650W", 129.9, url_powerSupply, cat_powersupply, 2, 650, pwr_gold, psff_atx);
        powerSupplyService.save("Cooler Master V750 Gold V2", br_coolermaster, "V750 Gold V2", 139.9, url_powerSupply, cat_powersupply, 2, 750, pwr_gold, psff_atx);
        powerSupplyService.save("EVGA SuperNOVA 850 G7", br_evga, "SuperNOVA 850 G7", 189.9, url_powerSupply, cat_powersupply, 2, 850, pwr_gold, psff_atx);
        powerSupplyService.save("MSI MEG Ai1000P PCIe 5", br_msi, "MEG Ai1000P PCIe 5", 279.9, url_powerSupply, cat_powersupply, 2, 1000, pwr_plat, psff_atx);
        powerSupplyService.save("ThermalTake Toughpower GF3 1350W", br_thermaltake, "Toughpower GF3 1350W", 312.9, url_powerSupply, cat_powersupply, 2, 1350, pwr_gold, psff_atx);
        powerSupplyService.save("Corsair AX1600i", br_corsair, "AX1600i", 609.9, url_powerSupply, cat_powersupply, 2, 1600, pwr_plat, psff_atx);
        powerSupplyService.save("Corsair SF750", br_corsair, "SF750", 189.9, url_powerSupply, cat_powersupply, 2, 750, pwr_plat, psff_sfx);
        powerSupplyService.save("SilverStone SX1000 SFX-L", br_silverstone, "SX1000 SFX-L", 249.9, url_powerSupply, cat_powersupply, 2, 1000, pwr_plat, psff_sfxl);
        powerSupplyService.save("Seasonic Prime Titanium TX-1000", br_seasonic, "Prime Titanium TX-1000", 289.9, url_powerSupply, cat_powersupply, 2, 1000, pwr_titan, psff_atx);

    }

    @Test
    void saveRam() {
        ramService.save("G.Skill Trident Z5 RGB DDR5-6000", br_gskill, "Trident Z5 RGB DDR5-6000", 489.9, url_ram, cat_ram, 2, pcv_5, 6000, 16, 2, 36);
        ramService.save("Samsung DDR5-4800", br_samsung, "M323R2GA3BB0-CQKOD", 299.9, url_ram, cat_ram, 2, pcv_5, 4800, 16, 2, 40);
        ramService.save("TeamGroup T-Force Xtreem ARGB DDR4-3600", br_teamgroup, "T-Force Xtreem ARGB DDR4-3600", 139.9, url_ram, cat_ram, 2, pcv_4, 3600, 8, 2, 14);
        ramService.save("Patriot Viper Steel DDR4-4400", br_patriot, "Viper Steel DDR4-4400", 119.9, url_ram, cat_ram, 2, pcv_4, 4400, 8, 2, 19);
        ramService.save("Patriot Viper RGB DDR4-3600", br_patriot, "Viper RGB DDR4-3600", 179.9, url_ram, cat_ram, 2, pcv_4, 3600, 8, 2, 18);
        ramService.save("G.Skill Trident Z Neo 32GB DDR4-3600", br_gskill, "Trident Z Neo 32GB DDR4-3600", 449.9, url_ram, cat_ram, 2, pcv_4, 3600, 16, 2, 18);
        ramService.save("Ballistix Sport Gray 8GB DDR4-2400", br_crucial, "Sport Gray 8GB DDR4-2400", 99.9, url_ram, cat_ram, 2, pcv_4, 2400, 8, 1, 16);
        ramService.save("G.Skill Trident Z RGB DDR4 4266MHZ", br_gskill, "Trident Z 16GB RGB DDR4 4266MHZ", 179.9, url_ram, cat_ram, 2, pcv_4, 4266, 8, 2, 19);
        ramService.save("Corsair Dominator Platinum RGB DDR5-5200", br_corsair, "Dominator Platinum RGB DDR5-5200", 449.9, url_ram, cat_ram, 2, pcv_5, 5200, 16, 2, 40);
        ramService.save("Kingston Fury Beast DDR5-4800", br_kingston, "Fury Beast DDR5-4800", 199.9, url_ram, cat_ram, 2, pcv_5, 4800, 16, 1, 38);
        ramService.save("TeamGroup Night Hawk RGB DDR4-3200", br_teamgroup, "Night Hawk RGB 16GB DDR4-3200", 199.9, url_ram, cat_ram, 2, pcv_5, 3200, 8, 2, 18);
        ramService.save("Corsair Dominator Platinum RGB DDR4-3200", br_corsair, "Dominator Platinum RGB 32GB DDR4-3200", 199.9, url_ram, cat_ram, 2, pcv_4, 3200, 16, 2, 16);
        ramService.save("Corsair Vengeance LED DRAM DDR4-3600", br_corsair, "Vengeance LED 32GB DRAM DDR4-3600", 499.9, url_ram, cat_ram, 2, pcv_4, 3200, 16, 2, 18);
        ramService.save("Crucial Ballistix MAX RGB 4400", br_crucial, "Ballistix MAX RGB 4400", 249.9, url_ram, cat_ram, 2, pcv_4, 4400, 16, 2, 19);
    }

    @Test
    void saveStorageDrive() {
        storageDriveService.save("Seagate BarraCuda Internal HDD", br_seagate, "BarraCuda Internal HDD", 54.9, url_storageDrive, cat_storagedrive, 2, 2000, sdt_hdd, pcv_4);
        storageDriveService.save("Western Digital WD Black Hard Drive", br_westerndigital, "WD Black Hard Drive", 139.9, url_storageDrive, cat_storagedrive, 2, 2000, sdt_hdd, pcv_4);
        storageDriveService.save("Western Digital Black SN850X", br_westerndigital, "Black SN850X 2TB", 299.9, url_storageDrive, cat_storagedrive, 2, 2000, sdt_m2ssd, pcv_4);
        storageDriveService.save("Western Digital Black SN850X", br_westerndigital, "Black SN850X 1TB", 129.9, url_storageDrive, cat_storagedrive, 2, 1000, sdt_m2ssd, pcv_4);
        storageDriveService.save("Western Digital Black SN850X", br_westerndigital, "Black SN850X 4TB", 629.9, url_storageDrive, cat_storagedrive, 2, 4000, sdt_m2ssd, pcv_4);
        storageDriveService.save("SK Hynix Platinum P41", br_skhynix, "Platinum P41 2TB", 259.9, url_storageDrive, cat_storagedrive, 2, 2000, sdt_m2ssd, pcv_4);
        storageDriveService.save("Western Digital Black SN770", br_westerndigital, "Black SN770 1TB", 99.9, url_storageDrive, cat_storagedrive, 2, 1000, sdt_m2ssd, pcv_4);
        storageDriveService.save("Western Digital Black SN770", br_westerndigital, "Black SN770 500GB", 44.9, url_storageDrive, cat_storagedrive, 2, 500, sdt_m2ssd, pcv_4);
        storageDriveService.save("Seagate FireCuda 530", br_seagate, "FireCuda 530 500GB", 77.9, url_storageDrive, cat_storagedrive, 2, 500, sdt_m2ssd, pcv_4);
        storageDriveService.save("Seagate FireCuda 530", br_seagate, "FireCuda 530 1TB", 119.9, url_storageDrive, cat_storagedrive, 2, 1000, sdt_m2ssd, pcv_4);
        storageDriveService.save("Seagate FireCuda 530", br_seagate, "FireCuda 530 2TB", 219.9, url_storageDrive, cat_storagedrive, 2, 2000, sdt_m2ssd, pcv_4);
        storageDriveService.save("Seagate FireCuda 530", br_seagate, "FireCuda 530 4TB", 549.9, url_storageDrive, cat_storagedrive, 2, 4000, sdt_m2ssd, pcv_4);
        storageDriveService.save("Samsung 990 PRO", br_seagate, "990 PRO 1TB", 154.9, url_storageDrive, cat_storagedrive, 2, 1000, sdt_m2ssd, pcv_4);
        storageDriveService.save("Samsung 990 PRO", br_seagate, "990 PRO 2TB", 269.9, url_storageDrive, cat_storagedrive, 2, 2000, sdt_m2ssd, pcv_4);
        storageDriveService.save("SABRENT ROCKET 4 PLUS", br_sabrent, "ROCKET 4 PLUS 1TB", 129.9, url_storageDrive, cat_storagedrive, 2, 1000, sdt_m2ssd, pcv_4);
        storageDriveService.save("SABRENT ROCKET 4 PLUS", br_sabrent, "ROCKET 4 PLUS 2TB", 239.9, url_storageDrive, cat_storagedrive, 2, 2000, sdt_m2ssd, pcv_4);
        storageDriveService.save("Seagate IronWolf NAS HDD", br_seagate, "IronWolf NAS 8TB HDD", 169.9, url_storageDrive, cat_storagedrive, 2, 8000, sdt_hdd, pcv_4);
        storageDriveService.save("Seagate Exos X18", br_seagate, "Exos x18 18 TB", 269.9, url_storageDrive, cat_storagedrive, 2, 18000, sdt_hdd, pcv_4);
        storageDriveService.save("Seagate BarraCuda Internal HDD", br_seagate, "BarraCuda 8TB Internal HDD", 149.9, url_storageDrive, cat_storagedrive, 2, 8000, sdt_hdd, pcv_4);
        storageDriveService.save("Seagate BarraCuda Internal HDD", br_seagate, "BarraCuda 4TB Internal HDD", 82.9, url_storageDrive, cat_storagedrive, 2, 4000, sdt_hdd, pcv_4);
    }
}
