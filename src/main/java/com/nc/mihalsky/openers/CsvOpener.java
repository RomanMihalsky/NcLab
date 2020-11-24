package com.nc.mihalsky.openers;

import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.simple.SimpleListContract;

public class CsvOpener implements Opener{
  public static final String CSV_FILE_PATH = "src\\main\\resources\\csvFile.csv";

  @Override
  public SimpleListContract<Contract> readFileToSimpleList(String fileName) {
    return null;
  }
}
