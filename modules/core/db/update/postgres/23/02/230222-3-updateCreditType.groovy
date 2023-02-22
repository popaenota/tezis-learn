/*
 * Copyright (c) 2023 LTD Haulmont Samara. All Rights Reserved.
 * Haulmont Samara proprietary and confidential.
 * Use is subject to license terms.
 */

import com.haulmont.cuba.core.EntityManager
import com.haulmont.cuba.core.Persistence
import com.haulmont.cuba.core.Transaction
import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.core.global.Metadata
import com.company.credit.entity.*

postUpdate.add({
    Persistence persistence = AppBeans.get(Persistence.NAME)
    Metadata metadata = AppBeans.get(Metadata.class)
    Transaction tx = persistence.createTransaction()
    try {

        Numerator n = metadata.create(Numerator.class)
        n.code='CreditTypeNumerator'
        n.locName="{\"captionWithLanguageList\":[{\"language\":\"ru\",\"caption\":\"Вид кредита\"},{\"language\":\"en\",\"caption\":\"Credit type\"}]}"
        n.scriptEnabled=false
        n.numeratorFormat='[number]'
        n.periodicity='Y'
        n.numberInitialValue=1
        n.version=0

        def em = persistence.getEntityManager()

        em.persist(n)
        em.flush()
        def numerationService = AppBeans.get(NumerationService.NAME)

        def s = 'Ипотека,Кредит под залог недвижимости, Автокредит, Потребительские,Рефинансирование,Реструктуризация"'
        def b = s.split(',')
        for(int i = 0; i< b.length; i++){
            CreditType creditType = metadata.create(CreditType.class)
            def nextNumber = numerationService.getNextNumber("CreditTypeNumerator")
            creditType.code = nextNumber
            creditType.name = b[i].trim()
            em.persist(creditType)
        }
        tx.commit()
    }
    finally {
        tx.end()
    }
})
