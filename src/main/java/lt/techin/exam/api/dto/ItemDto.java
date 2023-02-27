package lt.techin.exam.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lt.techin.exam.model.Customer;
import java.util.Objects;

public class ItemDto {

    private String name;
    private Double weight;

    private Integer sector;

    @JsonIgnore
    private Customer customer;
    public ItemDto() {
    }

    public ItemDto(String name, Double weight, Integer sector, Customer customer) {
        this.name = name;
        this.weight = weight;
        this.sector = sector;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getSector() {
        return sector;
    }

    public void setSector(Integer sector) {
        this.sector = sector;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDto itemDto = (ItemDto) o;
        return Objects.equals(name, itemDto.name) && Objects.equals(weight, itemDto.weight) && Objects.equals(sector, itemDto.sector) && Objects.equals(customer, itemDto.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, sector, customer);
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", sector=" + sector +
                ", customer=" + customer +
                '}';
    }
}
