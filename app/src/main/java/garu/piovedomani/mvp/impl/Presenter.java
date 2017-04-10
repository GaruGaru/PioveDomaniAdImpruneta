package garu.piovedomani.mvp.impl;

/**
 * Created by Garu on 10/04/2017.
 */

public class Presenter<M, V> {

    private M model;
    private V view;

    public Presenter(M model, V view) {
        this.model = model;
        this.view = view;
    }

    public Presenter(M model) {
        this(model, null);
    }

    public M getModel() {
        return model;
    }

    public V getView() {
        return view;
    }

    public void setView(V view) {
        this.view = view;
    }

    public void setModel(M model) {
        this.model = model;
    }

}
