package net.example.springbootdemo.controller;

import net.example.springbootdemo.model.Clients;
import net.example.springbootdemo.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientsController {

    private final ClientsService clientsService;

    @Autowired
    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping("/clients")
    public String findAll(Model model){
        List<Clients> clients = clientsService.findAll();
        model.addAttribute("clients", clients);
        return "clients-list";
    }

    @GetMapping("/clients-create")
    public String createClientsForm(Clients clients){
        return "clients-create";
    }

    @PostMapping("/clients-create")
    public String createClients(Clients clients){
        clientsService.saveClient(clients);
        return "redirect:/clients";
    }

    @GetMapping("clients-delete/{id}")
    public String deleteClients(@PathVariable("id") Long id){
        clientsService.deleteById(id);
        return "redirect:/clients";
    }

    @GetMapping("/clients-update/{id}")
    public String updateClientsForm(@PathVariable("id") Long id, Model model){
        Clients clients = clientsService.findById(id);
        model.addAttribute("clients", clients);
        return "clients-update";
    }

    @PostMapping("/clients-update")
    public String updateClients(Clients clients){
        clientsService.saveClient(clients);
        return "redirect:/clients";
    }

    @PostMapping("/manager")
    public String findClientsByManager(@RequestParam String manager, Model model) {
        List<Clients> clients = clientsService.findByManager(manager);
        model.addAttribute("clients", clients);
        return "clients-list";
    }

    @PostMapping("/adress")
    public String findClientsByAdress(@RequestParam String adress, Model model) {
        List<Clients> clients = clientsService.findByAdress(adress);
        model.addAttribute("clients", clients);
        return "clients-list";
    }
}
