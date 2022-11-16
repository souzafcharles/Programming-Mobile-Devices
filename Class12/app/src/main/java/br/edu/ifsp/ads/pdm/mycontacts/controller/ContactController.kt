package br.edu.ifsp.ads.pdm.mycontacts.controller

import br.edu.ifsp.ads.pdm.mycontacts.model.Contact
import br.edu.ifsp.ads.pdm.mycontacts.model.ContactDAO
import br.edu.ifsp.ads.pdm.mycontacts.model.ContactDAOSqlite
import br.edu.ifsp.ads.pdm.mycontacts.view.MainActivity

class ContactController(private val mainActivity: MainActivity) {
    private val contactDAOImp: ContactDAO = ContactDAOSqlite(mainActivity)

    fun insertContact(contact: Contact): Int {
        return contactDAOImp.createContact(contact)
    }

    fun getContact(id: Int) = contactDAOImp.retrieveContact(id)
    fun getContacts() {
        val returnedList = contactDAOImp.retrieveContacts()
        mainActivity.updateContactList(returnedList)
        Thread{
            val returnedList = contactDAOImp.retrieveContacts()
            mainActivity.updateContactList(returnedList)
        }.start()
    }
    fun editContact(contact: Contact) = contactDAOImp.updateContact(contact)
    fun removeContact(id: Int) = contactDAOImp.deleteContact(id)
}