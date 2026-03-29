package todolist.interfaces.rest.items;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import todolist.application.items.CreateItemUseCase;
import todolist.interfaces.rest.items.requests.ItemRequestDTO;
import todolist.interfaces.rest.items.responses.ItemResponseDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users/{userId}/items")
public class ItemController {
  private final CreateItemUseCase createItemUseCase;

  @PostMapping
  public ResponseEntity<ItemResponseDTO> createItem(@PathVariable UUID userId, @RequestBody @Valid ItemRequestDTO request) {
    ItemResponseDTO response = this.createItemUseCase.execute(userId, request);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }
}
