package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.*;

public class StateRepository implements Repository<State>{
    private Map<String,State> states;

    public StateRepository() {
        this.states = new LinkedHashMap<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(this.states.values());
    }

    @Override
    public void add(State state) {
       states.putIfAbsent(state.getName(),state);
    }

    @Override
    public boolean remove(State state) {
        if (states.containsKey(state.getName())){
            states.remove(state.getName());
            return true;
        }
        return false;
    }

    @Override
    public State byName(String name) {
      return this.states.get(name);
    }
}
