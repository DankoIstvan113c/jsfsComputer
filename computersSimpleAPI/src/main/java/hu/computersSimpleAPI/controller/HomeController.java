package hu.computersSimpleAPI.controller;

import hu.computersSimpleAPI.domain.Computer;
import hu.computersSimpleAPI.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private ComputerService service;

    @GetMapping("/")
    public String home() {
        return "Működik";
    }

    @GetMapping("/computers")
    public List<Computer> getComputers() {
        return service.getComputers();
    }

    @GetMapping("/computers/{id}")
    public Computer getComputer(@PathVariable("id") int id){

        return service.getComputerBySerial(id);
    }

    @GetMapping("/computer/manufacture/{manufacturer}")
    public Computer getComputerByManufacture(@PathVariable("manufacturer") String manufacturer){
        System.out.println("Man: "+manufacturer);
        return service.getComputerByManufacturer(manufacturer);
    }

    @PostMapping("/computers")
    public void addComputer(@RequestBody Computer computer){
        service.addComputer(computer);
    }

    @DeleteMapping("/computers/{id}")
    public void deleteComputer(@PathVariable("id") int id){
         service.deleteComputer(id);
    }

    @PatchMapping("/computers/{id}/{ram}")
    public Computer updateComputer(@PathVariable("id") int id, @PathVariable("ram") int ram){
        return service.updateComputer(id, ram);
    }

    @PutMapping("/computers/{id}")
    public Computer replaceComputer(@PathVariable("id") int id, @RequestBody Computer computer){
        return service.replaceComputer(id, computer);
    }
}
