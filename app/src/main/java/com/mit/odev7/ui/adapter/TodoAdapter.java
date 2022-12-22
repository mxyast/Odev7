package com.mit.odev7.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.mit.odev7.R;
import com.mit.odev7.data.entity.ToDo;
import com.mit.odev7.databinding.CardTasarimBinding;
import com.mit.odev7.ui.fragment.AnasayfaFragmentDirections;
import com.mit.odev7.ui.viewmodel.AnasayfaViewModel;

import java.util.List;

public class TodoAdapter extends  RecyclerView.Adapter<TodoAdapter.CardTasarimTutucu>{
    private Context mContext;
    private List<ToDo> toDoListesi;
    private AnasayfaViewModel viewModel;

    public TodoAdapter(Context mContext, List<ToDo> toDoListesi, AnasayfaViewModel viewModel) {
        this.mContext = mContext;
        this.toDoListesi = toDoListesi;
        this.viewModel = viewModel;
    }
    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding binding;
        public CardTasarimTutucu(CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_tasarim,parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        ToDo toDo = toDoListesi.get(position);
        CardTasarimBinding t = holder.binding;
        t.setToDoNesnesi(toDo);

        t.satirCard.setOnClickListener(view -> {
             NavDirections gecis =
                    AnasayfaFragmentDirections.toDoDetayGecis(toDo);
            Navigation.findNavController(view).navigate(gecis);
        });

        t.imageViewSil.setOnClickListener(view -> {
            Snackbar.make(view,toDo.getName()+" silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("EVET",view1 -> {
                        viewModel.sil(toDo.getToDo_id());
                    }).show();
        });
    }

    @Override
    public int getItemCount() {
        return toDoListesi.size();
    }


}
