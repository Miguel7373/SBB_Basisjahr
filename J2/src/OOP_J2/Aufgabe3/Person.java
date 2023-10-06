package OOP_J2.Aufgabe3;

enum SubscriptionType {
    MONTHLY_SUBSCRIBER,
    YEARLY_SUBSCRIBER
}

class Person {
    private String name;
    private String email;
    private String creditCard;
    private SubscriptionType subscriptionType;

    public Person(String name, String email, String creditCard) {
        this.name = name;
        this.email = email;
        this.creditCard = creditCard;
        this.subscriptionType = SubscriptionType.MONTHLY_SUBSCRIBER;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public void switchSubscriptionType() {
        subscriptionType = (subscriptionType == SubscriptionType.MONTHLY_SUBSCRIBER) ?
                SubscriptionType.YEARLY_SUBSCRIBER :
                SubscriptionType.MONTHLY_SUBSCRIBER;
    }
    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}