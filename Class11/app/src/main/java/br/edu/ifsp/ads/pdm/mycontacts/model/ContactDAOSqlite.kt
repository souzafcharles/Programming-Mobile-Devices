package br.edu.ifsp.ads.pdm.mycontacts.model

import android.content.ContentValues
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import br.edu.ifsp.ads.pdm.mycontacts.R
import java.sql.SQLException

class ContactDAOSqlite(context: Context) : ContactDAO {

    // Companio object can access every thing that is private
    companion object Constant {
        private const val CONTACT_DATABASE_FILE = "contacts"
        private const val CONTACT_TABLE = "contact"
        private const val ID_COLUMN = "id"
        private const val NAME_COLUMN = "name"
        private const val ADDRESS_COLUMN = "address"
        private const val PHONE_COLUMN = "phone"
        private const val EMAIL_COLUMN = "email"

        private const val CREATE_CONTACT_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS $CONTACT_TABLE (" +
                    "$ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "$NAME_COLUMN TEXT NOT NULL, " +
                    "$ADDRESS_COLUMN TEXT NOT NULL, " +
                    "$PHONE_COLUMN TEXT NOT NULL, " +
                    "$EMAIL_COLUMN TEXT NOT NULL);"
    }

    // References to database
    private val contactSQLiteDatabase: SQLiteDatabase

    init {
        // Creating or opening database
        contactSQLiteDatabase = context.openOrCreateDatabase(
            CONTACT_DATABASE_FILE,
            MODE_PRIVATE,
            null
        )
        try {
            contactSQLiteDatabase.execSQL(CREATE_CONTACT_TABLE_STATEMENT)
        } catch (se: SQLException) {
            Log.e(context.getString(R.string.app_name), se.toString())
        }
    }

    private fun Contact.toContentValues() = with(ContentValues()) {
        put(NAME_COLUMN, name)
        put(ADDRESS_COLUMN, address)
        put(PHONE_COLUMN, phone)
        put(EMAIL_COLUMN, email)
        this
    }

    private fun Cursor.rowToContact() = Contact(
        getInt(getColumnIndexOrThrow(ID_COLUMN)),
        getString(getColumnIndexOrThrow(NAME_COLUMN)),
        getString(getColumnIndexOrThrow(ADDRESS_COLUMN)),
        getString(getColumnIndexOrThrow(PHONE_COLUMN)),
        getString(getColumnIndexOrThrow(EMAIL_COLUMN))
    )

    override fun createContact(contact: Contact): Int {
        return contactSQLiteDatabase.insert(
            CONTACT_TABLE, null,
            contact.toContentValues()
        ).toInt()
    }

    override fun retrieveContact(id: Int): Contact? {
        val cursor = contactSQLiteDatabase.rawQuery(
            "SELECT * FROM $CONTACT_TABLE WHERE $ID_COLUMN = ?",
            arrayOf(id.toString())
        )
        val contact = if (cursor.moveToFirst()) {
            cursor.rowToContact()
        } else {
            null
        }
        cursor.close()
        return contact
    }

    override fun retrieveContacts(): MutableList<Contact> {
        val contactList = mutableListOf<Contact>()
        val cursor = contactSQLiteDatabase.rawQuery(
            "SELECT * FROM $CONTACT_TABLE ORDER BY $NAME_COLUMN",
            null
        )
        while (cursor.moveToNext()) {
            contactList.add(cursor.rowToContact())
        }
        return contactList
    }

    override fun updateContact(contact: Contact) = contactSQLiteDatabase.update(
        CONTACT_TABLE,
        contact.toContentValues(),
        "$ID_COLUMN = ?",
        arrayOf(contact.id.toString())
    )


    override fun deleteContact(id: Int) = contactSQLiteDatabase.delete(
        CONTACT_TABLE,
        "$ID_COLUMN = ?",
        arrayOf(id.toString())
    )

}