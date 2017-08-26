package com.krishna.mydemoapp.example.webapi;

import java.util.List;

/**
 * Created by krishna on 2017-08-26.
 */

public class Contacts {
   private List <Person> contacts;

   public List<Person> getContacts() {
      return contacts;
   }

   public void setContacts(List<Person> contacts) {
      this.contacts = contacts;
   }

   public Contacts(List<Person> contacts) {

      this.contacts = contacts;
   }


}
