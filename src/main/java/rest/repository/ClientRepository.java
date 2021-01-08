package rest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import rest.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}