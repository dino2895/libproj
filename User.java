public class User {
    private String UserType;
    private String UserName;
    private int BorrowNum;

    public void set(String raw){
        String sp[] = raw.split(" ");
        if(sp.length==2){
            this.UserType = "Staff";
            this.UserName = sp[1];
        }
        else{
            this.UserType = "Borrower";
            this.UserName = sp[1];
            this.BorrowNum = Integer.parseInt(sp[2]);
        }
    }
    public void print(){
        System.out.printf("UserType "+UserType
                        +" UserName "+UserName
                        +" BorrowNum "+BorrowNum+"\n");
    }

    public void setUserType(String UserType){
        if(UserType.isBlank()){
            System.out.println("usertype not be blank!");
        }
        else if(UserType.equalsIgnoreCase("Staff")
            ||UserType.equalsIgnoreCase("Borrower")){
                this.UserType = UserType;
        }
    }
    public void setUserName(String UserName){
        if(UserName.isBlank()){
            System.out.println("UserName not be blank!");
        }
        else{
            this.UserName = UserName;
        }
    }
    public void setBorrowNum(int BorrowNum){
        if(BorrowNum<1){
            System.out.println("borrorNumb not be 0 or less 0");
        }
        else{
            this.BorrowNum = BorrowNum;
        }
    }
    public String getUserType(){
        return this.UserType;
    }
    public String getUserName(){
        return this.UserName;
    }
    public int getBorrowNum(){
        return this.BorrowNum;
    }
}
