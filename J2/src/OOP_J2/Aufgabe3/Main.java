package OOP_J2.Aufgabe3;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StreamingService streamingService = new StreamingService();
        System.out.println(streamingService.findFilmByName("HEHE"));

        while (true) {
            System.out.println("\nStreaming Service Options");
            System.out.println("1. Register a Person");
            System.out.println("2. Remove a Person");
            System.out.println("3. Mark a Film as Viewed");
            System.out.println("4. Find a Film by Name");
            System.out.println("5. Find Films by Genre");
            System.out.println("6. Get Views for a Film");
            System.out.println("7. Display Monthly Subscribers' Credit Cards");
            System.out.println("8. Exit");


            int option = scanner.nextInt();
            scanner.nextLine();



            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String personName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String personEmail = scanner.nextLine();
                    System.out.print("Enter credit card: ");
                    String personCreditCard = scanner.nextLine();

                    System.out.println("Select Subscription Type:");
                    System.out.println("1. MONTHLY_SUBSCRIBER");
                    System.out.println("2. YEARLY_SUBSCRIBER");
                    System.out.print("Enter your choice: ");
                    int subscriptionChoice = scanner.nextInt();
                    scanner.nextLine();
                    SubscriptionType subscriptionType = null;
                    switch (subscriptionChoice) {
                        case 1:
                            subscriptionType = SubscriptionType.MONTHLY_SUBSCRIBER;
                            break;
                        case 2:
                            subscriptionType = SubscriptionType.YEARLY_SUBSCRIBER;
                            break;
                        default:
                            System.out.println("Invalid choice for Subscription Type.");
                            break;
                    }
                    if (subscriptionType != null) {
                        ArrayList<Person> personData = new ArrayList<>();
                        Person newPerson = new Person(personName, personEmail, personCreditCard);
                        personData.add(newPerson);
                        newPerson.setSubscriptionType(subscriptionType);
                        streamingService.registerPerson(newPerson);
                        System.out.println("Person registered successfully.");
                        System.out.println(personData.size());
                    }
                    break;
                case 2:
                    System.out.print("Enter the email of the person to remove: ");
                    String emailToRemove = scanner.nextLine();
                    streamingService.removePerson(emailToRemove);
                    break;
                case 3:
                    System.out.print("Enter the name of the film to mark as viewed: ");
                    String filmToMarkViewed = scanner.nextLine();

                    try {
                        Film viewedFilm = streamingService.findFilmByNameForView(filmToMarkViewed);
                        if (viewedFilm != null) {
                            viewedFilm.markAsViewed(); // Mark the film as viewed
                            System.out.println("Film marked as viewed.");
                        } else {
                            System.out.println("Error: Film not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter the name of the film to find: ");
                    String filmToFind = scanner.nextLine();
                    String foundFilmName = streamingService.findFilmByName(filmToFind);
                    if (foundFilmName != null) {
                        System.out.println("Film Found: " + foundFilmName);



                    } else {
                        System.out.println("Error: Film not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter the genre to find films: ");
                    String genreToFind = scanner.nextLine();
                    ArrayList<String> genreFilms = streamingService.findFilmsByGenre(genreToFind);
                    if (genreFilms != null) {
                        System.out.println("Films Found in Genre " + genreFilms);
                    } else {
                        System.out.println("No films found in this genre.");
                    }
                    break;
                case 6:
                    System.out.print("Enter the name of the film to get views: ");
                    String filmToGetViews = scanner.nextLine();
                    int views = streamingService.getViewsForFilm(filmToGetViews);
                    System.out.println("Views for " + filmToGetViews + ": " + views);
                    break;
                case 7:
                    streamingService.displayMonthlyCreditCards();
                    break;
                case 8:
                    System.out.println("Exiting the streaming service.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}