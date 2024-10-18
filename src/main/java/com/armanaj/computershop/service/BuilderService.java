package com.armanaj.computershop.service;

import com.armanaj.computershop.exception.BuildProductNotFoundException;
import com.armanaj.computershop.model.products.*;
import com.armanaj.computershop.payload.request.BuildRequest;
import com.armanaj.computershop.payload.response.BuildResponse;
import com.armanaj.computershop.service.products.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BuilderService {

    private static class BuilderFunctionResponse<T extends Product> {

        @Getter
        @Setter
        private T product;

        @Getter
        @Setter
        private String warningMessage;
    }

    private static class BuilderResultSet {
        @Getter
        private final List<Product> productList = new ArrayList<>();

        @Getter
        private final List<String> warningMessageList = new ArrayList<>();
    }


    private Double cashDifference = 0.0;
    private final CaseService caseService;
    private final CPUService cpuService;
    private final GPUService gpuService;
    private final MotherboardService motherboardService;
    private final PowerSupplyService powerSupplyService;
    private final RamService ramService;
    private final StorageDriveService storageDriveService;

    public BuilderService(CaseService caseService, CPUService cpuService, GPUService gpuService,
                          MotherboardService motherboardService, PowerSupplyService powerSupplyService,
                          RamService ramService, StorageDriveService storageDriveService) {
        this.caseService = caseService;
        this.cpuService = cpuService;
        this.gpuService = gpuService;
        this.motherboardService = motherboardService;
        this.powerSupplyService = powerSupplyService;
        this.ramService = ramService;
        this.storageDriveService = storageDriveService;
    }

    public BuildResponse build(BuildRequest request) {
        BuildResponse response = new BuildResponse();

        BuilderResultSet firstResultSet = buildFirstResultSet(request);
        BuilderResultSet secondResultSet;
        BuilderResultSet finalResultSet;

        if (cashDifference < 0) {
            cashDifference = 0.0;
            secondResultSet = buildSecondResultSet(request);
            if (cashDifference >= 0) {
                finalResultSet = secondResultSet;
            } else {
                finalResultSet = firstResultSet;
            }
        } else {
            finalResultSet = firstResultSet;
        }

        finalResultSet.getWarningMessageList().removeIf(Objects::isNull);
        finalResultSet.getProductList().removeIf(Objects::isNull);

        response.setWarningList(finalResultSet.getWarningMessageList());
        response.setProductList(finalResultSet.getProductList());

        double priceSum = 0;
        for (Product product : finalResultSet.getProductList()) {
            priceSum += product.getPrice();
        }
        response.setItemCount(finalResultSet.getProductList().size());
        response.setPriceSum(priceSum);
        return response;
    }

    private BuilderResultSet buildFirstResultSet(BuildRequest request) {
        BuilderResultSet resultSet = new BuilderResultSet();
        List<Product> resultSetProductList = resultSet.getProductList();
        List<String> resultSetWarningMessageList = resultSet.getWarningMessageList();

        List<Double> partBudgetList = calculateInitialPartBudgetList(request, generateFirstResultSetPercentageList(request));

        BuilderFunctionResponse<Case> caseResponse = buildCase(partBudgetList.get(0), request.getFormFactor());
        resultSetProductList.add(caseResponse.getProduct());
        resultSetWarningMessageList.add(caseResponse.getWarningMessage());
        if (caseResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, caseResponse.getProduct().getPrice());

        BuilderFunctionResponse<StorageDrive> storageDriveResponse = buildStorageDrive(partBudgetList.get(0), request.getStorageDriveCapacity(), request.getStorageDriveType());
        resultSetProductList.add(storageDriveResponse.getProduct());
        resultSetWarningMessageList.add(storageDriveResponse.getWarningMessage());
        if (storageDriveResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, storageDriveResponse.getProduct().getPrice());

        BuilderFunctionResponse<CPU> cpuResponse = buildCPU(partBudgetList.get(0), request.getCpuBrand(), request.getCpuGeneration());
        resultSetProductList.add(cpuResponse.getProduct());
        resultSetWarningMessageList.add(cpuResponse.getWarningMessage());
        if (cpuResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, cpuResponse.getProduct().getPrice());

        BuilderFunctionResponse<Motherboard> motherboardResponse = buildMotherboard(partBudgetList.get(0), request.getFormFactor(), cpuResponse.getProduct().getSocket().getId());
        resultSetProductList.add(motherboardResponse.getProduct());
        resultSetWarningMessageList.add(motherboardResponse.getWarningMessage());
        if (motherboardResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, motherboardResponse.getProduct().getPrice());

        BuilderFunctionResponse<Ram> ramResponse = buildRam(partBudgetList.get(0), request.getRamCapacity(), cpuResponse.getProduct().getPCIEVersion().getId());
        resultSetProductList.add(ramResponse.getProduct());
        resultSetWarningMessageList.add(ramResponse.getWarningMessage());
        if (ramResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, ramResponse.getProduct().getPrice());

        BuilderFunctionResponse<GPU> gpuResponse = buildGPU(partBudgetList.get(0), request.getGpuChipsetBrand(), request.getGpuGeneration());
        resultSetProductList.add(gpuResponse.getProduct());
        resultSetWarningMessageList.add(gpuResponse.getWarningMessage());
        if (gpuResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, gpuResponse.getProduct().getPrice());

        BuilderFunctionResponse<PowerSupply> powerSupplyResponse = buildPowerSupply(partBudgetList.get(0), request.getFormFactor(), request.getPowerRating(), cpuResponse.getProduct().getPowerDraw() + gpuResponse.getProduct().getPowerDraw());
        resultSetProductList.add(powerSupplyResponse.getProduct());
        resultSetWarningMessageList.add(powerSupplyResponse.getWarningMessage());
        if (powerSupplyResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, powerSupplyResponse.getProduct().getPrice());

        return resultSet;
    }

    private BuilderResultSet buildSecondResultSet(BuildRequest request) {
        BuilderResultSet resultSet = new BuilderResultSet();
        List<Product> resultSetProductList = resultSet.getProductList();
        List<String> resultSetWarningMessageList = resultSet.getWarningMessageList();

        List<Double> partBudgetList = calculateInitialPartBudgetList(request, generateSecondResultSetPercentageList(request));

        BuilderFunctionResponse<GPU> gpuResponse = buildGPU(partBudgetList.get(0), request.getGpuChipsetBrand(), request.getGpuGeneration());
        resultSetProductList.add(gpuResponse.getProduct());
        resultSetWarningMessageList.add(gpuResponse.getWarningMessage());
        if (gpuResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, gpuResponse.getProduct().getPrice());

        BuilderFunctionResponse<CPU> cpuResponse = buildCPU(partBudgetList.get(0), request.getCpuBrand(), request.getCpuGeneration());
        resultSetProductList.add(cpuResponse.getProduct());
        resultSetWarningMessageList.add(cpuResponse.getWarningMessage());
        if (cpuResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, cpuResponse.getProduct().getPrice());

        BuilderFunctionResponse<Ram> ramResponse = buildRam(partBudgetList.get(0), request.getRamCapacity(), cpuResponse.getProduct().getPCIEVersion().getId());
        resultSetProductList.add(ramResponse.getProduct());
        resultSetWarningMessageList.add(ramResponse.getWarningMessage());
        if (ramResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, ramResponse.getProduct().getPrice());

        BuilderFunctionResponse<PowerSupply> powerSupplyResponse = buildPowerSupply(partBudgetList.get(0), request.getFormFactor(), request.getPowerRating(), cpuResponse.getProduct().getPowerDraw() + gpuResponse.getProduct().getPowerDraw());
        resultSetProductList.add(powerSupplyResponse.getProduct());
        resultSetWarningMessageList.add(powerSupplyResponse.getWarningMessage());
        if (powerSupplyResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, powerSupplyResponse.getProduct().getPrice());

        BuilderFunctionResponse<Motherboard> motherboardResponse = buildMotherboard(partBudgetList.get(0), request.getFormFactor(), cpuResponse.getProduct().getSocket().getId());
        resultSetProductList.add(motherboardResponse.getProduct());
        resultSetWarningMessageList.add(motherboardResponse.getWarningMessage());
        if (motherboardResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, motherboardResponse.getProduct().getPrice());

        BuilderFunctionResponse<StorageDrive> storageDriveResponse = buildStorageDrive(partBudgetList.get(0), request.getStorageDriveCapacity(), request.getStorageDriveType());
        resultSetProductList.add(storageDriveResponse.getProduct());
        resultSetWarningMessageList.add(storageDriveResponse.getWarningMessage());
        if (storageDriveResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, storageDriveResponse.getProduct().getPrice());

        BuilderFunctionResponse<Case> caseResponse = buildCase(partBudgetList.get(0), request.getFormFactor());
        resultSetProductList.add(caseResponse.getProduct());
        resultSetWarningMessageList.add(caseResponse.getWarningMessage());
        if (caseResponse.getProduct() != null)
            calculateRemainingRatio(partBudgetList, caseResponse.getProduct().getPrice());

        return resultSet;
    }

    private List<Double> generateFirstResultSetPercentageList(BuildRequest request) {
        List<Double> percentageList = new ArrayList<>();
        percentageList.add(request.getCasePercentage());
        percentageList.add(request.getStorageDrivePercentage());
        percentageList.add(request.getCpuPercentage());
        percentageList.add(request.getMotherboardPercentage());
        percentageList.add(request.getRamPercentage());
        percentageList.add(request.getGpuPercentage());
        percentageList.add(request.getPowerSupplyPercentage());
        return percentageList;
    }

    private List<Double> generateSecondResultSetPercentageList(BuildRequest request) {
        List<Double> percentageList = new ArrayList<>();
        percentageList.add(request.getGpuPercentage());
        percentageList.add(request.getCpuPercentage());
        percentageList.add(request.getRamPercentage());
        percentageList.add(request.getPowerSupplyPercentage());
        percentageList.add(request.getMotherboardPercentage());
        percentageList.add(request.getStorageDrivePercentage());
        percentageList.add(request.getCasePercentage());
        return percentageList;
    }

    private List<Double> calculateInitialPartBudgetList(BuildRequest request, List<Double> percentageList) {
        List<Double> partBudgetList = new ArrayList<>();
        Double budget = request.getBudget();
        for (Double percentage : percentageList) {
            partBudgetList.add(budget * percentage);
        }
        return partBudgetList;
    }

    private void calculateRemainingRatio(List<Double> partBudgetList, Double realisedPrice) {
        double priceGap = partBudgetList.remove(0) - realisedPrice;
        cashDifference += priceGap;
        partBudgetList.replaceAll(aDouble -> aDouble + (priceGap / partBudgetList.size()));
    }

    private BuilderFunctionResponse<CPU> buildCPU(Double budget, Integer cpuBrand, Integer cpuGeneration) {
        String categoryName = "CPU";
        BuilderFunctionResponse<CPU> result = new BuilderFunctionResponse<>();
        try {
            CPU product = cpuService.findCPUsForBuilder(budget, cpuBrand, cpuGeneration).get(0);
            result.setProduct(product);
            if (product.getPrice() > budget) {
                result.warningMessage = overBudgetMessageBuilder(categoryName, product.getPrice());
            }
        } catch (BuildProductNotFoundException e) {
            result.warningMessage = productNotFoundMessageBuilder(categoryName);
        }
        return result;
    }

    private BuilderFunctionResponse<GPU> buildGPU(Double budget, Integer gpuChipsetBrand, Integer gpuGeneration) {
        String categoryName = "GPU";
        BuilderFunctionResponse<GPU> result = new BuilderFunctionResponse<>();
        try {
            GPU product = gpuService.findGPUsForBuilder(budget, gpuChipsetBrand, gpuGeneration).get(0);
            result.setProduct(product);
            if (product.getPrice() > budget) {
                result.warningMessage = overBudgetMessageBuilder(categoryName, product.getPrice());
            }
        } catch (BuildProductNotFoundException e) {
            result.warningMessage = productNotFoundMessageBuilder(categoryName);
        }
        return result;
    }

    private BuilderFunctionResponse<Case> buildCase(Double budget, Integer formFactor) {
        String categoryName = "Case";
        BuilderFunctionResponse<Case> result = new BuilderFunctionResponse<>();
        try {
            Case product = caseService.findCasesForBuilder(budget, formFactor).get(0);
            result.setProduct(product);
            if (product.getPrice() > budget) {
                result.warningMessage = overBudgetMessageBuilder(categoryName, product.getPrice());
            }
        } catch (BuildProductNotFoundException e) {
            result.warningMessage = productNotFoundMessageBuilder(categoryName);
        }
        return result;
    }

    private BuilderFunctionResponse<Motherboard> buildMotherboard(Double budget, Integer formFactor, Integer socket) {
        String categoryName = "motherboard";
        BuilderFunctionResponse<Motherboard> result = new BuilderFunctionResponse<>();
        try {
            Motherboard product = motherboardService.findMotherboardsForBuilder(budget, socket, formFactor).get(0);
            result.setProduct(product);
            if (product.getPrice() > budget) {
                result.warningMessage = overBudgetMessageBuilder(categoryName, product.getPrice());
            }
        } catch (BuildProductNotFoundException e) {
            result.warningMessage = productNotFoundMessageBuilder(categoryName);
        }
        return result;
    }

    private BuilderFunctionResponse<PowerSupply> buildPowerSupply(Double budget, Integer formFactor, Integer powerRating, Integer powerRequirement) {
        String categoryName = "power supply";
        BuilderFunctionResponse<PowerSupply> result = new BuilderFunctionResponse<>();
        Integer powerSupplyFormFactor = formFactor == 1 ? 3 : 1;
        try {
            PowerSupply product = powerSupplyService.findPowerSuppliesForBuilder(budget, powerSupplyFormFactor, powerRating, powerRequirement).get(0);
            result.setProduct(product);
            if (product.getPrice() > budget) {
                result.warningMessage = overBudgetMessageBuilder(categoryName, product.getPrice());
            }
        } catch (BuildProductNotFoundException e) {
            result.warningMessage = productNotFoundMessageBuilder(categoryName);
        }
        return result;
    }

    private BuilderFunctionResponse<Ram> buildRam(Double budget, Integer capacity, Integer pcieVersion) {
        String categoryName = "ram";
        BuilderFunctionResponse<Ram> result = new BuilderFunctionResponse<>();
        try {
            Ram product = ramService.findRamsForBuilder(budget, capacity, pcieVersion).get(0);
            result.setProduct(product);
            if (product.getPrice() > budget) {
                result.warningMessage = overBudgetMessageBuilder(categoryName, product.getPrice());
            }
        } catch (BuildProductNotFoundException e) {
            result.warningMessage = productNotFoundMessageBuilder(categoryName);
        }
        return result;
    }

    private BuilderFunctionResponse<StorageDrive> buildStorageDrive(Double budget, Integer capacity, Integer storageDriveType) {
        String categoryName = "storage drive";
        BuilderFunctionResponse<StorageDrive> result = new BuilderFunctionResponse<>();
        try {
            StorageDrive product = storageDriveService.findStorageDrivesForBuilder(budget, capacity, storageDriveType).get(0);
            result.setProduct(product);
            if (product.getPrice() > budget) {
                result.warningMessage = overBudgetMessageBuilder(categoryName, product.getPrice());
            }
        } catch (BuildProductNotFoundException e) {
            result.warningMessage = productNotFoundMessageBuilder(categoryName);
        }
        return result;
    }

    private String overBudgetMessageBuilder(String category, Double price) {

        return "Given the preferences provided, no" + wrapWS(category) + "under the specified budget was found." +
                "\n" + "The closest part price-wise, with the price of" + wrapWS(price) + "was selected.";
    }

    private String productNotFoundMessageBuilder(String category) {
        return "Given the preferences provided, no" + wrapWS(category) + "was found." +
                "\n" + "Please consider changing your preferences, or tinkering with the advanced options.";
    }

    private String wrapWS(Object text) {
        return " " + text.toString() + " ";
    }

}
