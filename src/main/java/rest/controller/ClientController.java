package rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.model.Client;
import rest.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;


    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/client")
    public ResponseEntity<?> create(@RequestBody Client client){
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/client")
    public ResponseEntity<List<Client>> readAll(){
        final List<Client> clientList = clientService.readAll();
        return clientList != null && !clientList.isEmpty()
                ? new ResponseEntity<>(clientList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/client/{id}")
    public ResponseEntity<Client> readById(@PathVariable(name = "id") Integer id){
        final Client client = clientService.readById(id);
        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/client")
    public ResponseEntity<?> update(@RequestBody Client client){
        final  boolean update = clientService.update(client);
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/client/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Integer id){
        boolean delete = clientService.delete(id);
        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @PatchMapping("/client")
    public ResponseEntity<?> updatePartial(@RequestBody Client client ){
        final boolean updateField = clientService.updatePartial(client);
        return updateField
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
