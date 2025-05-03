//  Chef class (Handles cooking only)
class Chef {
    void cookFood() {
        System.out.println(" Chef is preparing the food.");
    }
}

//  Waiter class (Handles customer service)
class Waiter {
    void serveCustomer() {
        System.out.println(" Waiter is serving the customer.");
    }
}

//  Accountant class (Handles finances)
class Accountant {
    void manageFinances() {
        System.out.println(" Accountant is managing the finances.");
    }
}

 class Restaurant {
    public static void main(String[] args) {
        Chef chef = new Chef();
        Waiter waiter = new Waiter();
        Accountant accountant = new Accountant();

        chef.cookFood();
        waiter.serveCustomer();
        accountant.manageFinances();
    }
}//  Base class for social media platforms
abstract class SocialMediaPlatform {
    abstract void postContent();
}

//  Facebook (Basic functionality)
class Facebook extends SocialMediaPlatform {
    @Override
    void postContent() {
        System.out.println(" Posting on Facebook...");
    }
}

// Instagram (New feature, but core remains unchanged)
class Instagram extends SocialMediaPlatform {
    @Override
    void postContent() {
        System.out.println("Uploading a photo on Instagram.");
    }
}
class SocialMediaDemo {
    public static void main(String[] args) {
        SocialMediaPlatform facebook = new Facebook();
        SocialMediaPlatform instagram = new Instagram();

        facebook.postContent();
        instagram.postContent();
    }
}