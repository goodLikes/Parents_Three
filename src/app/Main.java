package app;

import app.model.Model;
import app.presenter.Presenter;
import app.view.IView;
import app.view.View;

public class Main {
    public static void main(String[] args) {
        IView view = new View();  // Ensure View implements IView
        Model model = new Model();  // Ensure Model is defined and implements IModel
        Presenter presenter = new Presenter(model, view);  // Ensure Presenter is correctly constructed
        presenter.start();
    }
}
