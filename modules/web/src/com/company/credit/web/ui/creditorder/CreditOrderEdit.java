/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.web.ui.creditorder;

import com.company.credit.entity.Credit;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.thesis.core.entity.Bank;
import com.haulmont.thesis.web.actions.PrintReportAction;
import com.haulmont.thesis.web.ui.basicdoc.editor.AbstractDocEditor;
import com.haulmont.thesis.web.voice.VoiceActionPriorities;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.thesis.core.entity.DocCategory;
import com.company.credit.entity.CreditOrder;

import javax.inject.Inject;
import java.util.Map;

import static com.haulmont.thesis.web.voice.VoiceCompanionsRepository.voiceCompanion;

public class CreditOrderEdit<T extends CreditOrder> extends AbstractDocEditor<T> {

    @Inject
    protected LookupPickerField<DocCategory> docCategory;

    @Inject
    TextField<Bank> creditBank;
    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        initVoiceControl();

        cardDs.addItemPropertyChangeListener(e -> {
            if (e.getProperty().equals("credit")) {
                Credit credit = (Credit) e.getValue();
                if (credit.getBank() != null) {
                    creditBank.setValue(credit.getBank());
                } else {
                    creditBank.setValue(null);
                }
            }
        });
    }

    @Override
    protected String getHiddenTabsConfig() {
        return "processTab,openHistoryTab,securityTab,cardProjectsTab,correspondenceHistoryTab,docTransferLogTab,cardLinksTab,docLogTab,versionsTab";
    }

    @Override
    protected void addPrintDocActions() {
        super.addPrintDocActions();
        printButton.addAction(new PrintReportAction("printExecutionList", this, "printDocExecutionListReportName"));
    }

    protected void initVoiceControl() {
        if (docCategory != null)
        voiceCompanion(docCategory).setPriorityOffset(VoiceActionPriorities.TAB_SHEET + 10);
    }

    @Override
    protected void fillHiddenTabs() {
        hiddenTabs.put("office", getMessage("office"));
        hiddenTabs.put("attachmentsTab", getMessage("attachmentsTab"));
        hiddenTabs.put("docTreeTab", getMessage("docTreeTab"));
        if (getAccessData().getNotVersion()) {
            hiddenTabs.put("cardCommentTab", getMessage("cardCommentTab"));
        }
        super.fillHiddenTabs();
    }
}
