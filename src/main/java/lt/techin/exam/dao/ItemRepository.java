package lt.techin.exam.dao;


import lt.techin.exam.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {


   List<Item> findAllByCustomer_IdOrderByCreatedDateDesc(Long customerId);

}
