package com.company.demo.web.mainwindow;

import com.company.demo.entity.SparePart;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;

import javax.inject.Inject;
import java.util.Map;

public class ExtAppMainWindow extends AppMainWindow {
    @Inject
    private TextField searchTextField;

    @Inject
    private TextField resultTextField;

    @Inject
    private DataManager dataManager;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        searchTextField.addValueChangeListener(e -> {
            if (e.getValue() == null) {
                resultTextField.setValue("N/A");
            } else {
                LoadContext.Query query = new LoadContext.Query(
                        "select e from demo$SparePart e where cast(e.code varchar(10)) = :code");
                query.setParameter("code", e.getValue());
                LoadContext<SparePart> loadContext = LoadContext.create(SparePart.class)
                        .setQuery(query);

                SparePart sparePart = dataManager.load(loadContext);

                if (sparePart == null) {
                    resultTextField.setValue("N/A");
                } else {
                    resultTextField.setValue(sparePart);
                }
            }
        });
    }
}
