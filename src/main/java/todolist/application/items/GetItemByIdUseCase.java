package todolist.application.items;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import todolist.application.exceptions.NotFoundException;
import todolist.domain.items.Item;
import todolist.infra.persistence.items.ItemRepository;
import todolist.interfaces.rest.items.responses.ItemResponseDTO;

@RequiredArgsConstructor
@Service
public class GetItemByIdUseCase {
  private final ItemRepository repository;

  public ItemResponseDTO execute(UUID id) {
    Item item = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Item Not Found."));

    return ItemResponseDTO.from(item);
  }
}
