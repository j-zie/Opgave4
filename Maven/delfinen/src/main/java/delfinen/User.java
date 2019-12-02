package delfinen;

public class User {

    private int roleID, memberID, age;
    private String name, phone;

    //TODO fetch data from DB
    User() {

    }

    //TODO set variables
    User(int roleID, int memberID, int age, String name, String phone) {
        this.roleID = roleID;
        this.memberID = memberID;
        this.age = age;
        this.name = name;
        this.phone = phone;
    }

    //TODO make setters update DB
    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
