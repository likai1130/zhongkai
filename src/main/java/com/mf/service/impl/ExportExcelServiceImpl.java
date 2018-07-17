package com.mf.service.impl;

import com.mf.entity.CustomerReturnList;
import com.mf.entity.PurchaseList;
import com.mf.entity.ReturnList;
import com.mf.entity.SaleList;
import com.mf.service.ExportExcelService;
import com.mf.service.SaleListService;
import com.mf.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 导出excel的实现类
 */
@Service("exportExcelService")
public class ExportExcelServiceImpl implements ExportExcelService{

    @Autowired
    private SaleListService saleListService;
    /**
     * 销售单导出
     * @param saleList
     * @return
     */
    @Override
    public String exportSaleout(SaleList saleList) throws Exception {
        Date startDate = saleList.getbSaleDate();
        Date endDate = saleList.geteSaleDate();
        String start = DateUtil.formatDate(startDate, "yyyy-MM-dd");
        String end = DateUtil.formatDate(endDate, "yyyy-MM-dd");
        List<SaleList> saleListList=saleListService.list(saleList, Sort.Direction.DESC, "saleDate");
        String fileName = start + "到" + end + "销售单.xls";
        String title = start + "到" + end + "销售单统计";
        String[] headers = {"编号", "客户名称", "联系人", "联系电话", "联系地址","备注"};

        return null;
    }

    /**
     * 客户退货单
     * @param customerReturnList
     * @return
     */
    @Override
    public String exportSaleReturn(CustomerReturnList customerReturnList) {
        return null;
    }

    /**
     * 销售统计单导出
     * @param saleList
     * @param customerReturnList
     * @return
     */
    @Override
    public String exportSale(SaleList saleList, CustomerReturnList customerReturnList) {
        return null;
    }

    /**
     * 进货单导出
     * @param purchaseList
     * @return
     */
    @Override
    public String exportPurchase(PurchaseList purchaseList) {
        return null;
    }

    /**
     * 退货单导出
     * @param returnList
     * @return
     */
    @Override
    public String exportPurchaseReturn(ReturnList returnList) {
        return null;
    }

    /**
     * 商品采购统计导出
     * @param purchaseList
     * @param returnList
     * @return
     */
    @Override
    public String exportPurchaseCount(PurchaseList purchaseList, ReturnList returnList) {
        return null;
    }
}
