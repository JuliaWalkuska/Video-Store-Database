📽️ Paul's Video Store

A Java-based video rental system where employees can manage customers and videos, track video rentals, and give customers access to video availability.

📌 Features

✔️ Add Customers – Each customer has a first name, last name, and 10-digit phone number.
✔️ Add Videos – Each video has a title and a unique 12-digit barcode.
✔️ Borrow Videos – Customers can borrow up to 3 videos at a time.
✔️ Return Videos – Ensures only borrowed videos are returned.
✔️ Search by Movie Title – Find who currently has a specific movie checked out.
✔️ Search Customers & Videos – Look up customer details by phone number or videos by barcode.

📂 Project Structure

Main.java – Handles user input and manages the menu-driven system.
customer.java – Defines the customer class and tracks borrowed videos.
customerList.java – Implements a custom linked list to store customers.
customerNode.java – Node structure for the customer linked list.
video.java – Represents a video with a title and barcode.
videoList.java – Implements a custom linked list to store videos.
videoNode.java – Node structure for the video linked list.
videoStore.java – Manages video rental operations, including borrowing and returning videos.
