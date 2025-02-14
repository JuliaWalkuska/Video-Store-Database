public class videoList {
    public videoNode head;

    public videoList() {
        head = null;
    }

    //O(N)
    public void insert(String name, String barcode) {
        video newVideo = new video(name, barcode);
        videoNode newNode = new videoNode(newVideo);

        if (head == null || barcode.compareTo(head.video.barcode) < 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        videoNode current = head;
        while (current.next != null && current.next.video.barcode.compareTo(barcode) < 0) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    //O(N)
    public void print() {
        videoNode current = head;
        while (current != null) {
            System.out.println(current.video.toString());
            current = current.next;
        }
    }

    //O(N)
    public video getVideo(String barcode) {
        videoNode current = head;
        while (current != null) {
            if (current.video.barcode.equals(barcode)) {
                return current.video;
            }
            current = current.next;
        }
        return null;
    }

    //O(N)
    public int countVideos() {
        int count = 0;
        videoNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
        
    //O(N)
    public void delete(String barcode) {
        if (head == null) {
            return; 
        }

        if (head.video.barcode.equals(barcode)) {
            head = head.next; 
            return;
        }

        videoNode current = head;
        while (current.next != null) {
            if (current.next.video.barcode.equals(barcode)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    }


    
