package bg.sofia.uni.fmi.mjt.simcity.utility;

import bg.sofia.uni.fmi.mjt.simcity.property.billable.Billable;

import java.util.Map;

public class UtilityService implements UtilityServiceAPI {
    Map<UtilityType, Double> taxRates;

    public UtilityService(Map<UtilityType, Double> taxRates) {
        this.taxRates = taxRates;
    }

    @Override
    public <T extends Billable> double getUtilityCosts(UtilityType utilityType, T billable) {
        switch (utilityType) {
            case WATER:
                return billable.getWaterConsumption() * taxRates.get(utilityType);
            case ELECTRICITY:
                return billable.getElectricityConsumption() * taxRates.get(utilityType);
            case NATURAL_GAS:
                return billable.getNaturalGasConsumption() * taxRates.get(utilityType);
            default:
                return 0;
        }
    }

    @Override
    public <T extends Billable> double getTotalUtilityCosts(T billable) {
        double totalCosts = 0;
        for (UtilityType utilityType : UtilityType.values()) {
            totalCosts += getUtilityCosts(utilityType, billable);
        }
        return totalCosts;
    }

    @Override
    public <T extends Billable> Map<UtilityType, Double> computeCostsDifference(T firstBillable, T secondBillable) {
        Map<UtilityType, Double> costsDifference = Map.of(
                UtilityType.WATER, Math.abs(getUtilityCosts(UtilityType.WATER, firstBillable)
                        - getUtilityCosts(UtilityType.WATER, secondBillable)),
                UtilityType.ELECTRICITY, Math.abs(getUtilityCosts(UtilityType.ELECTRICITY, firstBillable)
                        - getUtilityCosts(UtilityType.ELECTRICITY, secondBillable)),
                UtilityType.NATURAL_GAS, Math.abs(getUtilityCosts(UtilityType.NATURAL_GAS, firstBillable)
                        - getUtilityCosts(UtilityType.NATURAL_GAS, secondBillable))
        );
        return costsDifference;
    }
}
