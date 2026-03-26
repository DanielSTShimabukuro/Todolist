package todolist.application.users;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import todolist.application.exceptions.NotFoundException;
import todolist.domain.users.User;
import todolist.infra.persistence.users.UserRepository;
import todolist.interfaces.rest.users.requests.UserRequestDTO;
import todolist.interfaces.rest.users.responses.UserResponseDTO;

@RequiredArgsConstructor
@Service
public class UpdateUserByIdUseCase {
  private final UserRepository repository;

  @Transactional
  public UserResponseDTO execute(UUID id, UserRequestDTO request) {
    User user = this.repository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found."));

    user.setUsername(request.username());
    user.setEmail(request.email());
    user.setPassword(request.password());
    this.repository.save(user);

    return UserResponseDTO.from(user);
  }
}
