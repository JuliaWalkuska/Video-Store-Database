import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        boolean running = true;

        System.out.println("\nWelcome to Paul's Video Store");
        System.out.println("\nVideo Store Menu:");
            System.out.println("1) Add Video");
            System.out.println("2) Add Customer");
            System.out.println("3) Search customer");
            System.out.println("4) Search video by barcode");
            System.out.println("5) Borrow video");
            System.out.println("6) Return video");
            System.out.println("7) List of all Movies");
            System.out.println("8) Quit");

        while (running){
            System.out.println("\nChoose a option:");
            int choice = scan.nextInt();
            scan.nextLine();

            if (choice == 1){
                System.out.println("What is the name of the video?");
                String videoName = scan.nextLine();
                System.out.println("What is the 12 digit barcode?");
                String barcode = scan.nextLine();

                while (barcode.length() != 12){
                    System.out.println("Invalid barcode, it must be 12 digits. Please retry");
                    barcode = scan.nextLine();
                }
                
                video video = new video(videoName, barcode);
                videoStore.addVideo(video);

            } else if (choice == 2){

                System.out.println("What is the first name of the customer");
                String first = scan.nextLine();
                System.out.println("What is the last name of the customer?");
                String last = scan.nextLine();
                System.out.println("What is the 10 digit phone number?");
                String phoneNumber = scan.nextLine();

                while (phoneNumber.length() != 10){
                    System.out.println("Invalid phone number, it must be 10 digits. Please type it again:");
                    phoneNumber = scan.nextLine();
                }

                customer customer = new customer(first, last, phoneNumber);
                videoStore.addCustomer(customer);

            } else if (choice == 3){
                System.out.println("What is the 10 digit phone number?");
                String phoneNumber = scan.nextLine();

                while (phoneNumber.length() != 10){
                    System.out.println("Invalid phone number, it must be 10 digits. Please type it again:");
                    phoneNumber = scan.nextLine();
                }

                videoStore.findCustomer(phoneNumber);
            
            } else if (choice == 4){
                String barcode;
                
                while(true){
                    System.out.println("Enter the 12 digits of the video barcode");
                    barcode = scan.nextLine();
                    
                    if(barcode.length() == 12 && barcode.matches("\\d+")){
                        break;
                    }else{
                        System.out.println("Invalid barcode, it must be 12 digits. Please retry");
                    }
                }
                
                videoStore.searchVideo(barcode);

            } else if (choice == 5){
                System.out.println("Enter customer phone number:");
                String customerPhone = scan.nextLine();

                while (customerPhone.length() != 10){
                    System.out.println("Invalid phone number, it must be 1 digits. Please type it again:");
                    customerPhone = scan.nextLine();
                }

                System.out.println("Enter movie barcode:");
                String barcode = scan.nextLine();

                while (barcode.length() != 12){
                    System.out.println("Invalid barcode, it must be 12 digits. Please retry");
                    barcode = scan.nextLine();
                }

                videoStore.borrow(customerPhone, barcode);
                
                
            } else if (choice == 6){
                System.out.println("Enter customer phone number:");
                String customerPhone = scan.nextLine();

                while (customerPhone.length() != 10){
                    System.out.println("Invalid phone number, it must be 10 digits. Please type it again:");
                    customerPhone = scan.nextLine();
                }

                System.out.println("Enter movie barcode:");
                String barcode = scan.nextLine();

                while (barcode.length() != 12){
                    System.out.println("Invalid barcode, it must be 12 digits. Please retry");
                    barcode = scan.nextLine();
                }

                videoStore.videoReturn(customerPhone, barcode);
                
                
            } else if (choice == 7){
                videoStore.movieList();

            } else if (choice == 8){
                running = false;
                System.out.println("Bye bitch");

            } else {
                System.out.println("Invalid choice, try again:");
            }
        }
    }
}
