package com.mf.service;

import com.mf.entity.CustomerReturnList;
import com.mf.entity.PurchaseList;
import com.mf.entity.ReturnList;
import com.mf.entity.SaleList;
import org.springframework.stereotype.Service;

/**
 * 导出相关模块的订单
 */
public interface ExportExcelService {
    /**
     * 导出销售单
     * @return
     */
    public String exportSaleout(SaleList saleList) throws Exception;

    /**
     * 导出客户退货单
     * @return
     */
    public String exportSaleReturn(CustomerReturnList customerReturnList);

    /**
     * 导出商品销售统计
     * @return
     */
    public String exportSale(SaleList saleList,CustomerReturnList customerReturnList);

    /**
     * 导出进货入库单
     * @return
     */
    public String exportPurchase(PurchaseList purchaseList);

    /**
     * 导出退货单
     * @return
     */
    public String exportPurchaseReturn(ReturnList returnList);

    /**
     * 导出商品采购统计
     * @return
     */
    public String exportPurchaseCount(PurchaseList purchaseList,ReturnList returnList);


}
