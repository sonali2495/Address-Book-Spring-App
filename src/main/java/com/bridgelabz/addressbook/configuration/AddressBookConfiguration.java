package com.bridgelabz.addressbook.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Purpose: to configure model mapper
 *
 * @author: Sonali G
 * @since: 13-12-2021
 */

@Configuration
public class AddressBookConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
