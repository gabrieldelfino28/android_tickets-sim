package br.edu.fateczl.ticketsshow;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.fateczl.ticketsshow.control.IngressoController;
import br.edu.fateczl.ticketsshow.control.IngressoFactory;
import br.edu.fateczl.ticketsshow.control.IngressoVIPController;
import br.edu.fateczl.ticketsshow.model.Ingresso;

public class OutputActivity extends AppCompatActivity {
    private TextView outFinalValue;
    private Ingresso ticket;
    private IngressoFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_output);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        outFinalValue = findViewById(R.id.outputTicket);
        Button btnBack = findViewById(R.id.btnBack);
        computeTicket();
        btnBack.setOnClickListener(back -> backActivity());
    }

    @SuppressWarnings("all")
    private void computeTicket() {
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        assert b != null;

        checkTicketType(b.getString("ticketType"));
        ticket = factory.createIngresso(b.getString("idTicket"), b.getFloat("priceTicket"), b.getString("funcao"));
        computerFinalPrice();
    }

    private void computerFinalPrice() {
        float finalValue = ticket.valorFinal(factory.getTaxaIngresso(/*final TAXA_CONVENIENCIA*/));
        outFinalValue.setText(String.format(getString(R.string.outValue), ticket.toString(), finalValue));
    }

    private void checkTicketType(String type) {
        if (type.equals("Comum")) {
            factory = new IngressoController();
        }
        if (type.equals("VIP")) {
            factory = new IngressoVIPController();
        }
    }

    private void backActivity() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}