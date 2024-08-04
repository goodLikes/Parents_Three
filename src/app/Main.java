package app;

import app.model.Model;
import app.presenter.Presenter;
import app.view.IView;
import app.view.View;
import util.FamilyTreeFileHandler;

public class Main {
    public static void main(String[] args) {
        IView view = new View();
        FamilyTreeFileHandler fileHandler = new FamilyTreeFileHandler();  
        Model model = new Model(fileHandler);
        Presenter presenter = new Presenter(model, view);
        presenter.start();
    }
}
