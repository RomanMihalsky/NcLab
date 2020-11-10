package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import org.joda.time.LocalDate;

import java.util.function.Predicate;

/**
 *Класс PredicateConditionDateEndOfUse со свойствами <b>dateEndOfUse</b>,<b>dateEndOfUsePredicate</b>
 * @author Roman Mihalsky
 */
public class PredicateConditionDateEndOfUse {
  /**Поле дата окончания контракта*/
  private LocalDate dateEndOfUse;

  /**Конструкто для создания PredicateConditionDateEndOfUse с параметрами.
   * @param dateEndOfUse - дата окончания контракта
   */
  public PredicateConditionDateEndOfUse(LocalDate dateEndOfUse){
    this.dateEndOfUse = dateEndOfUse;
  }

  /**
   * Predicate для сравнения по критерию - дата окончания контракта
   */
  public Predicate<Contract> dateEndOfUsePredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      return contract.getDateEndOfUse().equals(dateEndOfUse);
    }
  };

  /**
   * Функция определения клиента {@link PredicateConditionDateEndOfUse#dateEndOfUse}
   * @param dateEndOfUse - дата окончания контракта
   */
  public void setDateEndOfUse(LocalDate dateEndOfUse) {
    this.dateEndOfUse = dateEndOfUse;
  }
}
