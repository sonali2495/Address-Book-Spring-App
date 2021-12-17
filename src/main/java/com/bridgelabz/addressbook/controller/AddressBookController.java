package com.bridgelabz.addressbook.controller;


import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Purpose: to demonstrate different http methods
 *
 * @author : Sonali G
 * @since : 13-12-2021
 */

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;

    /**
     * Purpose : to gives us list of all contact from repository
     *
     * @return : list of all contact
     */
    @RequestMapping("/book")
    public List<AddressBookDto> getAllContact() {
        return addressBookService.getAllContact();
    }

    /**
     * Purpose : To Fetch Contact through id
     *
     * @param id to find this id in repository
     * @return dto of given id
     */
    @GetMapping("/book/{id}")
    public AddressBookDto getContactById(@PathVariable("id") int id) {
        return addressBookService.getContactById(id);
    }

    /**
     * Purpose : To Add Contact in Repository
     *
     * @param addressBookDto : this metadata gets added to repository
     * @return : success message for add
     */
    @PostMapping("/book")
    public String addContact(@Valid @RequestBody AddressBookDto addressBookDto) {
        return addressBookService.addContact(addressBookDto);
    }

    /**
     * Purpose : To Edit Existing Contact
     *
     * @param id             for search data in repository
     * @param addressBookDto for changing existing data to new
     * @return success message for update
     */
    @PutMapping("/book/{id}")
    public String updateContact(@PathVariable(value = "id") int id, @Valid @RequestBody AddressBookDto addressBookDto) {
        return addressBookService.updateContact(id, addressBookDto);
    }

    /**
     * Purpose : To Delete Existing Contact
     *
     * @param id For Search in repo
     * @return success message for delete
     */
    @DeleteMapping("/book/{id}")
    public String deleteContact(@PathVariable(value = "id") int id) {
        return addressBookService.deleteContactById(id);
    }
}
