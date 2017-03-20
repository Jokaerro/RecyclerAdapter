package pro.games_box.recycleradapter;

/**
 * Created by Tesla on 20.03.2017.
 */

public class RecyclerAdapterItem {
    // Модель карточки, которую отображаем
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public RecyclerAdapterItem(String title, String description){
        this.title = title;
        this.description = description;
    }
}
