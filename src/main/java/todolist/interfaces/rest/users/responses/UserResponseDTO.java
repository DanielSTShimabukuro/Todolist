package todolist.interfaces.rest.users.responses;

import java.time.LocalDateTime;
import java.util.UUID;

import todolist.domain.users.User;

public record UserResponseDTO(
  UUID id,
  String username,
  String email,
  LocalDateTime createdAt,
  LocalDateTime updatedAt
) {
  public static UserResponseDTO from(User user) {
    return new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail(), user.getCreatedAt(), user.getUpdatedAt());
  }
}
