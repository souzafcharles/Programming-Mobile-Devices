package br.edu.ifsp.ads.pdm.mycontacts.controller

import br.edu.ifsp.ads.pdm.mycontacts.model.Contact
import br.edu.ifsp.ads.pdm.mycontacts.model.ContactDAO
import br.edu.ifsp.ads.pdm.mycontacts.model.ContactDAOSqlite
import br.edu.ifsp.ads.pdm.mycontacts.view.MainActivity

class ContactController(mainActivity: MainActivity) {
    private val contactDAOImp: ContactDAO = ContactDAOSqlite(mainActivity)

    fun insertContact(contact: Contact): Int {
        return contactDAOImp.createContact(contact)
    }

    fun getContact(id: Int) = contactDAOImp.retrieveContact(id)
    fun getContacts() = contactDAOImp.retrieveContacts()
    fun editContact(contact: Contact) = contactDAOImp.updateContact(contact)
    fun removeContact(id: Int) = contactDAOImp.deleteContact(id)
}