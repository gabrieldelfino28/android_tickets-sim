package br.edu.fateczl.ticketsshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbComum;
    private RadioButton rbVIP;
    private EditText inFunc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inFunc = findViewById(R.id.inFuncao);
        inFunc.setVisibility(View.INVISIBLE);

        rbComum = findViewById(R.id.rbComum);
        rbComum.setOnClickListener(check -> checkTicketType());

        rbVIP = findViewById(R.id.rbVIP);
        rbVIP.setOnClickListener(check -> checkTicketType());

        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(compute -> computePrice());
    }

    private final List<String> randomIdTickets = new ArrayList<>();
    private final List<Float> randomTicketPrices = new ArrayList<>();
    //both must have same size;
    private final Random rnd = new Random();

    private void computePrice() {
        fillRandomLists();
        int size = randomIdTickets.size();

        String ticketType = checkTicketType();
        String idTicket = randomIdTickets.get(rnd.nextInt(size));
        float priceTicket = randomTicketPrices.get(rnd.nextInt(size));
        String funcao;
        funcao = inFunc.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("ticketType", ticketType);
        bundle.putString("idTicket", idTicket);
        bundle.putFloat("priceTicket", priceTicket);
        bundle.putString("funcao", funcao);

        sendData(bundle);
    }

    private String checkTicketType() {
        if (rbComum.isChecked()) {
            inFunc.setVisibility(View.INVISIBLE);
            return "Comum";
        }
        if (rbVIP.isChecked()) {
            inFunc.setVisibility(View.VISIBLE);
            return "VIP";
        }
        return null;
    }

    private void fillRandomLists() {
        //Names and IDs
        randomIdTickets.add("ColdPlay-AKS2");
        randomIdTickets.add("LinkinPark-BC2A");
        randomIdTickets.add("ColdPlay-AZ8V");
        randomIdTickets.add("SimplePlan-Z0KV");
        randomIdTickets.add("Crush40-02ZV");
        randomIdTickets.add("MCR-92ZV");

        //Prices
        randomTicketPrices.add(260.50f);
        randomTicketPrices.add(285.50f);
        randomTicketPrices.add(360.25f);
        randomTicketPrices.add(320.50f);
        randomTicketPrices.add(220.75f);
        randomTicketPrices.add(230.50f);
    }

    private void sendData(Bundle b) {
        Intent intent = new Intent(this, OutputActivity.class);
        intent.putExtras(b);
        this.startActivity(intent);
        this.finish();
    }
}