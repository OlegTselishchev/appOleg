package rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.model.Address;
import rest.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService implements Serviceable<Address> {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void create(Address address){
        addressRepository.saveAndFlush(address);
    }

    @Override
    public List<Address> readAll(){
        return addressRepository.findAll();

    }

    @Override
    public Address readById(Integer id){
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(Address address){
        if (addressRepository.existsById(address.getAddressId())) {
            addressRepository.saveAndFlush(address);
            return true;
        }else return false;
    }

    @Override
    public boolean delete(Integer id){
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return true;
        }else return false;
    }

    @Override
    public boolean updatePartial(Address address){
        if (addressRepository.existsById(address.getAddressId())) {
            Address addressForModify = readById(address.getAddressId());
            addressForModify.setAddressId(address.getAddressId());
            addressForModify.setCountry(address.getCountry());
            addressForModify.setCity(address.getCity());
            addressForModify.setStreet(address.getStreet());
            addressForModify.setHome(address.getHome());
            addressForModify.setApartment(address.getApartment());
            addressRepository.saveAndFlush(addressForModify);
            return true;
        }else  return false;
    }
}
