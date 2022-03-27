package T4_Interfaces.Lab.SayHelloExtend_04;

public class European extends BasePerson{
    public European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
