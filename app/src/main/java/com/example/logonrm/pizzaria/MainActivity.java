package com.example.logonrm.pizzaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.logonrm.pizzaria.model.Pedido;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private String username;

    @BindView(R.id.username)
    TextView tvUsername;

    @BindView(R.id.cbAtum)
    CheckBox cbAtum;

    @BindView(R.id.cbBacon)
    CheckBox cbBacon;

    @BindView(R.id.cbMuca)
    CheckBox cbMuca;

    @BindView(R.id.rgTamanho)
    RadioGroup rgTamanho;

    @BindView(R.id.spPagamentos)
    Spinner spPagamentos;


    Pedido pedido = new Pedido();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (getIntent() != null) {
            username = getIntent().getStringExtra("USERNAME");

            tvUsername.setText(username);
            // R.id.tvAgTimeCasa = timeCasa;

        }

        if (savedInstanceState != null) {
            username = savedInstanceState.getString("USERNAME");

        }

        tvUsername.setText(username);
        setListenerCheckbox(cbAtum);
        setListenerCheckbox(cbBacon);
        setListenerCheckbox(cbMuca);
    }

    private void setListenerCheckbox(final CheckBox checkbox) {
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    pedido.addSabor(checkbox.getText().toString());
                } else {
                    pedido.removeSabor(checkbox.getText().toString());
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("USERNAME", username);
    }

    @OnClick(R.id.btFecharPedido)
    public void fecharPedido() {
        pedido.setCliente(username);
        pedido.setTamanho(getTamanho());
        pedido.setFormaDePgto(spPagamentos.getSelectedItem().toString());

        Intent i = new Intent(this, ConfirmaPedidoActivity.class);
        i.putExtra("PEDIDO", pedido);
        startActivity(i);
    }

    public String getTamanho() {
        return ((RadioButton) findViewById(rgTamanho.getCheckedRadioButtonId())).getText().toString();

    }

}
