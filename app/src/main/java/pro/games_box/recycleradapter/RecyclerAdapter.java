package pro.games_box.recycleradapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tesla on 20.03.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{
    // Список с прилетевшими данными
    private static List<RecyclerAdapterItem> mData;
    private final Context mContext;

    public RecyclerAdapter(Context context, List<RecyclerAdapterItem> data) {
        // Конструктор адаптера, если прилетает не иницилизированный список инициализруем его
        mContext = context;
        if (data != null)
            mData = new ArrayList<>(data);
        else mData = new ArrayList<>();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // Холдер который отображает данные одного айтема из списка
        public final TextView title;
        public final TextView description;

        public MyViewHolder(View itemView) {
            super(itemView);
//            Context context = itemView.getContext();
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // При создании холдера, указываем ему разметку и родителя
        final View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_adapter_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // Связываем холдер с данными
        holder.title.setText(mData.get(position).getTitle());
        holder.description.setText(mData.get(position).getDescription());

        // Делаем обработку кликов
        final String title =  holder.title.getText().toString();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Clicked:" + title, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // Не забываем указать количество айтемов в списке
        return mData.size();
    }


}
