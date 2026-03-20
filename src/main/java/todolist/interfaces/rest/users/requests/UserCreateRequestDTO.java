package todolist.interfaces.rest.users.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import todolist.domain.users.User;

public record UserCreateRequestDTO(
  @NotBlank(message = "Username must not be blank.")
  @Size(min = 3, max = 30, message = "Lenght usename must be between 3-30 caracteres.")
  String username,

  @Email(message = "Invalid email.")
  @Size(min = 6, max = 320, message = "Invalid email.")
  String email,

  @NotBlank(message = "Password must not be blank")
  String password
) {
  public User toEntity() {
    User user = new User(username, email, password);

    return user;
  }
}
