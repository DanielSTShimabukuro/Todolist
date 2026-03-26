package todolist.interfaces.rest.items.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ItemRequestDTO(
  @NotBlank(message = "Name must not be blank.")
  @Size(min = 3, max = 30, message = "Lenght name must be between 3-30 caracteres.")
  String name,

  @Size(max = 5000, message = "Lenght name must be less than 5000 characters.")
  String description
) {
  
}
