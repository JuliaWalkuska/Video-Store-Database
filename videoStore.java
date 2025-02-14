public class videoStore {
    static customerList listC = new customerList();
    static videoList listV = new videoList();

    //O(N)
    public static void addCustomer(customer customer){
        customer customer1 = listC.findCustomer(customer.number);
        if(customer1 == null){
            listC.insert(customer);
            System.out.println("\nWe have created an account for you");
            return;
        } else {
            System.out.println("\nThis number is already in the system. If you are not " + customer1.firstName + " " + customer1.lastName + ", please try again with a different number.");
        }

    }

    //O(N)
    public static void addVideo(video video){
        if (listV.getVideo(video.barcode) == null){
            listV.insert(video.name, video.barcode);
            System.out.println("\nMovie added");
            return;
        } else {
            System.out.println("\nA movie with that barcode is already in the system");
        }
    }

    //O(N)
    public static void searchVideo(String barcode){
        video vid = listV.getVideo(barcode);
        if(vid != null){
            System.out.println("\nFound: " + vid.name);
            if (vid.borrowed == false){
                System.out.println("Available");
            } else {
                System.out.println("Borrowed by: " + vid.borrower.firstName + " " + vid.borrower.lastName + " " + vid.borrower.number);
            }
            
            return;
        }
        System.out.println("\nVideo not found");
    }

    //O(N)
    public static void borrow(String number, String barcode){
     if(listC.findCustomer(number) == null){
        System.out.println("\nCustomer not found");
        return;
     }
     
     if(listV.getVideo(barcode) == null){
        System.out.println("\nMovie not found");
        return;
     }
     
     video vid = listV.getVideo(barcode);
     customer cust = listC.findCustomer(number);

     if(vid.borrowed == true){
        System.out.println("\nThis video is currently being borrowed by someone else");
        return;
     }
     
     if (cust.borrowed < 3){
        cust.borrowed = cust.borrowed + 1;
        cust.borrowedVideos.insert(vid.name, vid.barcode);
        vid.borrowed = true;
        vid.borrower = listC.findCustomer(number);
        System.out.println("\nYou successfully borrowed the video");
        return;
     } else {
        System.out.println("\nYou have borrowed the maximum amount of videos, please return some first");
        return;
     }
    }

    //O(N)
    public static void videoReturn(String number, String barcode){
        if(listC.findCustomer(number) == null){
            System.out.println("\nCustomer not found");
            return;
         }
         
         if(listV.getVideo(barcode) == null){
            System.out.println("\nMovie not found");
            return;
         }
         
         video vid = listV.getVideo(barcode);
         customer cust = listC.findCustomer(number);

         vid.borrowed = false;
         vid.borrower = null;
         cust.borrowed = cust.borrowed - 1;
         cust.borrowedVideos.delete(vid.barcode);
         System.out.println("Successfully returned the video");
    }

    //O(N)
    public static void movieList(){
        if (listV.countVideos() == 0){
            System.out.println("We currently don't offer any movies");
            
        } else {
            System.out.println("These are the movies we currently offer:");
            listV.print();
        }
    }

    //O(N)
    public static void findCustomer(String number){
        customer customer1 = listC.findCustomer(number);

        if(customer1 == null){
            System.out.println("\nCustomer not found");
            return;
        }

        System.out.println(customer1.firstName + " " + customer1.lastName + " " + customer1.number);
        System.out.println("Borrowed movies: " + customer1.borrowed);
        customer1.borrowedVideos.print();
        return;
    }


}
