package T4_Interfaces.Lab.SayHelloExtend_04;

import T4_Interfaces.Lab.SayHello_03.Person;

public abstract class BasePerson implements Person {
    private String name;

    protected BasePerson(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
