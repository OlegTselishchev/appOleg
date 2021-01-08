package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
