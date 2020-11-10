package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.contracts.TvContract;
import com.nc.mihalsky.entities.contracts.enums.TvTariff;

import java.util.function.Predicate;

/**
 *Класс PredicateConditionTvTariff со свойствами <b>tvTariff</b>,<b>tvTariffPredicate</b>
 * @author Roman Mihalsky
 */
public class PredicateConditionTvTariff {
  /**Поле тариф на телевидение*/
  private TvTariff tvTariff;

  /**Конструкто для создания PredicateConditionTvTariff с параметрами.
   * @param tvTariff - тариф на телевидение
   */
  public PredicateConditionTvTariff(TvTariff tvTariff){
    this.tvTariff = tvTariff;
  }

  /**
   * Predicate для сравнения по критерию - тариф на телевидение
   */
  public Predicate<Contract> tvTariffPredicate = new Predicate<Contract>() {
    @Override
    public boolean test(Contract contract) {
      if(contract instanceof TvContract){
        TvContract tvContract = (TvContract)contract;
        return tvContract.getTariff().equals(tvTariff);
      }
      return false;
    }
  };

  /**
   * Функция определения клиента {@link PredicateConditionTvTariff#tvTariff}
   * @param tvTariff - тариф на телевидение
   */
  public void setTvTariff(TvTariff tvTariff) {
    this.tvTariff = tvTariff;
  }
}
