package br.com.fiap.listadegastos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

public class GastoAdapter extends BaseAdapter {

    Context context;
    List<Gasto> gastos;

    public GastoAdapter (){
        this.context = context;
        this.gastos = gastos;
    }


    @Override
    public int getCount() {
        return this.gastos.size();
    }

    @Override
    public Object getItem(int i) {
        return (Object) this.gastos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return (long)this.gastos.get(i).getCodigo();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        Gasto gasto = this.gastos.get(i);

        View v = layoutInflater.inflate(R.layout.list_view_gastos,null);
        TextView txvDescricao=(TextView) v.findViewById(R.id.txvDescricao);
        TextView txvdataGasto=(TextView) v.findViewById(R.id.txvdataGasto);
        TextView txvTipoGasto=(TextView) v.findViewById(R.id.txvTipoGasto);
        TextView txvLocalGasto=(TextView) v.findViewById(R.id.txvLocalGasto);
        TextView txvValorGasto=(TextView) v.findViewById(R.id.txvValorGasto);
        TextView txvTipoPagamento=(TextView) v.findViewById(R.id.txvTipoPagamento);

        txvDescricao.setText(gasto.getDescricao());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txvdataGasto.setText(sdf.format(gasto.getDataGasto().getTime()));
        txvTipoGasto.setText(gasto.getTipoGasto());
        txvLocalGasto.setText(gasto.getLocalGasto());
        txvValorGasto.setText(Double.toString(gasto.getValor()));
        txvTipoPagamento.setText(gasto.getTipoPagamento());
        return v;
    }
}
