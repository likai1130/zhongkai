package zhongkai;

import com.mf.entity.Customer;
import com.mf.entity.Goods;
import com.mf.util.ExcelUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily on 2018/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PoiTest.class)
public class PoiTest {

    @Test
    public void poiTest() {
        String year = "2018";
        String month = "06";
        String day = "02";
        String fileName = String.format("%s年%s月银行结费明细单-%s.xls", year, month, day);
        String sheetName = year + "年" + month + "月" + "银行对账总表";
        String titleName = year + "年" + month + "月" + "银行对账总表";
        String[] headers = {"编号", "客户名称", "联系人", "联系电话", "联系地址","备注"};
        String pattern = "yyyy-MM-dd";
        //List<BalanceAccountExport> balanceAccountExports = iBalanceAccountService.actExportExcel(year, month).getD();
        List<Customer> list = new ArrayList<Customer>();
        Customer customer = new Customer();
        customer.setId(2018071701);
        customer.setName("asfasdfsdf");
        customer.setContact("dasdasd");
        customer.setNumber("sdasdasdas");
        customer.setAddress("dasdasd");
        customer.setRemarks("dasdasd");

        Customer customer2 = new Customer();
        customer2.setId(2018071702);
        customer2.setName("asfasdfsdf");
        customer2.setContact("dasdasd");
        customer2.setNumber("sdasdasdas");
        customer2.setAddress("dasdasd");
        customer2.setRemarks("dasdasd");

        list.add(customer);
        list.add(customer2);
      //  String msg = ExcelUtil.exportExcel(sheetName, titleName, headers, list, pattern, fileName);
      //  System.out.println(msg);
    }
}
