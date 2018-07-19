package com.mf.service.impl;

import com.mf.entity.*;
import com.mf.service.*;
import com.mf.util.DateUtil;
import com.mf.util.ExcelUtil;
import com.mf.vo.GoodsVO;
import com.mf.vo.PurchaseVO;
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

    @Autowired
    private PurchaseListService purchaseListService;

    @Autowired
    private PurchaseListGoodsService purchaseListGoodsService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CustomerReturnListGoodsService customerReturnListGoodsService;
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
            if (saleListGoodsList != null && saleListGoodsList.size()>0){
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
    public String exportPurchase(PurchaseList purchaseList) throws Exception {
        Date startDate = purchaseList.getbPurchaseDate();
        Date endDate = purchaseList.getePurchaseDate();
        String start = DateUtil.formatDate(startDate, "yyyy-MM-dd");
        String end = DateUtil.formatDate(endDate, "yyyy-MM-dd");
        String fileName = "（" + start + "至" + end + "）"+ "进货单.xls";
        String titleName = start + "至" + end + "进货单统计";
        String[] headers = {"进货单号", "进货日期", "供应商","联系人","联系电话","地址", "粮油编码","粮油名称","规格","单价","数量","整量单位","零整比","生产日期","总金额","交易状态","备注","操作人"};
        List<PurchaseList> purchaseListList=purchaseListService.list(purchaseList, Sort.Direction.DESC, "purchaseDate");
        ArrayList<PurchaseVO> purchaseVOS = new ArrayList<>();
        for (PurchaseList purchase : purchaseListList){
            List<PurchaseListGoods> purchaseListGoods = purchaseListGoodsService.listByPurchaseListId(purchase.getId());
            if (purchaseListGoods != null && purchaseListGoods.size()>0){
                for (PurchaseListGoods purchaseListGood : purchaseListGoods){
                    PurchaseVO purchaseVO = new PurchaseVO(purchase.getPurchaseNumber(), purchase.getPurchaseDate(), purchase.getSupplier().getName(),
                            purchase.getSupplier().getContact() , purchase.getSupplier().getNumber(), purchase.getSupplier().getAddress(),
                            purchase.getRemarks(), purchase.getUser().getUserName());
                    purchaseVO.setCode(purchaseListGood.getCode());
                    purchaseVO.setGoodsName(purchaseListGood.getName());
                    purchaseVO.setModel(purchaseListGood.getModel());
                    purchaseVO.setPrice(purchaseListGood.getPrice());
                    purchaseVO.setNum(purchaseListGood.getNum());
                    purchaseVO.setUnit(purchaseListGood.getUnit());
                    purchaseVO.setScattered(purchaseListGood.getScattered());
                    purchaseVO.setProduceTime(purchaseListGood.getProduceTime());
                    purchaseVO.setTotal(purchaseListGood.getTotal());
                    purchaseVO.setState(purchase.getState() == 1 ? "已付" : "未付");
                    purchaseVOS.add(purchaseVO);
                }
            }
        }
        String msg = ExcelUtil.exportExcel(titleName, titleName, headers, purchaseVOS, "yyyy-MM-dd", fileName);
        return msg;
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

    /**
     * 导出库存
     * @param goods
     * @return
     */
    @Override
    public String exportStock(Goods goods,Integer page,Integer rows) {
        String fileName = "当前库存统计.xls";
        String titleName ="当前库存统计";
        String[] headers = {"粮油编码", "粮油名称", "类别","规格","整量单位","零整比", "库存数量","销售总数","上次进价","成本均价","出售价格","库存总值","库存下限","生产厂商","备注"};
        ArrayList<GoodsVO> goodsVOS = new ArrayList<>();
        List<Goods> goodsList=goodsService.list(goods, page, rows, Sort.Direction.ASC, "id");//得到goods并便利在t_goods表中（首次进入goods无参数，查询时goods有参数）
        for(Goods g:goodsList){//分别在出售清单和退回清单里查
            g.setSaleTotal(saleListGoodsService.getTotalByGoodsId(g.getId())-customerReturnListGoodsService.getTotalByGoodsId(g.getId())); // 设置销售总量 售出-退回=销售总量
            GoodsVO goodsVO = new GoodsVO(g.getCode(), g.getName(), g.getType().getName(), g.getModel(), g.getUnit(),
                            g.getScattered(), g.getInventoryQuantity(), g.getSaleTotal(), g.getLastPurchasingPrice(),
                            g.getPurchasingPrice(), g.getSellingPrice(), (g.getInventoryQuantity() * g.getPurchasingPrice()), g.getMinNum(), g.getProducer(), g.getRemarks());
            goodsVOS.add(goodsVO);
        }
        String msg = ExcelUtil.exportExcel(titleName, titleName, headers, goodsVOS, "yyyy-MM-dd", fileName);
        return msg;
    }
}
