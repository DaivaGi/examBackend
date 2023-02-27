package lt.techin.exam.api.dto.mapper;

import lt.techin.exam.api.dto.ItemDto;
import lt.techin.exam.api.dto.ItemEntityDto;
import lt.techin.exam.model.Item;


public class ItemMapper {

    public static ItemDto toItemDto(Item item) {
        var itemDto = new ItemDto();

        itemDto.setName(item.getName());
        itemDto.setWeight(item.getWeight());
        itemDto.setSector(item.getSector());
        itemDto.setCustomer(item.getCustomer());


        return itemDto;
    }

    public static Item toItem(ItemDto itemDto) {
        var item = new Item();

        item.setName(itemDto.getName());
        item.setWeight(itemDto.getWeight());
        item.setSector(item.getSector());
        item.setCustomer(itemDto.getCustomer());

        return item;
    }


    public static ItemEntityDto toItemEntityDto(Item item) {
        var itemDto = new ItemEntityDto();

       itemDto.setId(item.getId());
        itemDto.setName(item.getName());
        itemDto.setWeight(item.getWeight());
        itemDto.setSector(item.getSector());
        itemDto.setCustomer(item.getCustomer());
        itemDto.setCreatedDate(item.getCreatedDate());

        return itemDto;
    }

    public static Item toItem(ItemEntityDto itemDto) {
        var item = new Item();

        item.setName(itemDto.getName());
        item.setWeight(itemDto.getWeight());
        item.setSector(itemDto.getSector());
        item.setCustomer(itemDto.getCustomer());

        return item;
    }

}
