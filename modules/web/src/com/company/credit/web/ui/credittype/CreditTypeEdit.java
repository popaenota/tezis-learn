/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.web.ui.credittype;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.PersistenceHelper;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.credit.entity.CreditType;
import com.haulmont.thesis.core.app.NumerationService;
import com.haulmont.thesis.core.entity.Numerator;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CreditTypeEdit<T extends CreditType> extends AbstractEditor<T> {
    @Inject
    protected NumerationService numerationService;


    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
    }
    //2 способа
    //для того чтобы понять что мы создаём сущность, это не эдитор
    @Override
    public void setItem(Entity item) {

        super.setItem(item);

    }

    @Override
    protected void initNewItem(T item) {
        super.initNewItem(item);
        setNumber(item);
    }
    protected void setNumber(Entity entity) {
        LoadContext<Numerator> ctx = new LoadContext<>(Numerator.class);
        ctx.setQueryString("select n from df$Numerator n where n.code=:name").setParameter("name",
                entity.getClass().getSimpleName() + "Numerator");
        List<Numerator> numeratorList = getDsContext().getDataSupplier().loadList(ctx);
        if (!numeratorList.isEmpty()) {
            Numerator numerator = numeratorList.get(0);
            HashMap<String, Object> params = new HashMap<>();
            params.put("entity", getItem());
            entity.setValue("name", "Новый");
            entity.setValue("code", numerationService.getNextNumber(numerator, params));
        }
    }
}
