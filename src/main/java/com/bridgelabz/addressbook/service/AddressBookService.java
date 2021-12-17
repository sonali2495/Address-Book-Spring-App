package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDto;
import com.bridgelabz.addressbook.entity.AddressBook;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService {
    private static final String CONTACT_ADDED_SUCCESSFULLY = "Contact Added Successfully";
    private static final String CONTACT_UPDATED_SUCCESSFULLY = "Contact Updated Successfully";
    private static final String CONTACT_DELETED_SUCCESSFULLY = "Contact Deleted Successfully";

    @Autowired
    private AddressBookRepository addressBookRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<AddressBookDto> getAllContact() {
        return addressBookRepo.findAll()
                .stream()
                .map(AddressBook -> modelMapper.map(AddressBook, AddressBookDto.class))
                .collect(Collectors.toList());
    }

    public AddressBookDto getContactById(int id) {
        findIdPresentOrNot(id);
        AddressBook addressBook = addressBookRepo.findById(id).get();
        return modelMapper.map(addressBook, AddressBookDto.class);
    }

    public AddressBook findIdPresentOrNot(int id) {
        return addressBookRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public String addContact(AddressBookDto addressBookDto) {
        AddressBook addressBook = modelMapper.map(addressBookDto, AddressBook.class);
        addressBookRepo.save(addressBook);
        return CONTACT_ADDED_SUCCESSFULLY;
    }

    public String updateContact(int id, AddressBookDto addressBookDto) {
        AddressBook addressBook = findIdPresentOrNot(id);
        BeanUtils.copyProperties(addressBookDto, addressBook);
        addressBookRepo.save(addressBook);
        return CONTACT_UPDATED_SUCCESSFULLY;
    }

    public String deleteContactById(int id) {
        AddressBook addressBook = findIdPresentOrNot(id);
        addressBookRepo.delete(addressBook);
        return CONTACT_DELETED_SUCCESSFULLY;
    }
}
