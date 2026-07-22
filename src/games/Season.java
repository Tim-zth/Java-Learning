package games;

public enum Season {

    SPRING(1.2, 0.5),
    SUMMER(1.0, 0.3),
    AUTUMN(0.7, 0.9),
    WINTER(0.2, 1.2);

    private final double resourceRecoveryMultiplier;
    private final double energyConsumptionMultiplier;

    Season(double resourceRecoveryMultiplier, double energyWasteMultiplier){
        this.resourceRecoveryMultiplier = resourceRecoveryMultiplier;
        this.energyConsumptionMultiplier = energyWasteMultiplier;
    }

    public double getResourceRecoveryMultiplier() {
        return resourceRecoveryMultiplier;
    }

    public double getEnergyConsumptionMultiplier(){
        return energyConsumptionMultiplier;
    }
}
