package br.edu.ifsp.ads.pdm.mycontacts.controller

import br.edu.ifsp.ads.pdm.mycontacts.model.dao.ContactDAO
import br.edu.ifsp.ads.pdm.mycontacts.model.database.ContactDAOFirebase
import br.edu.ifsp.ads.pdm.mycontacts.model.entity.Contact
import br.edu.ifsp.ads.pdm.mycontacts.view.MainActivity

class ContactFirebaseController (private val mainActivity: MainActivity) {
    private val contactDaoImpl: ContactDAO = ContactDAOFirebase()

    fun insertContact(contact: Contact) = contactDaoImpl.createContact(contact)
    fun getContact(id: Int) = contactDaoImpl.retrieveContact(id)
    fun getContacts() = mainActivity.updateContactList(contactDaoImpl.retrieveContacts())

    
    fun editContact(contact: Contact) = contactDaoImpl.updateContact(contact)
    fun removeContact(id: Int) = contactDaoImpl.deleteContact(id)
}