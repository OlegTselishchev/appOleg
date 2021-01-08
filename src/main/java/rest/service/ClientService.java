package rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.model.Client;
import rest.repository.ClientRepository;

import java.util.List;


@Service
public class ClientService implements Serviceable<Client>{

    @Autowired
    private  final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public void create(Client client){
        clientRepository.saveAndFlush(client);
    }

    @Override
    public List<Client> readAll(){
        return clientRepository.findAll();

    }

    @Override
    public Client readById(Integer id){
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(Client client){
        if (clientRepository.existsById(client.getUserId())) {
            clientRepository.saveAndFlush(client);
            return true;
        }else return false;
    }

    @Override
    public boolean delete(Integer id){
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }else return false;
    }

    @Override
    public boolean updatePartial(Client client){
        if (clientRepository.existsById(client.getUserId())) {
            Client clientForModify = readById(client.getUserId());
            clientForModify.setUserId(client.getUserId());
            clientForModify.setLastName(client.getLastName());
            clientForModify.setFirstName(client.getFirstName());
            clientForModify.setMiddleName(client.getMiddleName());
            clientForModify.setPhone(client.getPhone());
            clientForModify.setEmail(client.getEmail());
            clientForModify.setDriveCategory(client.getDriveCategory());
            clientRepository.saveAndFlush(clientForModify);
            return true;
        }else  return false;
    }

}
