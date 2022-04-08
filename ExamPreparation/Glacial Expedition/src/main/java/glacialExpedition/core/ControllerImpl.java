package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private Repository<Explorer> explorerRepository;
    private Repository<State> stateRepository;
    private int exploredStatesCount;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }


    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type){
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);

        return String.format(ConstantMessages.EXPLORER_ADDED,type,explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);

        for (String exhibition :exhibits) {
            state.getExhibits().add(exhibition);
        }

        this.stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED,stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = this.explorerRepository.byName(explorerName);

        if (explorer == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST,explorerName));
        }
        this.explorerRepository.remove(explorer);
        return String.format(ConstantMessages.EXPLORER_RETIRED,explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        State state = this.stateRepository.byName(stateName);
        Collection<Explorer> explorers = this.explorerRepository
                .getCollection()
                .stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());

        long countExplorers = explorers
                .stream()
                .filter(e -> e.getEnergy() == 0)
                .count();

        if (explorers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        mission.explore(state,explorers);
        this.exploredStatesCount++;

        return String.format(ConstantMessages.STATE_EXPLORER,stateName,countExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder result = new StringBuilder();

        result.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, this.exploredStatesCount))
                .append(System.lineSeparator());
        result.append(ConstantMessages.FINAL_EXPLORER_INFO).append(System.lineSeparator());

        this.explorerRepository
                .getCollection()
                .forEach(explorer -> result
                        .append(explorer.toString())
                        .append(System.lineSeparator()));

        return result.toString().trim();
    }
}
