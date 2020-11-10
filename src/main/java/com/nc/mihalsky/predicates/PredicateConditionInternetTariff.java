package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.contracts.InternetContract;
import com.nc.mihalsky.entities.contracts.enums.InternetTariff;

import java.util.function.Predicate;

/**
 *Класс PredicateConditionInternetTariff со свойствами <b>internetTariff</b>,<b>internetTariffPredicate</b>
 * @author Roman Mihalsky
 */
public class PredicateConditionInternetTariff {
  /**Поле тариф на интернет*/
  private InternetTariff internetTariff;

  /**Конструкто для создания PredicateConditionInternetTariff с параметрами.
   * @param internetTariff - тариф на интернет
   */
  public PredicateConditionInternetTariff(InternetTariff internetTariff){
    this.internetTariff = internetTariff;
  }

  /**
   * Predicate для сравнения по критерию - тариф на интернет
   */
  public Predicate<Contract> internetTariffPredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      if(contract instanceof InternetContract){
        InternetContract internetContract = (InternetContract)contract;
        return internetContract.getTariff().equals(internetTariff);
      }
      return false;
    }
  };

  /**
   * Функция определения клиента {@link PredicateConditionInternetTariff#internetTariff}
   * @param internetTariff - тариф на интернет
   */
  public void setInternetTariff(InternetTariff internetTariff) {
    this.internetTariff = internetTariff;
  }
}
