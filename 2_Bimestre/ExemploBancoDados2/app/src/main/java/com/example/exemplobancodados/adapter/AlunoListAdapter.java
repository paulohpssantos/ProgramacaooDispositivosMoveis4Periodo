package com.example.exemplobancodados.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exemplobancodados.R;
import com.example.exemplobancodados.model.Aluno;

import java.util.ArrayList;

public class AlunoListAdapter extends
        RecyclerView.Adapter<AlunoListAdapter.AlunoViewHolder>{

    private ArrayList<Aluno> listaAlunos;
    private Context context;

    public AlunoListAdapter(ArrayList<Aluno> listaAlunos, Context context) {
        this.listaAlunos = listaAlunos;
        this.context = context;
    }

    /**
     * Método responsável em carregar o xml para cada elemento da lista
     *
     * @return
     */
    @NonNull
    @Override
    public AlunoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listView = inflater.inflate(R.layout.item_list_aluno,
                parent, false);

        return new AlunoViewHolder(listView);
    }

    /**
     * Escrever os dados do aluno no layout
     */
    @Override
    public void onBindViewHolder(@NonNull AlunoViewHolder holder, int position) {
        Aluno alunoSelecionado = listaAlunos.get(position);
        holder.tvRa.setText(String.valueOf(alunoSelecionado.getRa()));
        holder.tvNome.setText(alunoSelecionado.getNome());
    }

    @Override
    public int getItemCount() {
        return listaAlunos.size();
    }

    public class AlunoViewHolder extends RecyclerView.ViewHolder{

        public TextView tvRa;
        public TextView tvNome;

        public AlunoViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvRa = itemView.findViewById(R.id.tvRa);
            this.tvNome = itemView.findViewById(R.id.tvNome);
        }
    }

}
