package todolist.application.users;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import todolist.application.exceptions.NotFoundException;
import todolist.domain.users.User;
import todolist.infra.persistence.users.UserRepository;

@RequiredArgsConstructor
@Service
public class DeleteUserByIdUseCase {
  private final UserRepository repository;

  @Transactional
  public void execute(UUID id) {
    User user = repository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found."));
    
    repository.delete(user);
  }
}
