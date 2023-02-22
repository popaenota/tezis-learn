/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.core.app.reassignment.commands;

import com.haulmont.thesis.core.app.reassignment.commands.AbstractDocReassignmentCommand;
import com.company.credit.entity.CreditOrder;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component(CreditOrderReassignmentCommand.NAME)
public class CreditOrderReassignmentCommand extends AbstractDocReassignmentCommand<CreditOrder> {
    protected static final String NAME = "credit_CreditOrderReassignmentCommand";

    @PostConstruct
    protected void postInit() {
        type = "CreditOrder";
        docQuery = String.format(DOC_QUERY_TEMPLATE, "credit$CreditOrder");
    }

    @Override
    public String getName() {
        return NAME;
    }
}
