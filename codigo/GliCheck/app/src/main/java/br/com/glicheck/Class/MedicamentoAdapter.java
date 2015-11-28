package br.com.glicheck.Class;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.glicheck.R;

/**
 * Created by f.de.souza.filho on 11/25/2015.
 */
public class MedicamentoAdapter extends BaseAdapter {

    Context context;
    List<Medicamento> medicamentos;

    public MedicamentoAdapter(Context ctx, List<Medicamento> medicamentos){

        this.context = context;
        this.medicamentos = medicamentos;

    }

    @Override
    public int getCount() {
        return medicamentos.size();
    }

    @Override
    public Object getItem(int position) {
        return medicamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Medicamento medicamento = medicamentos.get(position);
        View linha = LayoutInflater.from(context).inflate(R.layout.itens_medicamento, null);
        TextView txtNomeMedView = (TextView) linha.findViewById(R.id.txtNomeMedicamentoView);
        TextView txtQuantView = (TextView) linha.findViewById(R.id.txtQuantView);

        Resources res = context.getResources();

        txtNomeMedView.setText(medicamento.nome);
        txtQuantView.setText(String.valueOf(medicamento.quantidade));

        return linha;
    }
}
