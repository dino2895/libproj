public class Book {
    private int id;
    private String author;
    private String subject;
    private String borrower;
    private boolean avail;

    public void setbook(int id, String raw) {
        this.id = id;
        String sp[] = raw.split(" ");
        this.author = sp[0];
        this.subject = sp[1];
        this.borrower = "none";
        this.avail = true;
    }

    public void print() {
        System.out.print("ID: " + id
                + " Author: " + author
                + " Subject: " + subject + "\n");
    }

    public String printfile() {
        return ("ID: " + id
                + " Author: " + author
                + " Subject: " + subject + "\n");
    }

    public void setid(String id) {
        if (id.isBlank()) {
            System.out.println("id not be empty!");
        } else {
            this.id = Integer.parseInt(id);
        }
    }

    public void setauthor(String author) {
        if (author.isBlank()) {
            System.out.println("author not be empty!");
        } else {
            this.author = author;
        }
    }

    public void setsubject(String subject) {
        if (subject.isBlank()) {
            System.out.println("subject not be empty!");
        } else {
            this.subject = subject;
        }
    }

    public void setborrower(String borrower) {
        if (borrower.isBlank()) {
            // System.out.println("borrower not be empty!");
        } else {
            this.borrower = borrower;
        }
    }

    public void setavail(boolean avail) {
        this.avail = avail;
    }

    public int getid() {
        return this.id;
    }

    public String getauthor() {
        return this.author;
    }

    public String getsubject() {
        return this.subject;
    }

    public String getborrower() {
        return this.borrower;
    }

    public boolean getavail() {
        return this.avail;
    }
}