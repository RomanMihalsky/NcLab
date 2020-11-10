package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;

import java.util.function.Predicate;

/**
 *Класс PredicateConditionId со свойствами <b>id</b>,<b>idPredicate</b>
 * @author Roman Mihalsky
 */
public class PredicateConditionId {
  /**Поле id контракта*/
  private long id;

  /**Конструкто для создания PredicateConditionId с параметрами.
   * @param id - id контракта
   */
  public PredicateConditionId(long id){
    this.id = id;
  }

  /**
   * Predicate для сравнения по критерию - id контракта
   */
  public Predicate<Contract> idPredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      return contract.getId() == id;
    }
  };

  /**
   * Функция определения клиента {@link PredicateConditionId#id}
   * @param id - id контракта
   */
  public void setId(long id) {
    this.id = id;
  }
}
