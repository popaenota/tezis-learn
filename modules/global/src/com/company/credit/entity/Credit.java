/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

package com.company.credit.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.*;
import com.haulmont.thesis.core.entity.Bank;
import com.haulmont.thesis.core.entity.Correspondent;
import com.haulmont.thesis.core.entity.TsCard;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@DiscriminatorValue("2000")
@Table(name = "CREDIT_CREDIT")
@EnableRestore
@TrackEditScreenHistory
@Entity(name = "credit$Credit")
@Listeners("credit_CreditListener")
@PrimaryKeyJoinColumn(name = "CARD_ID", referencedColumnName = "ID")
@NamePattern("%s|description")
public class Credit extends TsCard {
    private static final long serialVersionUID = 5731133290224853572L;

    @Column(name = "NUMBER_", length = 50)
    protected String number;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GUARANTOR_ID")
    protected Correspondent guarantor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREDIT_TYPE_ID")
    protected CreditType creditType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANK_ID")
    protected Bank bank;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREDIT_DATE")
    protected Date creditDate;

    @Column(name = "SUM_")
    protected BigDecimal sum;

    public Correspondent getGuarantor() {
        return guarantor;
    }

    public void setGuarantor(Correspondent guarantor) {
        this.guarantor = guarantor;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public Date getCreditDate() {
        return creditDate;
    }

    public void setCreditDate(Date creditDate) {
        this.creditDate = creditDate;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public CreditType getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
