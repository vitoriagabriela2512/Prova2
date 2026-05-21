package br.ulbra.prova2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtSalario, edtFilhos;
    RadioButton rbMasculino, rbFeminino;
    Button btnCalcular, btnLimpar;
    TextView txtNomeTratado, txtINSS, txtIR, txtSalarioLiquido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtSalario = findViewById(R.id.edtSalario);
        edtFilhos = findViewById(R.id.edtFilhos);

        rbMasculino = findViewById(R.id.rbMasculino);
        rbFeminino = findViewById(R.id.rbFeminino);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);

        txtNomeTratado = findViewById(R.id.txtNomeTratado);
        txtINSS = findViewById(R.id.txtINSS);
        txtIR = findViewById(R.id.txtIR);
        txtSalarioLiquido = findViewById(R.id.txtSalarioLiquido);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularFolha();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });
    }

    private void calcularFolha() {

        try {

            String nome = edtNome.getText().toString().trim();
            String salarioTexto = edtSalario.getText().toString().trim();
            String filhosTexto = edtFilhos.getText().toString().trim();

            if(nome.isEmpty() || salarioTexto.isEmpty() || filhosTexto.isEmpty()){

                txtNomeTratado.setText("Preencha todos os campos!");
                return;

            }

            double salarioBruto = Double.parseDouble(salarioTexto);
            int filhos = Integer.parseInt(filhosTexto);

            if(salarioBruto < 0 || filhos < 0){

                txtNomeTratado.setText("Valores inválidos!");
                return;

            }

            String tratamento = "";

            if(rbMasculino.isChecked()){

                tratamento = "Sr. ";

            }
            else if(rbFeminino.isChecked()){

                tratamento = "Sra. ";

            }
            else{

                txtNomeTratado.setText("Selecione o sexo!");
                return;

            }

            double percentualINSS = 0;

            if(salarioBruto <= 1212.00){

                percentualINSS = 7.5;

            }
            else if(salarioBruto <= 2427.35){

                percentualINSS = 9;

            }
            else if(salarioBruto <= 3641.03){

                percentualINSS = 12;

            }
            else{

                percentualINSS = 14;

            }

            double inss = salarioBruto * percentualINSS / 100;

            double baseIR = salarioBruto - inss;


            double percentualIR = 0;

            if(baseIR <= 1903.98){

                percentualIR = 0;

            }
            else if(baseIR <= 2826.65){

                percentualIR = 7.5;

            }
            else if(baseIR <= 3751.05){

                percentualIR = 15;

            }
            else if(baseIR <= 4664.68){

                percentualIR = 22.5;

            }
            else{

                percentualIR = 27.5;

            }

            double ir = baseIR * percentualIR / 100;

            double salarioFamilia = 0;

            if(salarioBruto <= 1212.00){

                salarioFamilia = filhos * 56.47;

            }

            double salarioLiquido =
                    salarioBruto - inss - ir + salarioFamilia;

            txtNomeTratado.setText(tratamento + nome);

            txtINSS.setText(
                    String.format(Locale.getDefault(),
                            "INSS R$ %.2f", inss));

            txtIR.setText(
                    String.format(Locale.getDefault(),
                            "IR R$ %.2f", ir));

            txtSalarioLiquido.setText(
                    String.format(Locale.getDefault(),
                            "Salário Líquido R$ %.2f",
                            salarioLiquido));

        }
        catch (Exception e){

            txtNomeTratado.setText("Erro nos dados!");

        }

    }

    private void limparCampos() {
        edtNome.setText("");
        edtSalario.setText("");
        edtFilhos.setText("");

        rbMasculino.setChecked(false);
        rbFeminino.setChecked(false);

        txtNomeTratado.setText("Nome do Funcionário");
        txtINSS.setText("INSS R$ 0,00");
        txtIR.setText("IR R$ 0,00");
        txtSalarioLiquido.setText("Salário Líquido R$ 0,00");
    }
}
