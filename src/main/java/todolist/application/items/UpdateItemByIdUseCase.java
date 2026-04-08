package todolist.application.items;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import todolist.application.exceptions.NotFoundException;
import todolist.domain.items.Item;
import todolist.infra.persistence.items.ItemRepository;
import todolist.interfaces.rest.items.requests.ItemRequestDTO;
import todolist.interfaces.rest.items.responses.ItemResponseDTO;

@RequiredArgsConstructor
@Service
public class UpdateItemByIdUseCase {
  private final ItemRepository repository;

  @Transactional
  public ItemResponseDTO execute(UUID id, ItemRequestDTO request) {
    Item item = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Item Not Found."));

    item.setName(request.name());
    item.setDescription(request.description());
    this.repository.save(item);

    return ItemResponseDTO.from(item);
  }
}
