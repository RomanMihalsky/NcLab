package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;

import java.util.function.Predicate;

/**
 *Класс PredicateConditionClientId со свойствами <b>clientId</b>,<b>clientIdPredicate</b>
 * @author Roman Mihalsky
 */
public class PredicateConditionClientId {
  /**Поле id клиента*/
  private long clientId;

  /**Конструкто для создания PredicateConditionClientId с параметрами.
   * @param clientId - id клиента
   */
  public PredicateConditionClientId(long clientId){
    this.clientId = clientId;
  }

  /**
   * Predicate для сравнения по критерию - клиент id
   */
  public Predicate<Contract> clientIdPredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      return contract.getClient().getId() == clientId;
    }
  };

  /**
   * Функция определения клиента {@link PredicateConditionClientId#clientId}
   * @param clientId - id клиента
   */
  public void setClientId(long clientId) {
    this.clientId = clientId;
  }
}
