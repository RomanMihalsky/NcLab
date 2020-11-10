package com.nc.mihalsky.predicates;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.entities.contracts.TvContract;
import com.nc.mihalsky.entities.contracts.enums.TvTariff;

import java.util.function.Predicate;

public class PredicateConditionTvTariff {
  private TvTariff tvTariff;

  public PredicateConditionTvTariff(TvTariff tvTariff){
    this.tvTariff = tvTariff;
  }

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

  public void setTvTariff(TvTariff tvTariff) {
    this.tvTariff = tvTariff;
  }
}
