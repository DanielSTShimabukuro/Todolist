package todolist.application.items;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import todolist.application.exceptions.NotFoundException;
import todolist.domain.items.Item;
import todolist.domain.users.User;
import todolist.infra.persistence.items.ItemRepository;
import todolist.infra.persistence.users.UserRepository;
import todolist.interfaces.rest.items.requests.ItemRequestDTO;
import todolist.interfaces.rest.items.responses.ItemResponseDTO;

@RequiredArgsConstructor
@Service
public class CreateItemUseCase {
  private final ItemRepository repository;
  private final UserRepository userRepository;

  @Transactional
  public ItemResponseDTO execute(UUID userId, ItemRequestDTO request) {
    User user = this.userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found."));
    Item item = new Item(user, request);

    this.repository.save(item);

    return ItemResponseDTO.from(item);
  }
}
