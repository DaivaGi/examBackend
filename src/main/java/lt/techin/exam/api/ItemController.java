package lt.techin.exam.api;

import lt.techin.exam.api.dto.ItemDto;
import lt.techin.exam.api.dto.ItemEntityDto;
import lt.techin.exam.model.Item;
import lt.techin.exam.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static lt.techin.exam.api.dto.mapper.ItemMapper.toItemEntityDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/items")
@Validated
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{customerId}/items")
    @ResponseBody
    public List<Item> getItems(@PathVariable Long customerId) {
        return itemService.getAll(customerId);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemEntityDto> getComment(@PathVariable Long itemId) {
        var itemOptional = itemService.getById(itemId);
        var responseEntity = itemOptional
                .map(comment -> ok(toItemEntityDto(comment)))
                .orElseGet(() -> ResponseEntity.notFound().build());
                return responseEntity;
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long itemId) {
        var itemDeleted = itemService.deleteById(itemId);

        if (itemDeleted) {
            return ResponseEntity.noContent().build();//
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<ItemEntityDto> createItem(@PathVariable Long customerId, @Valid @RequestBody ItemDto itemDto) {
        var createdItem = itemService.create(customerId, itemDto);
        return ok(toItemEntityDto(createdItem));
    }

}
