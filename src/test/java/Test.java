import com.nc.mihalsky.entities.contracts.Contract;
import com.nc.mihalsky.openers.CsvOpener;
import com.nc.mihalsky.simple.SimpleArrayContract;

public class Test {
  public static void main(String[] args) {
    CsvOpener opener = new CsvOpener();
    SimpleArrayContract<Contract> list = opener.readFileToSimpleList(CsvOpener.CSV_FILE_PATH);
    System.out.println(list);
  }
}
