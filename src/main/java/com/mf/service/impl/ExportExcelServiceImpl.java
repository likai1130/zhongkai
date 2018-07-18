package com.mf.service.impl;

import com.mf.entity.*;
import com.mf.service.ExportExcelService;
import com.mf.service.SaleListGoodsService;
import com.mf.service.SaleListService;
import com.mf.util.DateUtil;
import com.mf.util.ExcelUtil;
import com.mf.vo.SaleOutVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 导出excel的实现类
 */
@Service("exportExcelService")
public class ExportExcelServiceImpl implements ExportExcelService{

    @Autowired
    private SaleListService saleListService;

    @Autowired
    private SaleListGoodsService saleListGoodsService;
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
        String fileName = "（" + start + "至" + end + "）"+ "销售单.xls";
        String titleName = start + "至" + end + "销售单统计";
        String[] headers = {"销售单号", "销售日期", "客户","联系人","联系电话","地址", "粮油编码","粮油名称","规格","单价","数量","整量单位","总金额","应付金额","实付金额","交易状态","备注","操作人"};
        List<SaleList> saleListList=saleListService.list(saleList, Sort.Direction.DESC, "saleDate");
        ArrayList<SaleOutVO> saleOutVOS = new ArrayList<>();
        for (SaleList sale : saleListList){
            Integer saleListId = sale.getId();
            List<SaleListGoods> saleListGoodsList = saleListGoodsService.listBySaleListId(saleListId);
            if (saleListGoodsList.size()>0){
                for (SaleListGoods saleListGoods : saleListGoodsList){
                    SaleOutVO saleOutVO = new SaleOutVO();
                    saleOutVO.setSaleNumber(sale.getSaleNumber());
                    saleOutVO.setSaleDate(sale.getSaleDate());
                    saleOutVO.setCustomerName(sale.getCustomer().getName());
                    saleOutVO.setContact(sale.getCustomer().getContact());
                    saleOutVO.setNumber(sale.getCustomer().getNumber());
                    saleOutVO.setAddress(sale.getCustomer().getAddress());
                    saleOutVO.setCode(saleListGoods.getCode());
                    saleOutVO.setGoodsName(saleListGoods.getName());
                    saleOutVO.setModel(saleListGoods.getModel());
                    saleOutVO.setPrice(saleListGoods.getPrice());
                    saleOutVO.setNum(saleListGoods.getNum());
                    saleOutVO.setUnit(saleListGoods.getUnit());
                    saleOutVO.setTotal(saleListGoods.getTotal());
                    saleOutVO.setAmountPayable(sale.getAmountPayable());
                    saleOutVO.setAmountPaid(sale.getAmountPaid());
                    Integer state = sale.getState();
                    saleOutVO.setState(state == 1 ? "已付" : "未付");
                    saleOutVO.setRemarks(sale.getRemarks());
                    saleOutVO.setUserName(sale.getUser().getUserName());
                    saleOutVOS.add(saleOutVO);
                }
            }
        }
        String msg = ExcelUtil.exportExcel(titleName, titleName, headers, saleOutVOS, "yyyy-MM-dd", fileName);
        return msg;
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
