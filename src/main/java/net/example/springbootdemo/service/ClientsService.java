package net.example.springbootdemo.service;

import net.example.springbootdemo.model.Clients;
import net.example.springbootdemo.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public Clients findById(Long id){
        return clientsRepository.findById(id).get();
    }

    public List<Clients> findAll(){
        return clientsRepository.findAll();
    }

    public Clients saveClient(Clients client){
        return clientsRepository.save(client);
    }

    public void deleteById(Long id){
        clientsRepository.deleteById(id);
    }

    public List<Clients> findByManager(String manager) {
        return clientsRepository.findClientsByManager(manager);
    }

    public List<Clients> findByAdress(String adress) {
        return clientsRepository.findClientsByAdress(adress);
    }
}
