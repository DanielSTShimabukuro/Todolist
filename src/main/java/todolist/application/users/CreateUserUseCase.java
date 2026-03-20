package todolist.application.users;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import todolist.domain.users.User;
import todolist.infra.persistence.users.UserRepository;
import todolist.interfaces.rest.users.requests.UserCreateRequestDTO;
import todolist.interfaces.rest.users.responses.UserResponseDTO;

@Service
public class CreateUserUseCase {
  private final UserRepository repository;

  public CreateUserUseCase(UserRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public UserResponseDTO execute(UserCreateRequestDTO request) {
    User user = request.toEntity();

    this.repository.save(user);

    return new UserResponseDTO().toResponse(user);
  }
}
