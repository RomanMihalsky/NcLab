package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import org.joda.time.LocalDate;

import java.util.function.Predicate;

/**
 *Класс PredicateConditionDateStartOfUse со свойствами <b>dateStartOfUse</b>,<b>dateStartOfUsePredicate</b>
 * @author Roman Mihalsky
 */
public class PredicateConditionDateStartOfUse {
  /**Поле дата создания контракта*/
  private LocalDate dateStartOfUse;

  /**Конструкто для создания PredicateConditionDateStartOfUse с параметрами.
   * @param dateStartOfUse - дата создания контракта
   */
  public PredicateConditionDateStartOfUse(LocalDate dateStartOfUse){
    this.dateStartOfUse = dateStartOfUse;
  }

  /**
   * Predicate для сравнения по критерию - дата создания контракта
   */
  public Predicate<Contract> dateStartOfUsePredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      return contract.getDateStartOfUse().equals(dateStartOfUse);
    }
  };

  /**
   * Функция определения клиента {@link PredicateConditionDateStartOfUse#dateStartOfUse}
   * @param dateStartOfUse - дата создания контракта
   */
  public void setDateStartOfUse(LocalDate dateStartOfUse) {
    this.dateStartOfUse = dateStartOfUse;
  }
}
