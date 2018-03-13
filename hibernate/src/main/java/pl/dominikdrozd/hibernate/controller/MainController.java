package pl.dominikdrozd.hibernate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.dominikdrozd.hibernate.model.Person;
import pl.dominikdrozd.hibernate.repository.PersonRepository;

@Controller
public class MainController {

    @Autowired
    private PersonRepository personRepository;



    @GetMapping("/people")
    public String displayAll(ModelMap modelMap){
        modelMap.addAttribute("people",personRepository.findAll());
        return "index";
    }

    @GetMapping("/people/new")
    public String add(){
        return "add";
    }

    @PostMapping("/people")
    public String create(@ModelAttribute Person person,
                         ModelMap modelMap){
        personRepository.save(person);
        modelMap.addAttribute("person",person);
        return "created";
    }


    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id, ModelMap modelMap){
        modelMap.addAttribute("person",personRepository.findById(id).get());
        personRepository.deleteById(id);
        return "delete";
    }

    @GetMapping("/findbysurname")
    public String findWithSurname(){
        return "findbysurname";
    }

    @PostMapping("/found")
    public String foundBySurname(@RequestParam String surname, ModelMap modelMap){
        modelMap.addAttribute("person",personRepository.findBySurname(surname));
        return "found";
}

@GetMapping("/findbyname")
public String findWithName(){
        return "findbyname";
}

@PostMapping("/foundname")
    public String foundByName(@RequestParam String name, ModelMap modelMap){
        modelMap.addAttribute("person",personRepository.findByName(name));
    return "foundname";
    }
    @GetMapping("/people/{id}")
    public String findperson(@PathVariable Long id, ModelMap modelMap){
        modelMap.addAttribute("person",personRepository.findById(id).get());
        return "findperson";
    }


    @GetMapping("/people/edit/{id}")
    public String editPerson(@PathVariable Long id,ModelMap modelMap){
        modelMap.addAttribute("person",personRepository.findById(id).get());
        return "edit";
    }


}