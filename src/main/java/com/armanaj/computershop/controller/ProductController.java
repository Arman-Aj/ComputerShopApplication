package com.armanaj.computershop.controller;

import com.armanaj.computershop.model.products.*;
import com.armanaj.computershop.payload.response.ProductResponse;
import com.armanaj.computershop.service.products.*;
import com.armanaj.computershop.service.products.productBaseInfo.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final BrandService brandService;
    private final CategoryService categoryService;
    private final CPUGenerationService cpuGenerationService;
    private final GPUGenerationService gpuGenerationService;
    private final MotherboardFormFactorService motherBoardFormFactorService;
    private final PCIEVersionService pcieVersionService;
    private final PowerRatingService powerRatingService;
    private final PowerSupplyFormFactorService powerSupplyFormFactorService;
    private final SocketService socketService;
    private final StorageDriveTypeService storageDriveTypeService;

    private final CaseService caseService;
    private final CPUService cpuService;
    private final GPUService gpuService;
    private final MotherboardService motherboardService;
    private final PowerSupplyService powerSupplyService;
    private final ProductService productService;
    private final RamService ramService;
    private final StorageDriveService storageDriveService;

    public ProductController(BrandService brandService, CategoryService categoryService, CPUGenerationService cpuGenerationService,
                             GPUGenerationService gpuGenerationService, MotherboardFormFactorService motherBoardFormFactorService,
                             PCIEVersionService pcieVersionService, PowerRatingService powerRatingService,
                             PowerSupplyFormFactorService powerSupplyFormFactorService, SocketService socketService,
                             StorageDriveTypeService storageDriveTypeService, CaseService caseService,
                             CPUService cpuService, GPUService gpuService, MotherboardService motherboardService,
                             PowerSupplyService powerSupplyService, ProductService productService, RamService ramService,
                             StorageDriveService storageDriveService) {
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.cpuGenerationService = cpuGenerationService;
        this.gpuGenerationService = gpuGenerationService;
        this.motherBoardFormFactorService = motherBoardFormFactorService;
        this.pcieVersionService = pcieVersionService;
        this.powerRatingService = powerRatingService;
        this.powerSupplyFormFactorService = powerSupplyFormFactorService;
        this.socketService = socketService;
        this.storageDriveTypeService = storageDriveTypeService;
        this.caseService = caseService;
        this.cpuService = cpuService;
        this.gpuService = gpuService;
        this.motherboardService = motherboardService;
        this.powerSupplyService = powerSupplyService;
        this.productService = productService;
        this.ramService = ramService;
        this.storageDriveService = storageDriveService;
    }


    //Base Info
    @GetMapping("/base-info/brand")
    public ResponseEntity<?> getAllBrands() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @GetMapping("/base-info/category")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/base-info/cpu-generation")
    public ResponseEntity<?> getAllCPUGenerations() {
        return ResponseEntity.ok(cpuGenerationService.getAllCPUGenerations());
    }

    @GetMapping("/base-info/gpu-generation")
    public ResponseEntity<?> getAllGPUGenerations() {
        return ResponseEntity.ok(gpuGenerationService.getAllGPUGenerations());
    }

    @GetMapping("/base-info/motherboard-form-factor")
    public ResponseEntity<?> getAllMotherboardFormFactors() {
        return ResponseEntity.ok(motherBoardFormFactorService.getAllMotherboardFormFactors());
    }

    @GetMapping("/base-info/pcie-version")
    public ResponseEntity<?> getAllPCIEVersions() {
        return ResponseEntity.ok(pcieVersionService.getAllPCIEVersions());
    }

    @GetMapping("/base-info/power-rating")
    public ResponseEntity<?> getAllPowerRatings() {
        return ResponseEntity.ok(powerRatingService.getAllPowerRatings());
    }

    @GetMapping("/base-info/power-supply-form-factor")
    public ResponseEntity<?> getAllPowerSupplieFormFactors() {
        return ResponseEntity.ok(powerSupplyFormFactorService.getAllPowerSupplyFormFactors());
    }

    @GetMapping("/base-info/socket")
    public ResponseEntity<?> getAllSockets() {
        return ResponseEntity.ok(socketService.getAllSockets());
    }

    @GetMapping("/base-info/storage-drive-type")
    public ResponseEntity<?> getAllStorageDriveTypes() {
        return ResponseEntity.ok(storageDriveTypeService.getAllStorageDriveTypes());
    }

    @GetMapping("/case")
    public ResponseEntity<ProductResponse<Case>> getAllCases(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchText) {
        return ResponseEntity.ok(caseService.getAllCases(page == 0 ? page : page - 1, searchText));
    }

    @GetMapping("/cpu")
    public ResponseEntity<ProductResponse<CPU>> getAllCPUs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchText) {
        return ResponseEntity.ok(cpuService.getAllCPUs(page == 0 ? page : page - 1, searchText));
    }

    @GetMapping("/gpu")
    public ResponseEntity<ProductResponse<GPU>> getAllGPUs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchText) {
        return ResponseEntity.ok(gpuService.getAllGPUs(page == 0 ? page : page - 1, searchText));
    }

    @GetMapping("/motherboard")
    public ResponseEntity<ProductResponse<Motherboard>> getAllMotherboards(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchText) {
        return ResponseEntity.ok(motherboardService.getAllMotherboards(page == 0 ? page : page - 1, searchText));
    }

    @GetMapping("/power-supply")
    public ResponseEntity<ProductResponse<PowerSupply>> getAllPowerSupplies(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchText) {
        return ResponseEntity.ok(powerSupplyService.getAllPowerSupplies(page == 0 ? page : page - 1, searchText));
    }

    @GetMapping
    public ResponseEntity<ProductResponse<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchText) {
        return ResponseEntity.ok(productService.getAllProducts(page == 0 ? page : page - 1, searchText));
    }

    @GetMapping("/ram")
    public ResponseEntity<ProductResponse<Ram>> getAllRams(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchText) {
        return ResponseEntity.ok(ramService.getAllRams(page == 0 ? page : page - 1, searchText));
    }

    @GetMapping("/storage-drive")
    public ResponseEntity<ProductResponse<StorageDrive>> getAllStorageDrives(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "") String searchText) {
        return ResponseEntity.ok(storageDriveService.getAllStorageDrives(page == 0 ? page : page - 1, searchText));
    }
}
