package fr.mns.jee.erasmusnetwork.annonce.client;

import java.util.List;

import fr.mns.jee.erasmusnetwork.annonce.model.House;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(value = "personsClient", url = "http://localhost:8083/house")
public interface CollocationClient {
    @RequestMapping(method = RequestMethod.GET, value = "")
    List<House> getPersons();

//    @GetMapping(value = "/{personId}", produces = "application/json")
//    Person getPersonById(@PathVariable("personId") Long personId);
//
//    @PostMapping(value="")
//    String createNewPerson(@RequestBody Person person);
//
//    @DeleteMapping(value="/{personId}")
//    String deletePerson(@PathVariable("personId") Long personId);

}
