package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginapp.databinding.ActivitySignUpBinding
import okhttp3.*
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject
import java.io.IOException

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val surname = binding.surnameET.text.toString()
            val phoneNumber = binding.phoneNumberEt.text.toString()
            val email = binding.emailEt.text.toString()
            val password = binding.passET.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()


            if (email.isNotEmpty() && password.isNotEmpty() && phoneNumber.isNotEmpty() && surname.isNotEmpty() && name.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (password == confirmPass) {
                    val requestBodyJson = JSONObject().apply {
                        put("name", name)
                        put("surname", surname)
                        put("phoneNumber", phoneNumber)
                        put("email", email)
                        put("password", password)
                        put("confirmPass", confirmPass)

                    }

                    val requestBody = RequestBody.create(
                        "application/json; charset=utf-8".toMediaTypeOrNull(),
                        "{\"name\":\"$name\",\"surname\":\"$surname\",\"phoneNumber\":\"$phoneNumber\",\"email\":\"$email\",\"password\":\"$password\"}"
                    )

                    val request = Request.Builder()
                        .url("http://localhost:8080/auth/register")
                        .post(requestBody)
                        .build()

                        client.newCall(request).enqueue(object : Callback {
                        override fun onFailure(call: Call, e: IOException) {
                            runOnUiThread {
                                Toast.makeText(this@SignUpActivity, "İstek gönderilirken hata oluştu", Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onResponse(call: Call, response: Response) {
                            val responseText = response.body?.string()
                            runOnUiThread {
                                if (response.isSuccessful) {
                                    Toast.makeText(this@SignUpActivity, "Kayıt başarılı!", Toast.LENGTH_SHORT).show()
                                    val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                                    startActivity(intent)
                                } else {
                                    Toast.makeText(this@SignUpActivity, "Kayıt başarısız: $responseText", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    })
                }
                else {
                    Toast.makeText(this@SignUpActivity, "Şifreler eşleşmiyor", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@SignUpActivity, "Boş alanlar kabul edilmez!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
