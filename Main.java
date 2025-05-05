
abstract class Payment {
    abstract void processPayment();
}

class CashPayment extends Payment {
    @Override
    void processPayment() {
        System.out.println(" Paying with cash.");
    }
}

class CardPayment extends Payment {
    @Override
    void processPayment() {
        System.out.println(" Paying with credit card.");
    }
}
 class PaymentDemo {
    public static void main(String[] args) {
        Payment cash = new CashPayment();
        Payment card = new CardPayment();

        cash.processPayment();
        card.processPayment();
    }
}
interface Developer {
    void writeCode();
}

interface Designer {
    void createDesign();
}

interface Marketer {
    void promoteProduct();
}

class SoftwareDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println(" Writing code.");
    }
}

class GraphicDesigner implements Designer {
    @Override
    public void createDesign() {
        System.out.println(" Creating graphic design.");
    }
}

 class CompanyDemo {
    public static void main(String[] args) {
        Developer dev = new SoftwareDeveloper();
        Designer designer = new GraphicDesigner();

        dev.writeCode();
        designer.createDesign();
    }
}
interface NotificationSender {
    void sendNotification();
}

class EmailSender implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println(" Sending email notification.");
    }
}

class SmsSender implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println(" Sending SMS notification.");
    }
}


class SocialNetwork {
    private NotificationSender notification;

    public SocialNetwork(NotificationSender notification) {
        this.notification = notification;
    }

    void notifyUser() {
        notification.sendNotification();
    }
}

 class NotificationDemo {
    public static void main(String[] args) {
        SocialNetwork emailApp = new SocialNetwork(new EmailSender());
        SocialNetwork smsApp = new SocialNetwork(new SmsSender());

        emailApp.notifyUser();
        smsApp.notifyUser();
    }
}
1. მაგაითად გადახდის მეთოდები როდესაც მაღაზიაში შევდივართ არ უნდა იყოს მხოლოდ ერთი გადახდის მეთოდი ან მარტო ქეშით ან მარტო ფეიფალით, ნებისმიერ მომხმარებელზე უნდა იყოს მორგებული.
2. კომპანიაში სადაც პროგრამისტები, დიზაინერები და მარკეტოლოგები მუშაობენ ერთმანეთის საქმიანობა არ უნდა დაევალოთ, ყველას ზუსტად უნდა ჰქონდეს თავისი ფუნქცია განსაზღვრული.
3. სოციალურ ქსელში როდესაც ვაგზავნით შეტყობინებას ფეისბუქზე იმაილის სახით გაგზავნილი შეტყობინება ვერ იმუშავებს.