package br.edu.ifsp.ads.pdm.mycontacts.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.edu.ifsp.ads.pdm.mycontacts.databinding.ActivityContactBinding
import br.edu.ifsp.ads.pdm.mycontacts.model.Constant.EXTRA_CONTACT
import br.edu.ifsp.ads.pdm.mycontacts.model.Constant.INVALID_CONTACT_ID
import br.edu.ifsp.ads.pdm.mycontacts.model.Constant.VIEW_CONTACT
import br.edu.ifsp.ads.pdm.mycontacts.model.Contact
import kotlin.random.Random

class ContactActivity : AppCompatActivity() {
    private val acb: ActivityContactBinding by lazy {
        ActivityContactBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(acb.root)

        val receivedContact = intent.getParcelableExtra<Contact>(EXTRA_CONTACT)
        receivedContact?.let { _receivedContact ->
            with(acb) {
                nameEt.setText(_receivedContact.name)
                addressEt.setText(_receivedContact.address)
                phoneEt.setText(_receivedContact.phone)
                emailEt.setText(_receivedContact.email)
            }
        }
        val viewContact = intent.getBooleanExtra(VIEW_CONTACT, false)
        if (viewContact) {
            with(acb) {
                nameEt.isEnabled = false
                addressEt.isEnabled = false
                phoneEt.isEnabled = false
                emailEt.isEnabled = false
                saveBt.visibility = View.GONE
            }
        }

        acb.saveBt.setOnClickListener {
            val contact = Contact(
                id = receivedContact?.id ?: INVALID_CONTACT_ID,
                name = acb.nameEt.text.toString(),
                address = acb.addressEt.text.toString(),
                phone = acb.phoneEt.text.toString(),
                email = acb.emailEt.text.toString(),
            )
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_CONTACT, contact)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}