public class User {
    public String firstName;
    public String secondName;
    public int age;

    public User(String firstName, String secondName, int age){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getSecondName(){
        return secondName;
    }
    public void setName(String firstName, String secondName){
        this.firstName = firstName;
        this.secondName = secondName;
    }
public  int getAge(){
        return age;
}
public void setAge(){
        this.age = age;
}
@Override
    public String toString(){
    return  "User{" + "first name = " + firstName + ", second name = " + secondName +
             ", age = " + age + "}";
    }
}
