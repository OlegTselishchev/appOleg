package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.model.Address;
import rest.service.AddressService;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/address")
    public ResponseEntity<?> create(@RequestBody Address address){
        addressService.create(address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/address")
    public ResponseEntity<List<Address>>readeAll(){
        final List<Address> clientList = addressService.readAll();
        return clientList != null && !clientList.isEmpty()
                ? new ResponseEntity<>(clientList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/address/{id}")
    public ResponseEntity<Address> readId(@PathVariable(name = "id") int id){
        final Address address = addressService.readById(id);
        return address != null
                ? new ResponseEntity<>(address, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/address")
    public ResponseEntity<?> update(@RequestBody Address address){
        final  boolean update = addressService.update(address);
        return update
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/address/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        boolean delete = addressService.delete(id);
        return delete
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @CrossOrigin(origins = "https://app-oleg-f.herokuapp.com")
    //@CrossOrigin(origins = "http://localhost:4200")
    @PatchMapping("/address")
    public ResponseEntity<?> updatePartial(@RequestBody Address address ){
        final boolean updateField = addressService.updatePartial(address);
        return updateField
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
