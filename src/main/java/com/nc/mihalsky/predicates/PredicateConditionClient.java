package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.persons.Client;

import java.util.function.Predicate;

/**
 *Класс PredicateConditionClient со свойствами <b>client</b>,<b>clientPredicate</b>
 * @author Roman Mihalsky
 */
public class PredicateConditionClient {
  /**Поле клиент*/
  private Client client;

  /**Конструкто для создания PredicateConditionClient с параметрами.
   * @param client - клиент
   */
  public PredicateConditionClient(Client client){
    this.client = client;
  }

  /**
   * Predicate для сравнения по критерию - клиент
   */
  public Predicate<Contract> clientPredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      return contract.getClient().equals(client);
    }
  };

  /**
   * Функция определения клиента {@link PredicateConditionClient#client}
   * @param client - client
   */
  public void setClient(Client client) {
    this.client = client;
  }
}
