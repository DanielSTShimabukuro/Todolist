package todolist.application.users;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import todolist.application.exceptions.NotFoundException;
import todolist.domain.users.User;
import todolist.infra.persistence.users.UserRepository;
import todolist.interfaces.rest.users.responses.UserResponseDTO;

@RequiredArgsConstructor
@Service
public class GetUserByIdUseCase {
  private final UserRepository repository;

  @Transactional(readOnly = true)
  public UserResponseDTO execute(UUID id) {
    User user = this.repository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found."));

    return UserResponseDTO.from(user);
  }
}
