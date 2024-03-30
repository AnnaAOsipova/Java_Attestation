import java.util.*;

public class Phonebook {
    public static void main(String[] args) {
        Map<String, List<String>> phonebook = new HashMap<>();
        // создаем список Фамилий с номерами телефонов
        addContact(phonebook, "Иванов", "55-46-79");
        addContact(phonebook, "Беспалов", "12-23-15");
        addContact(phonebook, "Ильин", "74-23-37");
        addContact(phonebook, "Иванов", "32-27-50");
        addContact(phonebook, "Садчикова", "50-08-17");
        addContact(phonebook, "Ильин", "66-33-54");
        addContact(phonebook, "Сидорова", "83-12-47");
        addContact(phonebook, "Ильин", "43-98-65");

        printPhoneBook(phonebook);
    }

    private static void addContact(Map<String, List<String>> phonebook, String name, String phoneNumber) 
    {
        phonebook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    } // проверяем, если в телефонной книге уже есть фамилия, добавляем телефон к имеющемуся списку номеров. Если нет, добавляем новый контакт

    private static void printPhoneBook(Map<String, List<String>> phonebook) {

        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phonebook.entrySet());

        entries.sort(Comparator.comparingInt(entry -> entry.getValue().size())); 
        // сортируем по количеству номеров, привязанных к одной фамилии
        for (int i = entries.size() - 1; i >= 0; i--) {
            Map.Entry<String, List<String>> entry = entries.get(i);
            String name = entry.getKey(); // ключ - имя
            List<String> phoneNumbers = entry.getValue(); // значение - коллекция номеров

            System.out.println(name + ": " + phoneNumbers);
        }
    }
}