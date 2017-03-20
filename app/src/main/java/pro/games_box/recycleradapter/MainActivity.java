package pro.games_box.recycleradapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Список с данными, которые хотим отобразить
    public List<RecyclerAdapterItem> data = new ArrayList<>();
    // Ресакйлер который будет отображить список
    public RecyclerView main_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        main_recycler = (RecyclerView) findViewById(R.id.list);

        // Инициализируем ресайклер
        main_recycler.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        main_recycler.setLayoutManager(llm);

        // Назначаем ему адаптер
        RecyclerAdapter adapter = new RecyclerAdapter(this, data);
        main_recycler.setAdapter(adapter);

    }

    public void initList(){
        // Набиваем список данными для примера
        data.add(new RecyclerAdapterItem(getResources().getStringArray(R.array.news1)[0],
                getResources().getStringArray(R.array.news1)[1]));
        data.add(new RecyclerAdapterItem(getResources().getStringArray(R.array.news2)[0],
                getResources().getStringArray(R.array.news2)[1]));
        data.add(new RecyclerAdapterItem(getResources().getStringArray(R.array.news3)[0],
                getResources().getStringArray(R.array.news3)[1]));
        data.add(new RecyclerAdapterItem(getResources().getStringArray(R.array.news4)[0],
                getResources().getStringArray(R.array.news4)[1]));
        data.add(new RecyclerAdapterItem(getResources().getStringArray(R.array.news5)[0],
                getResources().getStringArray(R.array.news5)[1]));
        data.add(new RecyclerAdapterItem(getResources().getStringArray(R.array.news6)[0],
                getResources().getStringArray(R.array.news6)[1]));
    }
}
