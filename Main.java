public class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(String message) {
        super(message);
    }
}
@RestController
@RequestMapping("/api")
public class PersonController {

    @PostMapping("/person")
    public ResponseEntity<String> createPerson(@Valid @RequestBody Person person) {

        if ("bad".equalsIgnoreCase(person.getFirstName())) {
            throw new CustomRuntimeException("Invalid first name");
        }

        return ResponseEntity.ok("Person accepted");
    }
}
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<String> handleCustomException(CustomRuntimeException ex) {
        return new ResponseEntity<>(ex.getClass().getSimpleName(), HttpStatus.BAD_REQUEST);
    }

}
public class Person {

    @NotNull(message = "First name must not be null")
    private String firstName;

    @NotNull(message = "Last name must not be null")
    private String lastName;


    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>