package com.armanaj.computershop;

import com.armanaj.computershop.payload.request.BuildRequest;
import com.armanaj.computershop.payload.response.BuildResponse;
import com.armanaj.computershop.service.BuilderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BuilderServiceTest {

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
    private BuilderService builderService;

    @Test
    void testBuilder() {
        BuildRequest request = new BuildRequest(3000.0, br_nvidia, br_amd, gp_gf30, cp_z4, mff_atx, pwr_gold,
                16, sdt_m2ssd, 500,
                0.20, 0.40, 0.06, 0.10,
                0.06, 0.08, 0.08);
        BuildResponse response = builderService.build(request);
    }

}
