package vcmsa.projects.demoapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Find UI Components by their Ids
        val edtBillAmt = findViewById<EditText>(R.id.editBillAmt)
        val edtTip = findViewById<EditText>(R.id.editTipPercentage)
        val btnCalc = findViewById<Button>(R.id.btnCalc)
        val txtTip=findViewById<TextView>(R.id.txtTip)

        //Set an OnClickListener on the button to perform an action
        btnCalc.setOnClickListener{
            val billAmt = edtBillAmt.text.toString().toDoubleOrNull()?:0.0
            val tipPercent = edtTip.text.toString().toDoubleOrNull()?:0.0
            val tipAmt = billAmt*(tipPercent/100)

            //Display the result
            txtTip.text="Tip Amount: R${String.format("%.2f", tipAmt)}"
        }
    }
}