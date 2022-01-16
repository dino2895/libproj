import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    public static ArrayList<Book> BookList = new ArrayList<>();
    public static ArrayList<User> UserList = new ArrayList<>();
    public static int bookid;
    
    public static void initbook(Scanner scn) {
        int num = Integer.parseInt(scn.nextLine());
        for (int i = 0; i < num; i++) {
            Book book = new Book();
            book.setbook(i, scn.nextLine());
            bookid = i;
            BookList.add(book);
        }
    }
    public static void inituser(Scanner scn) {
        int num = Integer.parseInt(scn.nextLine());
        for (int i = 0; i < num; i++) {
            User user = new User();
            user.set(scn.nextLine());
            UserList.add(user);
        }
    }
    public static void cmd(Scanner scn){
        while(scn.hasNextLine()){
            String sp[] = scn.nextLine().split(" ");
            String command=sp[1];
            switch(command){
                case "addBook":addBook(sp[0],scn);break;
                case "removeBook":removeBook(sp[0],sp[2]);break;
                case "checkout":checkout(sp[0],sp[2],scn);break;
                case "return":doreturn(sp[0],sp[2]);break;
                case "listAuthor":listAuthor(sp[0],sp[2]);break;
                case "listSubject":listSubject(sp[0],sp[2]);break;
                case "findChecked":findChecked(sp[0],sp[2]);break;
                case "findBorrower":findBorrower(sp[0],sp[2]);break;
            }
        }
    }
    private static void addBook(String suser,Scanner scn){
        if(checkuser(suser)){
            Book book = new Book();
            bookid++;
            book.setbook(bookid,scn.nextLine());
        }
        else{
            System.out.println("user Permission denied");
            scn.nextLine();
        }
    }
    private static void removeBook(String suser,String id){
        if(checkuser(suser)){
            Book del = new Book();
            for(Book book:BookList){
                if(book.getid()==Integer.parseInt(id)){
                    del = book;
                }
            }
            BookList.remove(del);
        }
        else{
            System.out.println("user Permission denied");
        }
    }
    private static void checkout(String suser,String user,Scanner scn){
        if(checkuser(suser)){
            String sp[] = scn.nextLine().split(" ");
            for(String id:sp){
                for(Book book:BookList){
                    if(book.getid()==Integer.parseInt(id)){
                        book.setborrower(user);
                        book.setavail(false);
                    }
                }
            }
        }
        else{
            System.out.println("user Permission denied");
            scn.nextLine();
        }
        
    }
    private static void doreturn(String suser,String id){
        if(checkuser(suser)){
            for(Book book:BookList){
                if(book.getid()==Integer.parseInt(id)){
                    book.setborrower("");
                    book.setavail(true);
                }
            }
        }else{
            System.out.println("user Permission denied");
        }
    }
    private static void listAuthor(String suser,String Author){
        if(checkuser(suser)){
            for(Book book:BookList){
                if(book.getauthor().equals(Author)){
                    book.print();
                    writefile(book.printfile());
                }
            }
            // System.out.println("authorprint!");
        }else{
            System.out.println("user Permission denied");
        }
    }
    private static void listSubject(String suser,String Subject){
        if(checkuser(suser)){
            for(Book book:BookList){
                if(book.getsubject().equals(Subject)){
                    book.print();
                    writefile(book.printfile());
                }
            }
            // System.out.println("subjectprint!");
        }else{
            System.out.println("user Permission denied");
        }
    }
    private static void findChecked(String suser,String user){
        Book found = new Book();
        if(checkuser(suser)){
            for(Book book:BookList){
                if(book.getborrower().equals(user)){
                    found = book;
                }
            }
            found.print();
            writefile(found.printfile());
        }else{
            System.out.println("user Permission denied");
        }
    }
    private static void findBorrower(String suser,String id){
        Book found = new Book();
        if(checkuser(suser)){
            for(Book book:BookList){
                if(book.getid()==Integer.parseInt(id)){
                    found = book;
                }
            }
            
            System.out.println("User: "+found.getborrower());
            writefile("User: "+found.getborrower());
            // System.out.println("findBorrowerprint!");
        }else{
            System.out.println("user Permission denied");
        }
    }
    private static boolean checkuser(String checkuser){
        for(User user:UserList){
            if(user.getUserName().equals(checkuser))
                if(user.getUserType().equals("Staff"))
                    return true;
        }
        return false;
    }
    public static void writefile(String w){
        try {
            FileWriter fw = new FileWriter("sampleOutput",true);
            fw.write(w);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void listalldata() {
        for (Book book : BookList) {
            book.print();
        }
        System.out.println();
        for (User user : UserList) {
            user.print();
        }
    }
}
