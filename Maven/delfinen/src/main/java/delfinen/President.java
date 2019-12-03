package delfinen;

public class President extends User{

    //TODO Fetch data from DB
    President() {

    }

    //temp constructor for testing purposes
    President(int roleID, int memberID, int age, String name, String phone) {
        super(roleID,memberID,age,name,phone);
    }

    void createMember() {
        System.out.println("hello there");
    }
}
