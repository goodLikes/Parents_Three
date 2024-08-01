package Family_Tree;

import Family_Tree.mvp.IModel;
import Family_Tree.mvp.IPresenter;
import Family_Tree.mvp.IView;
import Family_Tree.mvp.Model;
import Family_Tree.mvp.Presenter;
import Family_Tree.mvp.View;

public class Main {
    public static void main(String[] args) {
        IView view = new View();
        IModel model = new Model();
        IPresenter presenter = new Presenter(view, model);
        presenter.start();
    }
}
