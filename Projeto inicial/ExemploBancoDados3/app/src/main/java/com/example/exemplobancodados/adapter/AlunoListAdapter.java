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
        RecyclerView.Adapter<AlunoListAdapter.ViewHolder>{

    private ArrayList<Aluno> listaAlunos;
    private Context context;

    /**
     * Construtor da classe
     * @param listaAlunos: lista que será utilizado para retornar os dados a serem exibidos
     * @param context: onde será exibido a lista
     */
    public AlunoListAdapter(ArrayList<Aluno> listaAlunos, Context context) {
        this.listaAlunos = listaAlunos;
        this.context = context;
    }

    /**
     * Método responsável em carregar o arquivo de layout na tela
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     * @return o arquivo xml com seus componentes
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.item_list_aluno,
                parent, false);

        return new ViewHolder(listItem);
    }

    /**
     * Método que adiciona os dados de Aluno na tela
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Aluno alunoSelecionado = listaAlunos.get(position);
        holder.tvRa.setText(String.valueOf(alunoSelecionado.getRa()));
        holder.tvNome.setText(alunoSelecionado.getNome());
    }

    /**
     * Retorna a quantidade de elementos contidos na lista
     * @return
     */
    @Override
    public int getItemCount() {
        return this.listaAlunos.size();
    }

    /**Classe que vincula o componente do xml para ser manipulado**/
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvRa;
        public TextView tvNome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.tvRa = itemView.findViewById(R.id.tvRa);
            this.tvNome = itemView.findViewById(R.id.tvNome);
        }
    }



}
