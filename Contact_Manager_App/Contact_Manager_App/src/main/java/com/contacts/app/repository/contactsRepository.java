package com.contacts.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contacts.app.entity.Person;


public interface contactsRepository extends JpaRepository<Person, Long>{

}
