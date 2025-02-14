public class customer implements Comparable<customer>{
    public String firstName;
    public String lastName;
    public String number;
    public int borrowed;
    public videoList borrowedVideos;

    public customer(String firstName, String lastName, String number){
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.borrowedVideos = new videoList();
    }

    public String toString(){
        return this.firstName + " " + this.lastName + ": " + this.number;
    }

    public int compareTo(customer other){
        return firstName.compareTo(other.firstName);
    }
}
   