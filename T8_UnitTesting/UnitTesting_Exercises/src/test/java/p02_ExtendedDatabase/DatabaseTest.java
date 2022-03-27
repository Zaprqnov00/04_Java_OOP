package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {


    @Test
    public void testAddPersonInDatabase() throws OperationNotSupportedException {
        Person person = new Person(5010, "Teo");
        Person person2 = new Person(2030, "Pesho");

        Database database = new Database(person);
        database.add(person2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testMultiplyIdUsers() throws OperationNotSupportedException {
        Person first = new Person(5050,"Misho");
        Person second = new Person(5050,"Teo");

        if (first.getId() == second.getId()){
            throw new OperationNotSupportedException();
        }

        Database database = new Database(first);
        database.add(second);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testNullOrNegativeIdOperation() throws OperationNotSupportedException {
        Person person = new Person(-5,"Sasho");

        if (person.getId() < 0){
            throw new OperationNotSupportedException();
        }
    }

    @Test
    public void testRemovePersonOperation() throws OperationNotSupportedException {
        Person person = new Person(123,"Alex");
        Person person2 = new Person(123465,"Azis");

        Database database = new Database(person,person2);

        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveOperationShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database();

        database.remove();
    }

    @Test
    public void testFindPeopleByUsernameOperation() throws OperationNotSupportedException {
        Person first = new Person(12,"Teo");

        Database database = new Database(first);
        database.findByUsername("Teo");

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPeopleWIthWrongUsernameThrowException() throws OperationNotSupportedException {
        Person person = new Person(10,"Azis");
        Person person1 = new Person(11,"Fiki");

        Database database = new Database(person,person1);
        database.findByUsername("Emanuela");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testUsernameIsNullThrowException() throws OperationNotSupportedException {
        Database database = new Database(new Person(12,"Ivan"));

        database.findByUsername(null);
    }

    @Test
    public void testDatabaseTrueReturnElements() throws OperationNotSupportedException {
        Person person = new Person(12,"Blago");
        Person person1 = new Person(13,"Miro");
        Database database = new Database(person,person1);

        Assert.assertEquals(database.getElements().length,2);
    }

    @Test
    public void testPeopleId(){
        Person person = new Person(156,"Teodor");

        Assert.assertEquals(person.getId(),156);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullPerson() throws OperationNotSupportedException {
        Person person = null;
        Database database = new Database(person);
        database.add(person);
    }

    @Test
    public void testReturnPeopleById() throws OperationNotSupportedException {
        Person person = new Person(9930,"Mimi");
        Person secondPerson = new Person(9940,"Alisiq");

        Database database = new Database(person);
        database.add(secondPerson);
        database.findById(9930);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCheckPeopleSizeThrowException() throws OperationNotSupportedException {
        Person person = new Person(1,"Fiki");
        Person person2 = new Person(1,"Azis");
        Person person3 = new Person(3,"Toni");

        Database database = new Database(person,person2,person3);
        database.findById(1);

    }
}