package eu.clltr.collectorcollection;

public class UserCreationService {
    public User createUser(String username, String email) {
        User user = new User(username, email);

        // Przygotowanie wiadomości do RabbitMQ
        sendMessageToRabbitMQ(user);

        return user;
    }

    private void sendMessageToRabbitMQ(User user) {
        try {
            //tyle mi wygernerowal chatGPT  jak to czytam to niby cos kiedys takiego pisalem,
            // ale sporo przede mna jeszcze

            // Konfiguracja połączenia z RabbitMQ
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost"); // Adres RabbitMQ

            // Utworzenie połączenia
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            // Deklaracja kolejki w RabbitMQ
            String queueName = "user_creation_queue"; // Nazwa kolejki
            channel.queueDeclare(queueName, false, false, false, null);

            // Przygotowanie wiadomości
            String message = "Utworzono użytkownika: " + user.getUsername();

            // Publikowanie wiadomości do kolejki w RabbitMQ
            channel.basicPublish("", queueName, null, message.getBytes());
            System.out.println("Wiadomość wysłana do RabbitMQ: '" + message + "'");

            // Zamykanie połączenia
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
