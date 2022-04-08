package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer {
    private final static double INITIAL_ENERGY = 60;
    private final static double DECREASE_ENERGY = 7;

    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        if (getEnergy() <= DECREASE_ENERGY) {
            super.setEnergy(0);
        }
        super.setEnergy(this.getEnergy() - DECREASE_ENERGY);
    }
}
