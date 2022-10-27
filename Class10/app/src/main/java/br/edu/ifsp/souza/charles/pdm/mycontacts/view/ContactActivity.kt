package br.edu.ifsp.souza.charles.pdm.mycontacts.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.ifsp.souza.charles.pdm.mycontacts.databinding.ActivityContactBinding
import br.edu.ifsp.souza.charles.pdm.mycontacts.model.Constant.EXTRA_CONTACT
import br.edu.ifsp.souza.charles.pdm.mycontacts.model.Contact
import kotlin.random.Random

class ContactActivity : AppCompatActivity() {

    private val acb: ActivityContactBinding by lazy {
        ActivityContactBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(acb.root)

        val receivedContact = intent.getParcelableExtra<Contact>(EXTRA_CONTACT)
        receivedContact?.let{ _receivedContact ->
            with(acb) {
                with(_receivedContact){
                    nameEt.setText(name)
                    addressEt.setText(address)
                    phoneEt.setText(phone)
                    emailEt.setText(email)
                }
            }
        }

        acb.saveBt.setOnClickListener{
            val contact = Contact (
                id = receivedContact?.id?: Random(System.currentTimeMillis()).nextInt(),
                name = acb.nameEt.text.toString(),
                address = acb.addressEt.text.toString(),
                phone = acb.phoneEt.text.toString(),
                email = acb.emailEt.text.toString()
            )
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_CONTACT, contact)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}