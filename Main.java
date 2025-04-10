import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Task>> userTasks = new HashMap<>();
        Set<String> registeredUsers = new HashSet<>();
        String currentUser = null;

        while(true){

            System.out.println("command: ");
            String command = scanner.nextLine().trim();

            if (command.startsWith("register ")) {
                String username = command.substring(9).trim();
                if (registeredUsers.contains(username)) {
                    System.out.println("Username already exists.");
                } else {
                    registeredUsers.add(username);
                    userTasks.put(username, new HashMap<>());
                    System.out.println("User \"" + username + "\" registered successfully.");
                }
                continue;
            } else if (command.startsWith("login ")) {
                String username = command.substring(6).trim();
                if (registeredUsers.contains(username)) {
                    currentUser = username;
                    System.out.println("Logged in as \"" + username + "\"");
                } else {
                    System.out.println("Username not found. Please register first.");
                }
                continue;
            } else if (command.equals("ls")) {
                if (registeredUsers.isEmpty()) {
                    System.out.println("No users registered yet.");
                } else {
                    System.out.println("Registered users:");
                    for (String user : registeredUsers) {
                        System.out.println("- " + user);
                    }
                }
                continue;
            }

            if (currentUser == null) {
                System.out.println("Please log in first to use task commands.");
                continue;
            }

            if (command.equals("save basicTask")){
                Map<String, Task> tasks = userTasks.get(currentUser);

                System.out.print("Enter task name: ");
                String name = scanner.nextLine().trim();

                if (tasks.containsKey(name)) {
                    System.out.println("A task with the name \"" + name + "\" already exists. Please choose a different name.");
                    continue;
                }

                System.out.print("Enter task definition: ");
                String definition = scanner.nextLine().trim();

                System.out.print("Enter created by (username): ");
                String createdBy = scanner.nextLine().trim();

                BasicTask task = new BasicTask(name, definition, createdBy);
                tasks.put(name, task);
                System.out.println("Task \"" + name + "\" saved successfully.");

            } else if (command.equals("save limitedTimeTask")) {
                Map<String, Task> tasks = userTasks.get(currentUser);

                System.out.print("Enter task name: ");
                String name = scanner.nextLine().trim();

                if (tasks.containsKey(name)) {
                    System.out.println("A task with the name \"" + name + "\" already exists. Please choose a different name.");
                    continue;
                }

                System.out.print("Enter task definition: ");
                String definition = scanner.nextLine().trim();

                System.out.print("Enter created by (username): ");
                String createdBy = scanner.nextLine().trim();

                LocalDateTime deadline1 = null;
                boolean validDeadline = false;

                while (!validDeadline) {
                    System.out.print("Enter deadline (yyyy-MM-dd HH:mm or MM-dd yyyy HH:mm): ");
                    String deadlineInput = scanner.nextLine().trim();

                    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM-dd yyyy HH:mm");

                    try {
                        if (deadlineInput.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
                            deadline1 = LocalDateTime.parse(deadlineInput, formatter1);
                        } else if (deadlineInput.matches("\\d{2}-\\d{2} \\d{4} \\d{2}:\\d{2}")) {
                            deadline1 = LocalDateTime.parse(deadlineInput, formatter2);
                        } else {
                            throw new DateTimeParseException("Invalid date format", deadlineInput, 0);
                        }

                        if (deadline1.getMonthValue() == 2 && deadline1.getDayOfMonth() > 28) {
                            throw new DateTimeParseException("Invalid date: February " + deadline1.getDayOfMonth(), deadlineInput, 0);
                        }

                        validDeadline = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date/time format. Please use yyyy-MM-dd HH:mm or MM-dd yyyy HH:mm.");
                    }
                }

                LimitedTimeTask task = new LimitedTimeTask(name, definition, createdBy, deadline1);
                tasks.put(name, task);
                System.out.println("Limited time task \"" + name + "\" saved successfully.");

            } else if (command.equals("save repeatableTask")) {
                Map<String, Task> tasks = userTasks.get(currentUser);

                System.out.print("Enter task name: ");
                String name = scanner.nextLine().trim();

                if (tasks.containsKey(name)) {
                    System.out.println("A task with the name \"" + name + "\" already exists. Please choose a different name.");
                    continue;
                }

                System.out.print("Enter task definition: ");
                String definition = scanner.nextLine().trim();

                System.out.print("Enter task repeat count(integer): ");
                int repeatCount = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Enter task repeat time: ");
                String repeatTime = scanner.nextLine().trim();

                System.out.print("Enter created by (username): ");
                String createdBy = scanner.nextLine().trim();

                RepeatableTask task = new RepeatableTask(name, definition, createdBy, repeatCount, repeatTime);
                tasks.put(name, task);
                System.out.println("Repeatable task \"" + name + "\" saved successfully.");

            } else if (command.equals("delete .")) {
                Map<String, Task> tasks = userTasks.get(currentUser);
                tasks.clear();
                System.out.println("All tasks have been deleted.");

            } else if (command.startsWith("delete ")) {
                Map<String, Task> tasks = userTasks.get(currentUser);
                String taskID = command.substring(7).trim();

                if (tasks.containsKey(taskID)) {
                    tasks.remove(taskID);
                    System.out.println("Task with ID " + taskID + " deleted.");
                } else {
                    System.out.println("Task ID not found.");
                }

            } else if (command.equals("load .")) {
                Map<String, Task> tasks = userTasks.get(currentUser);
                for (Map.Entry<String, Task> entry : tasks.entrySet()) {
                    System.out.println("ID: " + entry.getKey());
                    System.out.println(entry.getValue().getDetails());
                    System.out.println();
                }

            } else if (command.startsWith("load ")) {
                Map<String, Task> tasks = userTasks.get(currentUser);
                String taskID = command.substring(5).trim();

                if (tasks.containsKey(taskID)) {
                    Task task = tasks.get(taskID);
                    System.out.println("ID: " + taskID);
                    System.out.println(task.getDetails());
                } else {
                    System.out.println("Task ID not found.");
                }

            } else if (command.startsWith("update ")) {
                Map<String, Task> tasks = userTasks.get(currentUser);
                String oldName = command.substring(7).trim();

                if (tasks.containsKey(oldName)) {
                    Task task = tasks.get(oldName);
                    String newName = oldName;  

                    if (task instanceof BasicTask basicTask) {
                        System.out.println("Enter new name (current: " + basicTask.getName() + "): ");
                        String input = scanner.nextLine().trim();
                        if (!input.isEmpty()) {
                            newName = input;
                            basicTask.setName(newName);
                        }

                        System.out.println("Enter new definition (current: " + basicTask.getDefinition() + "): ");
                        input = scanner.nextLine().trim();
                        if (!input.isEmpty()) basicTask.setDefinition(input);

                        System.out.println("Enter new created by (current: " + basicTask.getCreatedBy() + "): ");
                        input = scanner.nextLine().trim();
                        if (!input.isEmpty()) basicTask.setCreatedBy(input);

                    } else if (task instanceof LimitedTimeTask limitedTimeTask) {
                        System.out.println("Enter new name (current: " + limitedTimeTask.getName() + "): ");
                        String input = scanner.nextLine().trim();
                        if (!input.isEmpty()) {
                            newName = input;
                            limitedTimeTask.setName(newName);
                        }

                        System.out.println("Enter new definition (current: " + limitedTimeTask.getDefinition() + "): ");
                        input = scanner.nextLine().trim();
                        if (!input.isEmpty()) limitedTimeTask.setDefinition(input);

                        System.out.println("Enter new created by (current: " + limitedTimeTask.getCreatedBy() + "): ");
                        input = scanner.nextLine().trim();
                        if (!input.isEmpty()) limitedTimeTask.setCreatedBy(input);

                        boolean validDeadline = false;
                        while (!validDeadline) {
                            System.out.print("Enter new deadline (current: " + limitedTimeTask.getDeadline() + "): ");
                            input = scanner.nextLine().trim();

                            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("MM-dd yyyy HH:mm");

                            try {
                                if (input.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
                                    limitedTimeTask.setDeadline(LocalDateTime.parse(input, formatter1));
                                } else if (input.matches("\\d{2}-\\d{2} \\d{4} \\d{2}:\\d{2}")) {
                                    limitedTimeTask.setDeadline(LocalDateTime.parse(input, formatter2));
                                } else {
                                    throw new DateTimeParseException("Invalid date format", input, 0);
                                }
                                validDeadline = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date/time format. Please use yyyy-MM-dd HH:mm or MM-dd yyyy HH:mm.");
                            }
                        }

                    } else if (task instanceof RepeatableTask repeatableTask) {
                        System.out.println("Enter new name (current: " + repeatableTask.getName() + "): ");
                        String input = scanner.nextLine().trim();
                        if (!input.isEmpty()) {
                            newName = input;
                            repeatableTask.setName(newName);
                        }

                        System.out.println("Enter new definition (current: " + repeatableTask.getDefinition() + "): ");
                        input = scanner.nextLine().trim();
                        if (!input.isEmpty()) repeatableTask.setDefinition(input);

                        System.out.println("Enter new created by (current: " + repeatableTask.getCreatedBy() + "): ");
                        input = scanner.nextLine().trim();
                        if (!input.isEmpty()) repeatableTask.setCreatedBy(input);

                        System.out.println("Enter new repeat count (current: " + repeatableTask.getRepeatCount() + "): ");
                        try {
                            input = scanner.nextLine().trim();
                            if (!input.isEmpty()) {
                                int newRepeatCount = Integer.parseInt(input);
                                repeatableTask.setRepeatCount(newRepeatCount);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format. Repeat count unchanged.");
                        }

                        System.out.println("Enter new repeat time (current: " + repeatableTask.getRepeatTime() + "): ");
                        input = scanner.nextLine().trim();
                        if (!input.isEmpty()) repeatableTask.setRepeatTime(input);
                    }

                    if (!newName.equals(oldName)) {
                        tasks.remove(oldName);
                        tasks.put(newName, task);
                    }

                    System.out.println("Task updated successfully.");
                } else {
                    System.out.println("Task ID not found.");
                }
            } else if (command.equals("exit")) {
                break;
            }
        }
    }
}
