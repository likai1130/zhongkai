package com.mf.service;

import com.mf.entity.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * 导出相关模块的订单
 */
public interface ExportExcelService {
    /**
     * 导出销售单
     * @return
     */
    public String exportSaleout(SaleList saleList, HttpServletResponse httpServletResponse) throws Exception;

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
    public String exportPurchase(PurchaseList purchaseList,HttpServletResponse httpServletResponse) throws Exception;

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

    /**
     * 导出库存
     * @param goods
     * @return
     */
    public String exportStock(Goods goods,Integer page,Integer rows,HttpServletResponse httpServletResponse) throws UnsupportedEncodingException, Exception;


}
